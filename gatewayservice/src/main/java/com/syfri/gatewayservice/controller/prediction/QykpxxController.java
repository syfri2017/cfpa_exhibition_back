package com.syfri.gatewayservice.controller.prediction;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.gatewayservice.model.prediction.QykpxxVO;
import com.syfri.gatewayservice.service.prediction.QykpxxService;
import com.syfri.gatewayservice.controller.base.BaseController;

@RestController
@RequestMapping("qykpxx")
public class QykpxxController  extends BaseController<QykpxxVO>{

	@Autowired
	private QykpxxService qykpxxService;

	@Override
	public QykpxxService getBaseService() {
		return this.qykpxxService;
	}

}
