package com.syfri.userservice.dao.venue;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.venue.ZwsmsVO;

public interface ZwsmsDAO extends BaseDAO<ZwsmsVO>{

    int doDeleteByFssj(ZwsmsVO vo);
}