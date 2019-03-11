package com.syfri.gatewayservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.gatewayservice.config.properties.CpjsProperties;
import com.syfri.gatewayservice.utils.Base64ImageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.gatewayservice.model.prediction.QyjsVO;
import com.syfri.gatewayservice.service.prediction.QyjsService;
import com.syfri.gatewayservice.controller.base.BaseController;



@RestController
@RequestMapping("qyjs")
public class QyjsController extends BaseController<QyjsVO> {

    @Autowired
    private QyjsService qyjsService;

    @Override
    public QyjsService getBaseService() {
        return this.qyjsService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;
    /**
     * @Description: 根据企业id获取产品信息
     * @Author: rliu
     * @Date: 2018/10/9 10:35
     */
    @ApiOperation(value = "根据企业id获取产品信息", notes = "vo")
    @RequestMapping("/doFindQyjsById/{qyid}")
    public @ResponseBody ResultVO doFindQyjsById(@PathVariable String qyid) {
        ResultVO resultVO = ResultVO.build();
        try {
            QyjsVO result = qyjsService.doFindById(qyid);
            if (result != null) {
                //将二进制转为Base64格式字符串
                String photo64 = Base64ImageUtil.byteArr2String(result.getLogo());
                result.setLogoBase64(photo64);
            }
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }
}
