package com.syfri.userservice.service.impl.venue;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.system.ShiroUser;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.model.venue.ZwlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.venue.ZwsmsDAO;
import com.syfri.userservice.model.venue.ZwsmsVO;
import com.syfri.userservice.service.venue.ZwsmsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("zwsmsService")
public class ZwsmsServiceImpl extends BaseServiceImpl<ZwsmsVO> implements ZwsmsService {

	@Autowired
	private ZwsmsDAO zwsmsDAO;

	public ZwsmsDAO getBaseDAO() {
		return zwsmsDAO;
	}

	public void createZwsmslog(ShiroUser user, ZwjbxxVO vo, QyjbxxVO qvo, SmsSingleSenderResult result) {
		ZwsmsVO zs=new ZwsmsVO();
		zs.setCjrid(user.getUserid());
		zs.setCjrmc(user.getUsername());
		zs.setZwh(vo.getZwh());
		zs.setZwuuid(vo.getUuid());
		zs.setSjhm(qvo.getLxrsj());
		zs.setQyid(qvo.getQyid());
		zs.setErrmsg(result.errMsg);
		zs.setSid(result.sid);
		zs.setFee(result.fee+"");
		zs.setExt(result.ext);
		zs.setResult(result.result+"");
		zs.setFssj(new Date());
		zwsmsDAO.doInsertByVO(zs);
	}
}