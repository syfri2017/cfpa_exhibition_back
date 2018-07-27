package com.syfri.digitalplan.service.impl.basicinfo.firestationsource;

import com.syfri.digitalplan.model.basicinfo.firestationsource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.digitalplan.dao.basicinfo.firestationsource.XfdzDAO;
import com.syfri.digitalplan.service.basicinfo.firestationsource.XfdzService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("xfdzService")
public class XfdzServiceImpl extends BaseServiceImpl<XfdzVO> implements XfdzService {

    @Autowired
    private XfdzDAO xfdzDAO;

    @Override
    public XfdzDAO getBaseDAO() {
        return xfdzDAO;
    }

    public XfdzVO doFindDzDetailByVo(XfdzVO xfdzVO) {
        String dzlx = xfdzVO.getDzlx().substring(0, 2);
        XfdzVO vo = new XfdzVO();
        switch (dzlx) {
            case "02":
                vo = xfdzDAO.doFindDzZongDDetailByVo(xfdzVO);
                break;
            case "03":
                vo = xfdzDAO.doFindDzZhiDDetailByVo(xfdzVO);
                break;
            case "05":
                vo = xfdzDAO.doFindDzDaDDetailByVo(xfdzVO);
                break;
            case "09":
                vo = xfdzDAO.doFindDzZhongDDetailByVo(xfdzVO);
                break;
            case "0A":
                vo = xfdzDAO.doFindDzQtxfdwDetailByVo(xfdzVO);
                break;
        }

        return vo;
    }

    public List<XfdzVO> doSearchProvinceList(XfdzVO xfdzVO) {
        List<XfdzVO> vo = xfdzDAO.doSearchProvinceList(xfdzVO);
        return vo;
    }

    /*--通过Dzid查询队站树 by li.xue 2018/7/25.--*/
    public List<XfdzTree> doFindDzTreeByUser(XfdzVO xfdzVO) {
        List<XfdzTree> zongTrees = new ArrayList<>();
        XfdzTree zongTree = new XfdzTree(xfdzVO.getDzid(), xfdzVO.getDzjc(), xfdzVO.getDzbm());
        List<XfdzTree> zhiTrees = xfdzDAO.doFindXfdzBySjdzid(xfdzVO.getDzid());
        List<XfdzTree> zhiChildren = new ArrayList<>();
        for(XfdzTree zhiTree : zhiTrees){
            List<XfdzTree> daTrees = xfdzDAO.doFindXfdzBySjdzid(zhiTree.getDzid());
            List<XfdzTree> daChildren = new ArrayList<>();
            for(XfdzTree daTree : daTrees){
                List<XfdzTree> zhongTrees = xfdzDAO.doFindXfdzBySjdzid(daTree.getDzid());
                if(!zhongTrees.isEmpty()){
                    daTree.setChildren(zhongTrees);
                }
                daChildren.add(daTree);
            }
            if(!daChildren.isEmpty()){
                zhiTree.setChildren(daChildren);
            }
            zhiChildren.add(zhiTree);
        }
        if(!zhiChildren.isEmpty()){
            zongTree.setChildren(zhiChildren);
        }
        zongTrees.add(zongTree);
        return zongTrees;
    }

    /*--新增消防队站 by li.xue 2018/7/25.--*/
    @Override
    public XfdzVO doInsertByXfdzVO(XfdzVO xfdzVO){
        //插入主表
        xfdzDAO.doInsertByVO(xfdzVO);
        //插入从表
        if(!xfdzVO.getDzlx().isEmpty()){
            switch(xfdzVO.getDzlx().substring(0,2)){
                case "02":
                    ZongdVO zongdVO = xfdzVO.getZongdVO();
                    zongdVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doInsertZongdByVO(zongdVO);
                    break;
                case "03":
                    ZhidVO zhidVO = xfdzVO.getZhidVO();
                    zhidVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doInsertZhidByVO(zhidVO);
                    break;
                case "05":
                    DadVO dadVO = xfdzVO.getDadVO();
                    dadVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doInsertDadByVO(dadVO);
                    break;
                case "09":
                    ZhongdVO zhongdVO = xfdzVO.getZhongdVO();
                    zhongdVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doInsertZhongdByVO(zhongdVO);
                    break;
                case "0A":
                    QtxfdwVO qtxfdwVO = xfdzVO.getQtxfdwVO();
                    qtxfdwVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doInsertQtxfdwByVO(qtxfdwVO);
                    break;
            }
        }
        return xfdzVO;
    }

