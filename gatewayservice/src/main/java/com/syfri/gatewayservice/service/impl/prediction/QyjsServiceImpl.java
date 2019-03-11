package com.syfri.gatewayservice.service.impl.prediction;

import com.syfri.gatewayservice.dao.prediction.QycpjsDAO;
import com.syfri.gatewayservice.model.prediction.QycpjsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.gatewayservice.dao.prediction.QyjsDAO;
import com.syfri.gatewayservice.model.prediction.QyjsVO;
import com.syfri.gatewayservice.service.prediction.QyjsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyjsService")
public class QyjsServiceImpl extends BaseServiceImpl<QyjsVO> implements QyjsService {

	@Autowired
	private QyjsDAO qyjsDAO;
	@Autowired
	private QycpjsDAO qycpjsDAO;

	@Override
	public QyjsDAO getBaseDAO() {
		return qyjsDAO;
	}

	//add by yushch 20181011
	//插入展商信息及产品信息
	public QyjsVO doInsertQyAndCpByVO(QyjsVO vo){
		qyjsDAO.doInsertByVO(vo);
		List<QycpjsVO> qycpjsVOS = vo.getQycpjsVOList();
		for(int i=0;i<qycpjsVOS.size();i++){
			qycpjsVOS.get(i).setCjrid(vo.getCjrid());
			qycpjsVOS.get(i).setCjrmc(vo.getCjrmc());
			qycpjsDAO.doInsertByVO(qycpjsVOS.get(i));
		}
		//qycpjsDAO.doBatchInsertByList(qycpjsVOS);
		return vo;
	}
	//add by yushch 20181012
	public QyjsVO doUpdateQyCpByVO(QyjsVO vo){
		qyjsDAO.doUpdateByVO(vo);
		//新的产品list
		List<QycpjsVO> qycpjsList = vo.getQycpjsVOList();
		//旧的产品list
		QycpjsVO cpvo = new QycpjsVO();
		cpvo.setQyid(vo.getQyid());
		cpvo.setDeleteFlag("N");
		List<QycpjsVO> qycpjsList_old = qycpjsDAO.doSearchListByVO(cpvo);

		//删除旧的有，新的没有的产品
		for(QycpjsVO vo_old : qycpjsList_old){
			Boolean flag = true;
			for(QycpjsVO vo_new : qycpjsList){
				if(vo_old.getUuid().equals(vo_new.getUuid()) && vo_new.getUuid() != null){
					flag = false;
				}
			}
			if(flag){
				vo_old.setDeleteFlag("Y");
				vo_old.setXgrid(vo.getXgrid());
				vo_old.setXgrmc(vo.getXgrmc());
				qycpjsDAO.doUpdateByVO(vo_old);
			}
		}
		//新增或修改产品
		for(QycpjsVO vo_new : qycpjsList){
			if(!StringUtils.isEmpty(vo_new.getUuid())){
				vo_new.setXgrid(vo.getXgrid());
				vo_new.setXgrmc(vo.getXgrmc());
				qycpjsDAO.doUpdateByVO(vo_new);
			}else {
				vo_new.setQyid(vo.getQyid());
				vo_new.setCjrid(vo.getXgrid());
				vo_new.setCjrmc(vo.getXgrmc());
				qycpjsDAO.doInsertByVO(vo_new);
			}
		}

		return vo;
	}
}