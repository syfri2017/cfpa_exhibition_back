package com.syfri.gatewayservice.controller.prediction;

import com.syfri.gatewayservice.config.properties.CpjsProperties;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.gatewayservice.model.prediction.QycpjsVO;
import com.syfri.gatewayservice.service.prediction.QycpjsService;
import com.syfri.gatewayservice.controller.base.BaseController;


@RestController
@RequestMapping("qycpjs")
public class QycpjsController extends BaseController<QycpjsVO> {

    @Autowired
    private QycpjsService qycpjsService;

    @Override
    public QycpjsService getBaseService() {
        return this.qycpjsService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;

}
