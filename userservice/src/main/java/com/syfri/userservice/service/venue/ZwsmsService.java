package com.syfri.userservice.service.venue;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.system.ShiroUser;
import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.model.venue.ZwlogVO;
import com.syfri.userservice.model.venue.ZwsmsVO;

public interface ZwsmsService  extends BaseService<ZwsmsVO>{
    public void createZwsmslog(ShiroUser user, ZwjbxxVO vo , QyjbxxVO qvo, SmsSingleSenderResult result);

    int doDeleteByFssj(ZwsmsVO vo);
}