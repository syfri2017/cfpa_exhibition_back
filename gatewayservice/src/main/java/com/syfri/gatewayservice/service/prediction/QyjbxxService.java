package com.syfri.gatewayservice.service.prediction;

import com.syfri.baseapi.service.BaseService;
import com.syfri.gatewayservice.model.prediction.QyjbxxVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QyjbxxService  extends BaseService<QyjbxxVO>{

    /*--通过用户、企业查询展商信息 by li.xue 2018/10/0 11:13.--*/
    List<QyjbxxVO> doFindZsxxByQyjbxx(QyjbxxVO qyjbxxVO);

    int doDeleteJbxx(List<QyjbxxVO> voList);
    //add by yushch insert返回vo
    QyjbxxVO doInsertJbxxByVO(QyjbxxVO qyjbxxVO);
    //查询邮箱是否被注册过（account表、jbxx表）
    int doSearchCountByMail(String mail);

    //上传图片
    QyjbxxVO uploadPics(MultipartFile multipartFile,QyjbxxVO vo,String fileName);
    //上传pdf
    QyjbxxVO uploadPdfs(MultipartFile multipartFile,QyjbxxVO vo,String fileName);
    String pdf2image(String fileAddress,String savePath,String type);
    //统计分析查询是否信息确认
    List<QyjbxxVO> ifConfirmedTjfx(QyjbxxVO qyjbxxVO);
    //统计分析查询是否信息确认_详情
    List<QyjbxxVO> ifConfirmedTjfxDetail(QyjbxxVO qyjbxxVO);
}