package com.syfri.gatewayservice.dao.prediction;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.gatewayservice.model.prediction.QyzwyxVO;

import java.util.List;

public interface QyzwyxDAO extends BaseDAO<QyzwyxVO>{

    /*--根据对象查询记录.--*/
    List<QyzwyxVO> dofindtjfx(QyzwyxVO qyzwyxVO);

    List<QyzwyxVO> dofindtjfxsj(QyzwyxVO qyzwyxVO);

    int doDeleteByVO(QyzwyxVO vo);//按企业id删除

    List<QyzwyxVO> doFindQyzwyxByCplx(QyzwyxVO qyzwyxVO);
}