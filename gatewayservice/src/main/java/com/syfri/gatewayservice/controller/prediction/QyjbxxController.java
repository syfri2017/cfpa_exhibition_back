package com.syfri.gatewayservice.controller.prediction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.syfri.gatewayservice.controller.base.BaseController;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.gatewayservice.config.properties.CpjsProperties;
import com.syfri.gatewayservice.model.prediction.QyjbxxVO;
import com.syfri.gatewayservice.service.prediction.QyjbxxService;
import com.syfri.gatewayservice.utils.Base64ImageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("qyjbxx")
public class QyjbxxController extends BaseController<QyjbxxVO> {

    @Autowired
    private QyjbxxService qyjbxxService;

    @Override
    public QyjbxxService getBaseService() {
        return this.qyjbxxService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;

    /**
     * @Description: 根据企业id获取企业信息
     * @Author: rliu
     * @Date: 2018/10/9 10:35
     */
    @ApiOperation(value = "根据企业id获取企业信息", notes = "vo")
    @RequestMapping("/doFindJbxxById/{qyid}")
    public @ResponseBody
    ResultVO doFindJbxxById(@PathVariable String qyid) {
        ResultVO resultVO = ResultVO.build();
        try {
            QyjbxxVO result = qyjbxxService.doFindById(qyid);
            //将二进制转为Base64格式字符串
            String photo64 = Base64ImageUtil.byteArr2String(result.getYyzz());
            result.setYyzzBase64(photo64);
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * @Description: 根据用户信息、公司名称获取企业基本信息
     * @Author: li.xue
     * @Date: 2018/10/9 11:05
     */
    @ApiOperation(value = "根据企业查询企业信息", notes = "列表")
    @ApiImplicitParam(name = "vo", value = "企业对象")
    @PostMapping("/doFindZsxxByQyjbxx")
    public @ResponseBody
    ResultVO doFindZsxxByQyjbxx(@RequestBody QyjbxxVO qyjbxxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            PageHelper.startPage(qyjbxxVO.getPageNum(), qyjbxxVO.getPageSize());
            List<QyjbxxVO> list = qyjbxxService.doFindZsxxByQyjbxx(qyjbxxVO);
            PageInfo<QyjbxxVO> pageInfo = new PageInfo<>(list);
            resultVO.setResult(pageInfo);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    //add by yushch 20181014
    @ApiOperation(value = "根据userid获取企业信息", notes = "vo")
    @PostMapping("/doFindByUserid")
    public @ResponseBody
    ResultVO doFindByUserid(@RequestBody QyjbxxVO vo) {
        ResultVO resultVO = ResultVO.build();
        try {
            QyjbxxVO result = qyjbxxService.doFindByVO(vo);
            if (result != null) {
                //将二进制转为Base64格式字符串
                String photo64 = Base64ImageUtil.byteArr2String(result.getYyzz());
                result.setYyzzBase64(photo64);
            }
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    //查询当前邮箱是否被注册（用户表、基本信息表）
    //add by yushch 20181018
    @ApiOperation(value = "根据邮箱查询用户数量", notes = "查询")
    @ApiImplicitParam(name = "mail", value = "邮箱")
    @GetMapping("/getMailNum/{mail}/static")
    public @ResponseBody
    ResultVO getMailNum(@PathVariable String mail) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyjbxxService.doSearchCountByMail(mail));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    //新建基本信息时营业执照存在根目录下，插入基本信息时移动图片到qyid文件夹下
    //add by yushch 20181102
    @RequestMapping(value = "/movePic")
    public QyjbxxVO movePic(@RequestBody QyjbxxVO vo) {
        // 文件上传固定的路径
        StringBuffer relativePath = new StringBuffer(cpjsProperties.getSavePath());
        StringBuffer new_folder = new StringBuffer();
        new_folder = new StringBuffer(vo.getQyid()).append("/");
        String folderName = relativePath.toString() + new_folder;
        //创建文件夹
        File dir = new File(folderName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(relativePath + vo.getSrc());
        String destinationFloderUrl = new StringBuffer(folderName).append(vo.getSrc()).toString();
        //检查源文件是否合法
        if (file.isFile() && file.exists()) {
            String destinationFile = destinationFloderUrl;
            if (!file.renameTo(new File(destinationFile))) {
                this.logger.error("移动文件失败！");
                return vo;
            }
        } else {
            this.logger.error("要备份的文件路径不正确，移动失败！");
            return vo;
        }
        if (vo.getYyzzgs().equals(".pdf")) {
            String name = vo.getSrc().substring(0, vo.getSrc().lastIndexOf("."));
            String pdfSrc = name + ".pdf";
            File pdfFile = new File(relativePath + pdfSrc);
            String destinationFloderUrl2 = new StringBuffer(folderName).append(pdfSrc).toString();
            //检查源文件是否合法
            if (pdfFile.isFile() && pdfFile.exists()) {
                String destinationFile2 = destinationFloderUrl2;
                if (!pdfFile.renameTo(new File(destinationFile2))) {
                    this.logger.error("移动文件失败！");
                    return vo;
                }
            } else {
                this.logger.error("要备份的文件路径不正确，移动失败！");
                return vo;
            }
        }
        String dbPath = new_folder.append(vo.getSrc()).toString();
        vo.setSrc(dbPath);
        qyjbxxService.doUpdateByVO(vo);
        return vo;
    }

    /**
     * @Description: 统计分析查询是否信息确认
     * @Author: rliu
     * @Date: 2019/1/4 10:35
     */
    @ApiOperation(value = "统计分析查询是否信息确认", notes = "vo")
    @RequestMapping("/ifConfirmedTjfx")
    public @ResponseBody
    ResultVO ifConfirmedTjfx(@RequestBody QyjbxxVO vo) {
        ResultVO resultVO = ResultVO.build();
        try {
            List<QyjbxxVO> result = qyjbxxService.ifConfirmedTjfx(vo);
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /**
     * @Description: 统计分析查询是否信息确认_详情
     * @Author: rliu
     * @Date: 2019/1/7 10:35
     */
    @ApiOperation(value = "统计分析查询是否信息确认_详情", notes = "列表")
    @RequestMapping("/ifConfirmedTjfxDetail")
    public @ResponseBody
    ResultVO ifConfirmedTjfxDetail(@RequestBody QyjbxxVO qyjbxxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            PageHelper.startPage(qyjbxxVO.getPageNum(), qyjbxxVO.getPageSize());
            List<QyjbxxVO> list = qyjbxxService.ifConfirmedTjfxDetail(qyjbxxVO);
            PageInfo<QyjbxxVO> pageInfo = new PageInfo<>(list);
            resultVO.setResult(pageInfo);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
}
