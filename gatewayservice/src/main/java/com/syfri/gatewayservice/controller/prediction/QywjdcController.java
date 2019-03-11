package com.syfri.gatewayservice.controller.prediction;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.gatewayservice.model.prediction.QywjdcVO;
import com.syfri.gatewayservice.service.prediction.QywjdcService;
import com.syfri.gatewayservice.controller.base.BaseController;

@RestController
@RequestMapping("qywjdc")
public class QywjdcController  extends BaseController<QywjdcVO>{

	@Autowired
	private QywjdcService qywjdcService;

	@Override
	public QywjdcService getBaseService() {
		return this.qywjdcService;
	}
}
