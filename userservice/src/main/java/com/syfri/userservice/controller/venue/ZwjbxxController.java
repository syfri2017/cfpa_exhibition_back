package com.syfri.userservice.controller.venue;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.baseapi.utils.MathUtil;
import com.syfri.userservice.config.properties.BoothMsgProperties;
import com.syfri.userservice.config.properties.MsgProperties;
import com.syfri.userservice.controller.prediction.QyjbxxController;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.venue.*;
import com.syfri.userservice.service.impl.venue.ZwlogServiceImpl;
import com.syfri.userservice.service.prediction.QyjbxxService;
import com.syfri.userservice.service.venue.*;
import com.syfri.userservice.utils.CurrentUserUtil;
import com.syfri.userservice.utils.ExcelUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.syfri.baseapi.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.URLEncoder;

@RestController
@RequestMapping("zwjbxx")
public class ZwjbxxController  extends BaseController<ZwjbxxVO>{

	@Autowired
	private ZwjbxxService zwjbxxService;
	@Autowired
	private ZwlogService zwlogService;
	@Autowired
	private ZwsmsService zwsmsService;
	@Autowired
	private QyjbxxService qyjbxxService;
	@Autowired
	private ZgjbxxService zgjbxxService;
	@Autowired
	private BoothMsgProperties boothMsgProperties;
	@Autowired
	private ZwmkService zwmkService;
	@Override
	public ZwjbxxService getBaseService() {
		return this.zwjbxxService;
	}
	@PostMapping("isInternal")
	public @ResponseBody
	boolean isInternal() {
		QyjbxxVO qy=new QyjbxxVO();
		qy.setUserid(CurrentUserUtil.getCurrentUserId());
		QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
		if(qvo!=null&&qvo.getReserve3()!=null){
			return true;
		}else{
			return false;
		}
	}
	@PostMapping("getNow")
	public @ResponseBody
	String getNow() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 *获取当前用户选择展位信息
	 * @return
	 */
	@PostMapping("getSelectedPos")
	public @ResponseBody
	ResultVO getSelectedPos() {
		ResultVO resultVO = ResultVO.build();
		try {
			QyjbxxVO qy=new QyjbxxVO();
			qy.setUserid(CurrentUserUtil.getCurrentUserId());
			QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
			if(qvo!=null&&qvo.getQyid()!=null){
				ZwjbxxVO vo=new ZwjbxxVO();
				vo.setQyid(qvo.getQyid());
				List<ZwjbxxVO> dvo=zwjbxxService.doSearchListByVO(vo);
				resultVO.setResult(dvo);
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}
	/**
	 * 获取所有企业信息包含企业名称
	 * @param vo
	 * @return
	 */
	@PostMapping("doSearchListByVO")
	public @ResponseBody
	ResultVO doSearchListByVO(@RequestBody ZwjbxxVO vo ) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(zwjbxxService.doSearchListQyByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 获取带有企业信息的展位信息
	 * 注意：这里通过知否含有zgid判断是否获取真实的展位数据
	 * @param vo
	 * @return
	 */
	@PostMapping("doSearchListQyByVO")
	public @ResponseBody
	ResultVO doSearchListQyByVO(@RequestBody ZwjbxxVO vo ) {
		ResultVO resultVO = ResultVO.build();
		try {
			PageInfo<ZwjbxxVO> pis= zwjbxxService.doSearchQyPage(vo);
			List<ZwjbxxVO> zwjbxxVOs=pis.getList();
			for(ZwjbxxVO zwjbxxVO:zwjbxxVOs){
				//匹配展位状态代码名称
				zwjbxxVO.setZwztmc(zwzt2Mc(zwjbxxVO.getZwzt()));
			}
			resultVO.setResult(pis);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 状态转换，目前使用写死的方式
	 * @param zhzt
	 * @return
	 */
	private String zwzt2Mc(String zhzt){
		if("normal".equals(zhzt)){  //新建展位
			return "新建展位";
		}if("allotted".equals(zhzt)){//已分配展位
			return "已分配展位";
		}if("bespoke".equals(zhzt)){//已预定展位
			return "已预定展位";
		}if("completed".equals(zhzt)){//已确定展位
			return "已确定展位";
		}
		return null;
	}

	/**
	 * 使用先删除后插入的方式修改
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	@ApiOperation(value="根据VO保存",notes="注意事项")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doInsertByVO")
	public @ResponseBody ResultVO doInsertByVO(@RequestBody ZgZwsVO zgZwsVO)throws Exception{
		ResultVO resultVO = ResultVO.build();
		List<ZwjbxxVO> zwjbxxVOs=zgZwsVO.getZwjbxxVOs();
		ZgjbxxVO gvo=zgZwsVO.getZgjbxxVO();
		try {
			//保存展位信息
			if(zwjbxxVOs.size()>0){
				//删除展位
				ZwjbxxVO zw=new ZwjbxxVO();
				zw.setZgid(zwjbxxVOs.get(0).getZgid());
				zwjbxxService.doDeleteByVO(zw);
				for(ZwjbxxVO vo : zwjbxxVOs){
					if(vo.getUuid()!=null&&!vo.getUuid().equals("")){
						vo.setUuid(null);
					}
					vo.setCjrid(CurrentUserUtil.getCurrentUserId());
					vo.setCjrmc(CurrentUserUtil.getCurrentUserName());
					zwjbxxService.doInsertByVO(vo);
					zwlogService.createZwlog(null,vo, ZwlogServiceImpl.INSERT,"doInsertByVO");
				}
			}
			//保存展馆信息
			if(gvo.getUuid()!=null&&!"".equals(gvo.getUuid())){
				gvo.setXgrid(CurrentUserUtil.getCurrentUserId());
				gvo.setXgrmc(CurrentUserUtil.getCurrentUserName());
				zgjbxxService.doUpdateByVO(gvo);
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}

		return 	resultVO;
	}

	/**
	 * 使用先删除后插入的方式修改
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	@ApiOperation(value="根据VO保存",notes="注意事项")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doSaveByVO")
	public @ResponseBody ResultVO doSaveByVO(@RequestBody ZwZwmkVO zwZwmkVO)throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			if(zwZwmkVO.getZwjbxxVO()!=null&&zwZwmkVO.getZwmkVO()!=null){
				//保存展位信息
				ZwjbxxVO vo=zwZwmkVO.getZwjbxxVO();
				ZwmkVO vo1=zwZwmkVO.getZwmkVO();
				ZwjbxxVO zw=zwjbxxService.doFindById(vo.getUuid());
				ZwmkVO s=new ZwmkVO();
				s.setShapeUuid(vo1.getShapeUuid());
				ZwmkVO mk=zwmkService.doFindByVO(s);
				//保存展位模块信息
				if(zw!=null&&mk!=null){
					vo.setXgrid(CurrentUserUtil.getCurrentUserId());
					vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
					vo1.setXgrid(CurrentUserUtil.getCurrentUserId());
					vo1.setXgrmc(CurrentUserUtil.getCurrentUserName());
					zwmkService.doUpdateByVO(vo1);
					zwjbxxService.doUpdateByVO(vo);
					zwlogService.createZwlog(zw,vo, ZwlogServiceImpl.UPDATE,"doSaveByVO");
				}else{
					vo.setCjrid(CurrentUserUtil.getCurrentUserId());
					vo.setCjrmc(CurrentUserUtil.getCurrentUserName());
					vo1.setCjrid(CurrentUserUtil.getCurrentUserId());
					vo1.setCjrmc(CurrentUserUtil.getCurrentUserName());
					vo.setUuid(null);
					vo1.setUuid(null);
					zwmkService.doInsertByVO(vo1);
					zwjbxxService.doInsertByVO(vo);
					zwlogService.createZwlog(null,vo, ZwlogServiceImpl.INSERT,"doSaveByVO");
				}
				resultVO.setResult(vo);
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}

		return 	resultVO;
	}
	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	@ApiOperation(value="根据VO删除",notes="注意事项")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doDelByVO")
	public @ResponseBody ResultVO doDelByVO(@RequestBody ZwZwmkVO zwZwmkVO)throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {

			if(zwZwmkVO.getZwjbxxVO()!=null&&zwZwmkVO.getZwmkVO()!=null){
				//删除展位信息
				ZwjbxxVO vo=zwZwmkVO.getZwjbxxVO();
				vo.setXgrid(CurrentUserUtil.getCurrentUserId());
				vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
				vo.setDeleteFlag("Y");
				//删除展位模块
				ZwmkVO vo1=zwZwmkVO.getZwmkVO();
				vo1.setXgrid(CurrentUserUtil.getCurrentUserId());
				vo1.setXgrmc(CurrentUserUtil.getCurrentUserName());
				vo1.setDeleteFlag("Y");
				zwmkService.doUpdateByVO(vo1);
				zwjbxxService.doUpdateByVO(vo);
				zwlogService.createZwlog(null,vo, ZwlogServiceImpl.UPDATE,"doDelByVO");
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return 	resultVO;
	}


	/**
	 * 选展位
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doUpdateByVO")
	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	public @ResponseBody ResultVO doUpdateByVO(@RequestBody ZwjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			//判断前台是否传过来UUID值
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
				String userId=CurrentUserUtil.getCurrentUserId();
				QyjbxxVO qy =new QyjbxxVO();
				qy.setUserid(userId);
				QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
				if(!qvo.getShzt().equals("03")){
					resultVO.setMsg("你还未通过审核，审核通过后方可选展位");
					return 	resultVO;
				}
//				if(qvo.getReserve3()==null||qvo.getReserve3().isEmpty()){
//					resultVO.setMsg("当前展位不可选，请联系组委会");
//					return 	resultVO;
//				}
				//获取已选展位数量
				ZwjbxxVO vo1=new ZwjbxxVO();
				vo1.setQyid(qvo.getQyid());
				List<ZwjbxxVO> dvo1=zwjbxxService.doSearchListByVO(vo1);
				//限制每个用户只能选2个展位
				if(dvo1.size()>1){
					resultVO.setMsg("当前用户选择展位数量已达限额！");
					return 	resultVO;
				}
				//判断是否存在企业信息
				if(qvo.getQyid()!=null&&!"".equals(qvo.getQyid())){
					ZwjbxxVO dbzw=zwjbxxService.doFindById(vo.getUuid());
					//判断是否展位是未预定状态
					if(dbzw.getZwzt()!=null&&"normal".equals(dbzw.getZwzt())){
						vo.setQyid(qvo.getQyid());
						vo.setZwzt("bespoke");
						vo.setXgrid(CurrentUserUtil.getCurrentUserId());
						vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
						zwjbxxService.doUpdateByVO(vo);
						ZwjbxxVO newdbzw=zwjbxxService.doFindById(vo.getUuid());
						String phone=qvo.getLxrsj();
						//发短信开始
						if(!(phone.equals("")||null == phone)) {
							SmsSingleSender sender;
							try {
								sender = new SmsSingleSender(boothMsgProperties.getAppId(), boothMsgProperties.getAppKey());
								ArrayList<String> params = new ArrayList<String>();
								params.add(newdbzw.getZwh());
								params.add(newdbzw.getZwmj());
								SmsSingleSenderResult result = sender.sendWithParam("86", phone, boothMsgProperties.getTemplId(), params, "", "", "");
								zwsmsService.createZwsmslog(CurrentUserUtil.getCurrentUser(),newdbzw,qvo,result);
								if (result.result == 0) {
									resultVO.setCode(EConstants.CODE.SUCCESS);
								}
							} catch (Exception e) {
								e.printStackTrace();

							}
						}
						//发短信结束
						resultVO.setResult(newdbzw);
						resultVO.setMsg("success");
						zwlogService.createZwlog(dbzw,newdbzw, ZwlogServiceImpl.UPDATE,"doUpdateByVO");
					}else{
						resultVO.setResult(dbzw);
						resultVO.setMsg("展位已经被预定，请重新选择！");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setMsg("选择展位失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
			return 	resultVO;
		}
		return 	resultVO;
	}
	/**
	 * 指定展位
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doAssign")
	@Transactional
	public @ResponseBody ResultVO doAssign(@RequestBody ZwjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			//判断前台是否传过来UUID值
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
				QyjbxxVO qvo = new QyjbxxVO();
				if(vo.getQyid()!=null&&!"".equals(vo.getQyid())){
					QyjbxxVO qy =new QyjbxxVO();
					qy.setQyid(vo.getQyid());
					qvo=qyjbxxService.doFindByVO(qy);
					//判断是否存在企业信息
					if(qvo.getQyid()!=null&&!"".equals(qvo.getQyid())){
						ZwjbxxVO dbzw=zwjbxxService.doFindById(vo.getUuid());
						//判断是否展位是未预定状态
						vo.setQyid(qvo.getQyid());
						vo.setZwzt("bespoke");
						vo.setXgrid(CurrentUserUtil.getCurrentUserId());
						vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
						zwjbxxService.doUpdateByVO(vo);
						ZwjbxxVO newdbzw=zwjbxxService.doFindById(vo.getUuid());
						resultVO.setResult(newdbzw);
						resultVO.setMsg("success");
						zwlogService.createZwlog(dbzw,newdbzw, ZwlogServiceImpl.UPDATE,"doAssign");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setMsg("指定展位失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
			return 	resultVO;
		}
		return 	resultVO;
	}
	/**
	 * 取消展位选择
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doCancelByVO")
	@Transactional
	public @ResponseBody ResultVO doCancelByVO(@RequestBody ZwjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			//判断前台是否传过来UUID值
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
				ZwjbxxVO dbzw=zwjbxxService.doFindById(vo.getUuid());
				if(dbzw.getZwzt()!="normal"&&dbzw.getQyid()!=null){
					vo.setQyid("");
					vo.setZwzt("normal");
					vo.setReserve2("");
					vo.setXgrid(CurrentUserUtil.getCurrentUserId());
					vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
					zwjbxxService.doUpdateByVO(vo);
					ZwjbxxVO newdbzw=zwjbxxService.doFindById(vo.getUuid());
					resultVO.setResult(newdbzw);
					resultVO.setMsg("success");
					zwlogService.createZwlog(dbzw,newdbzw, ZwlogServiceImpl.UPDATE,"doCancelByVO");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setMsg("选择展位失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
			return 	resultVO;
		}
		return 	resultVO;
	}
	@ApiOperation(value = "导出展位基本信息", notes = "导出")
	@RequestMapping(value = "/doExport/{param}", method = RequestMethod.GET)
	public void doExport(HttpServletRequest request, HttpServletResponse response, @PathVariable String [] param) {
		//解析param zwh&zwzt&qymc&zwlb&cklx
		ZwjbxxVO vo = new ZwjbxxVO();
		vo.setZwh(param[0]);
		vo.setZwzt(param[1]);
		vo.setQymc(param[2]);
		vo.setZwlb(param[3]);
		vo.setCklx(param[4]);

		//excel标题
		String[] title = {"展位号","公司名称","展位面积(m²)","展位类型","出口类型","展位状态","联系人名称","联系人电话","联系地址","办公电话","电子邮箱"};
		//columns列
		String[] columns = {"zwh","qymc","zwmj","zwlb","cklx","zwztmc","lxr","lxrsj","yjdzxx","bgdh","dzyx"};
		//excel文件名
		String fileName = "展位管理" + System.currentTimeMillis() + ".xls";
		//sheet名
		String sheetName = "展位管理";

		//获取数据
		List<ZwjbxxVO> dataList = zwjbxxService.doSearchListQyByVO(vo);
		for(ZwjbxxVO zwjbxxVO : dataList){
			//匹配展位状态代码名称
			zwjbxxVO.setZwztmc(zwzt2Mc(zwjbxxVO.getZwzt()));
		}
		this.doExportExcel(request, response, fileName, sheetName, title, columns, dataList);
	}

	/**
	 * 企业选择的展位数量从大到小进行排序 by li.xue 2018/12/29
	 * @param zwjbxxVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doFindQyZwNumDesc")
	public @ResponseBody ResultVO doFindQyZwNumDesc(@RequestBody ZwjbxxVO zwjbxxVO){
		ResultVO resultVO = ResultVO.build();
		try {
			PageHelper.startPage(zwjbxxVO.getPageNum(), zwjbxxVO.getPageSize());
			List<ZwjbxxVO> list= zwjbxxService.doFindQyZwNumDesc(zwjbxxVO);
			PageInfo<ZwjbxxVO> pageInfo = new PageInfo<>(list);
			resultVO.setResult(pageInfo);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	//add by yushch 分析页面导出功能
	@ApiOperation(value = "导出展位分析", notes = "导出")
	@RequestMapping(value = "/doExporTanalysis/{param}", method = RequestMethod.GET)
	public void doExporTanalysis(HttpServletRequest request, HttpServletResponse response, @PathVariable String [] param) {
		//解析param
		List<String> zgList = new ArrayList<>();
		for(int i=0;i<param.length;i++){
			zgList.add(param[i]);
		}
		ZwjbxxVO zwjbxxVO = new ZwjbxxVO();
		zwjbxxVO.setZgList(zgList);

		//excel标题
		String[] title = {"公司名称","联系人","联系人电话","展位数量","展位号"};
		//columns列
		String[] columns = {"gsmc","lxr","lxrsj","zwnum","zwh"};
		//excel文件名
		String fileName = "展位分析" + System.currentTimeMillis() + ".xls";
		//sheet名
		String sheetName = "展位分析";

		//获取数据
		List<ZwjbxxVO> dataList = zwjbxxService.doFindQyZwNumDesc(zwjbxxVO);
		this.doExportExcel(request, response, fileName, sheetName, title, columns, dataList);
	}
	/**
	 * 获取当前企业选择的展位信息及价格信息
	 * by yushch 2019/1/16
	 */
	@PostMapping("doFindZwAndJgByVo")
	public @ResponseBody ResultVO doFindZwAndJgByVo(@RequestBody ZwjbxxVO zwjbxxVO){
		ResultVO resultVO = ResultVO.build();
		try {
			List<ZwjbxxVO> list= zwjbxxService.doFindZwAndJgByVo(zwjbxxVO);
			resultVO.setResult(list);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}
	/**
	 * 更新展位状态
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("changePaid")
	@Transactional
	public @ResponseBody ResultVO changePaid(@RequestBody ZwjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			//判断前台是否传过来UUID值
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
				ZwjbxxVO dbzw=zwjbxxService.doFindById(vo.getUuid());
				if(dbzw.getZwzt()!=vo.getZwzt()){
					vo.setXgrid(CurrentUserUtil.getCurrentUserId());
					vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
					zwjbxxService.doUpdateByVO(vo);
					ZwjbxxVO newdbzw=zwjbxxService.doFindById(vo.getUuid());
					resultVO.setResult(newdbzw);
					resultVO.setMsg("success");
					zwlogService.createZwlog(dbzw,newdbzw, ZwlogServiceImpl.UPDATE,"changePaid");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setMsg("修改缴费状态失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
			return 	resultVO;
		}
		return 	resultVO;
	}
}
