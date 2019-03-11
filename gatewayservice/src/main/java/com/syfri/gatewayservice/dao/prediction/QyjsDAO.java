package com.syfri.gatewayservice.dao.prediction;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.gatewayservice.model.prediction.QyjsVO;

public interface QyjsDAO extends BaseDAO<QyjsVO>{
    int doDeleteByVO(QyjsVO vo);//按企业id删除
}