    /*--修改消防队站 by li.xue 2018/7/25.--*/
    @Override
    public XfdzVO doUpdateByXfdzVO(XfdzVO xfdzVO){
        xfdzDAO.doUpdateByVO(xfdzVO);
        if(!xfdzVO.getDzlx().isEmpty()){
            switch(xfdzVO.getDzlx().substring(0,2)){
                case "02":
                    ZongdVO zongdVO = xfdzVO.getZongdVO();
                    zongdVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doUpdateZongdByVO(zongdVO);
                    break;
                case "03":
                    ZhidVO zhidVO = xfdzVO.getZhidVO();
                    zhidVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doInsertZhidByVO(zhidVO);
                    break;
                case "05":
                    DadVO dadVO = xfdzVO.getDadVO();
                    dadVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doUpdateDadByVO(dadVO);
                    break;
                case "09":
                    ZhongdVO zhongdVO = xfdzVO.getZhongdVO();
                    zhongdVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doUpdateZhongdByVO(zhongdVO);
                    break;
                case "0A":
                    QtxfdwVO qtxfdwVO = xfdzVO.getQtxfdwVO();
                    qtxfdwVO.setDzid(xfdzVO.getDzid());
                    xfdzDAO.doUpdateQtxfdwByVO(qtxfdwVO);
                    break;
            }
        }
        return xfdzVO;
    }

    /*--判断队站名称是否存在 by li.xue 2018/7/25.--*/
    @Override
    public int doCheckName(String dzmc){
        return xfdzDAO.doCheckName(dzmc);
    }

    /*--批量删除队站 by li.xue 2018/7/25*/
    @Override
    public int doDeleteBatch(List<XfdzVO> list){
        int deleteNums = 0;
        for(XfdzVO vo : list){
            //删除主表
            vo.setDeleteFlag("Y");
            xfdzDAO.doUpdateByVO(vo);
            //删除从表
            if(!vo.getDzlx().isEmpty()){
                switch(vo.getDzlx().substring(0,2)){
                    case "02":
                        ZongdVO zongdVO = new ZongdVO();
                        zongdVO.setDzid(vo.getDzid());
                        zongdVO.setDeleteFlag("Y");
                        xfdzDAO.doUpdateZongdByVO(zongdVO);
                        break;
                    case "03":
                        ZhidVO zhidVO = new ZhidVO();
                        zhidVO.setDzid(vo.getDzid());
                        zhidVO.setDeleteFlag("Y");
                        xfdzDAO.doUpdateZhidByVO(zhidVO);
                        break;
                    case "05":
                        DadVO dadVO = new DadVO();
                        dadVO.setDzid(vo.getDzid());
                        dadVO.setDeleteFlag("Y");
                        xfdzDAO.doUpdateDadByVO(dadVO);
                        break;
                    case "09":
                        ZhongdVO zhongdVO = new ZhongdVO();
                        zhongdVO.setDzid(vo.getDzid());
                        zhongdVO.setDeleteFlag("Y");
                        xfdzDAO.doUpdateZhongdByVO(zhongdVO);
                        break;
                    case "0A":
                        QtxfdwVO qtxfdwVO = new QtxfdwVO();
                        qtxfdwVO.setDzid(vo.getDzid());
                        qtxfdwVO.setDeleteFlag("Y");
                        xfdzDAO.doUpdateQtxfdwByVO(qtxfdwVO);
                        break;
                }
            }
            deleteNums++;
        }
        return deleteNums;
    }
}