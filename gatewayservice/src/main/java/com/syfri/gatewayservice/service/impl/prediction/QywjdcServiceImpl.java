package com.syfri.gatewayservice.service.impl.prediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.gatewayservice.dao.prediction.QywjdcDAO;
import com.syfri.gatewayservice.model.prediction.QywjdcVO;
import com.syfri.gatewayservice.service.prediction.QywjdcService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qywjdcService")
public class QywjdcServiceImpl extends BaseServiceImpl<QywjdcVO> implements QywjdcService {

	@Autowired
	private QywjdcDAO qywjdcDAO;

	@Override
	public QywjdcDAO getBaseDAO() {
		return qywjdcDAO;
	}
}