package com.syfri.gatewayservice.service.impl.prediction;

import com.syfri.gatewayservice.model.prediction.QyjbxxVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.gatewayservice.dao.prediction.QyzwyxDAO;
import com.syfri.gatewayservice.model.prediction.QyzwyxVO;
import com.syfri.gatewayservice.service.prediction.QyzwyxService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyzwyxService")
public class QyzwyxServiceImpl extends BaseServiceImpl<QyzwyxVO> implements QyzwyxService {

	@Autowired
	private QyzwyxDAO qyzwyxDAO;

	@Override
	public QyzwyxDAO getBaseDAO() {
		return qyzwyxDAO;
	}
	/*
	 * @Description:
	 * @Param:
	 * @Return:
	 * @Author: zhaijianchen
	 * @Modified By:
	 * @Date: 2018/10/9 13:53
	 */
	/*--查询：统计分析数据.--*/
	@Override
	public List<QyzwyxVO> dofindtjfx(QyzwyxVO qyzwyxVO){
		return qyzwyxDAO.dofindtjfx(qyzwyxVO);
	}

	/*
	 * @Description:
	 * @Param:
	 * @Return:
	 * @Author: zhaijianchen
	 * @Modified By:
	 * @Date: 2018/10/10 14:33
	 */
	/*--查询：统计分析数据.--*/
	@Override
	public List<QyzwyxVO> dofindtjfxsj(QyzwyxVO qyzwyxVO){
		return qyzwyxDAO.dofindtjfxsj(qyzwyxVO);
	}

	public List<QyzwyxVO> doFindQyzwyxByCplx(QyzwyxVO qyzwyxVO){
		return qyzwyxDAO.doFindQyzwyxByCplx(qyzwyxVO);
	}
}