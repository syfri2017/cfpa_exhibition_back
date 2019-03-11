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
}
