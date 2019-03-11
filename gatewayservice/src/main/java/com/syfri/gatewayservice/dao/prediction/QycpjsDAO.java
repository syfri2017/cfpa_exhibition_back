package com.syfri.gatewayservice.dao.prediction;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.gatewayservice.model.prediction.QycpjsVO;

public interface QycpjsDAO extends BaseDAO<QycpjsVO>{
    int doDeleteByVO(QycpjsVO vo);//按企业id删除


}