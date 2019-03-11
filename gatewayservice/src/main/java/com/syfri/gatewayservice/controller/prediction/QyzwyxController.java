package com.syfri.gatewayservice.controller.prediction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.gatewayservice.model.prediction.QyzwyxVO;
import com.syfri.gatewayservice.service.prediction.QyzwyxService;
import com.syfri.gatewayservice.controller.base.BaseController;


import java.util.List;

@RestController
@RequestMapping("qyzwyx")
public class QyzwyxController extends BaseController<QyzwyxVO> {

    @Autowired
    private QyzwyxService qyzwyxService;

    @Override
    public QyzwyxService getBaseService() {
        return this.qyzwyxService;
    }

    /*
     * @Description:统计分析图表数据
     * @Param:
     * @Return:
     * @Author: zhaijianchen
     * @Modified By:
     * @Date: 2018/10/9 13:38
     */

    @ApiOperation(value = "统计分析图表数据", notes = "统计分析图表数据")
    @ApiImplicitParam(name = "vo", value = "统计分析图表数据")
    @PostMapping("/dofindtjfx")
    public @ResponseBody
    ResultVO dofindtjfx(@RequestBody QyzwyxVO qyzwyxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyzwyxService.dofindtjfx(qyzwyxVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    /*
     * @Description:
     * @Param:
     * @Return:
     * @Author: zhaijianchen
     * @Modified By:
     * @Date: 2018/10/10 14:31
     */
    @ApiOperation(value = "统计分析图表数据", notes = "统计分析图表数据")
    @ApiImplicitParam(name = "vo", value = "统计分析图表数据")
    @PostMapping("/dofindtjfxsj")
    public @ResponseBody
    ResultVO dofindtjfxsj(@RequestBody QyzwyxVO qyzwyxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            resultVO.setResult(qyzwyxService.dofindtjfxsj(qyzwyxVO));
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
    @ApiOperation(value = "产品类型下企业信息", notes = "查询")
    @ApiImplicitParam(name = "vo", value = "产品类型下企业信息")
    @PostMapping("/doFindQyzwyxByCplx")
    public @ResponseBody
    ResultVO doFindQyzwyxByCplx(@RequestBody QyzwyxVO qyzwyxVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            PageHelper.startPage(qyzwyxVO.getPageNum(), qyzwyxVO.getPageSize());
            List<QyzwyxVO> list = qyzwyxService.doFindQyzwyxByCplx(qyzwyxVO);
            PageInfo<QyzwyxVO> pageInfo = new PageInfo<>(list);
            resultVO.setResult(pageInfo);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
}
