package com.syfri.userservice.controller.venue;

import com.syfri.baseapi.model.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.venue.ZwsmsVO;
import com.syfri.userservice.service.venue.ZwsmsService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("zwsms")
public class ZwsmsController  extends BaseController<ZwsmsVO>{

	@Autowired
	private ZwsmsService zwsmsService;

	@Override
	public ZwsmsService getBaseService() {
		return this.zwsmsService;
	}

	@PostMapping("doDeleteByFssj")
	public @ResponseBody
	ResultVO doDeleteByFssj(@RequestBody ZwsmsVO vo) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(zwsmsService.doDeleteByFssj(vo));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
		}
		return resultVO;
	}

}
