package com.syfri.userservice.model.venue;

import java.io.Serializable;
import java.util.Date;

import com.syfri.baseapi.model.ValueObject;

public class ZwsmsVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主健
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private Date cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private Date xgsj;	//修改时间
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4
	private String zt;	//状态
	private String errmsg;	//错误消息，result
	private String ext;	//用户的
	private String sid;	//本次发送标识
	private String fee;	//短信计费的条数
	private String result;	//错误码，0
	private Date fssj;	//发送时间
	private String fscs;	//发送次数
	private String sjhm;	//手机号码
	private String qyid;	//企业ID
	private String zwuuid;	//中文公司名称
	private String zwh;	//英文公司名称
	private String deleteFlag;	//删除标志

	private String fssjStr;	//发送时间
	private String qymc;	//企业名称
	private String fssj_begin;	//发送时间开始时间
	private String fssj_end;	//发送时间结束时间

	public String getZwuuid() {
		return zwuuid;
	}

	public void setZwuuid(String zwuuid) {
		this.zwuuid = zwuuid;
	}

	public String getZwh() {
		return zwh;
	}

	public void setZwh(String zwh) {
		this.zwh = zwh;
	}

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getCjrid(){
		return cjrid;
	}
	public void setCjrid(String cjrid){
		this.cjrid = cjrid;
	}
	public String getCjrmc(){
		return cjrmc;
	}
	public void setCjrmc(String cjrmc){
		this.cjrmc = cjrmc;
	}
	public Date getCjsj(){
		return cjsj;
	}
	public void setCjsj(Date cjsj){
		this.cjsj = cjsj;
	}
	public String getXgrid(){
		return xgrid;
	}
	public void setXgrid(String xgrid){
		this.xgrid = xgrid;
	}
	public String getXgrmc(){
		return xgrmc;
	}
	public void setXgrmc(String xgrmc){
		this.xgrmc = xgrmc;
	}
	public Date getXgsj(){
		return xgsj;
	}
	public void setXgsj(Date xgsj){
		this.xgsj = xgsj;
	}
	public String getReserve1(){
		return reserve1;
	}
	public void setReserve1(String reserve1){
		this.reserve1 = reserve1;
	}
	public String getReserve2(){
		return reserve2;
	}
	public void setReserve2(String reserve2){
		this.reserve2 = reserve2;
	}
	public String getReserve3(){
		return reserve3;
	}
	public void setReserve3(String reserve3){
		this.reserve3 = reserve3;
	}
	public String getReserve4(){
		return reserve4;
	}
	public void setReserve4(String reserve4){
		this.reserve4 = reserve4;
	}
	public String getZt(){
		return zt;
	}
	public void setZt(String zt){
		this.zt = zt;
	}
	public String getErrmsg(){
		return errmsg;
	}
	public void setErrmsg(String errmsg){
		this.errmsg = errmsg;
	}
	public String getExt(){
		return ext;
	}
	public void setExt(String ext){
		this.ext = ext;
	}
	public String getSid(){
		return sid;
	}
	public void setSid(String sid){
		this.sid = sid;
	}
	public String getFee(){
		return fee;
	}
	public void setFee(String fee){
		this.fee = fee;
	}
	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result = result;
	}
	public Date getFssj(){
		return fssj;
	}
	public void setFssj(Date fssj){
		this.fssj = fssj;
	}
	public String getFscs(){
		return fscs;
	}
	public void setFscs(String fscs){
		this.fscs = fscs;
	}
	public String getSjhm(){
		return sjhm;
	}
	public void setSjhm(String sjhm){
		this.sjhm = sjhm;
	}
	public String getQyid(){
		return qyid;
	}
	public void setQyid(String qyid){
		this.qyid = qyid;
	}
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
	}

	public String getFssjStr() {
		return fssjStr;
	}

	public void setFssjStr(String fssjStr) {
		this.fssjStr = fssjStr;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getFssj_begin() {
		return fssj_begin;
	}

	public void setFssj_begin(String fssj_begin) {
		this.fssj_begin = fssj_begin;
	}

	public String getFssj_end() {
		return fssj_end;
	}

	public void setFssj_end(String fssj_end) {
		this.fssj_end = fssj_end;
	}
}