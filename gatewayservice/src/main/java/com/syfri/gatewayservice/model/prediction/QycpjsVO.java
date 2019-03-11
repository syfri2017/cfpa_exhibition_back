package com.syfri.gatewayservice.model.prediction;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class QycpjsVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String qyid;	//企业ID
	private byte[] cptp;	//产品图片
	private String cplx;	//产品类型
	private String cpjj;	//产品简介
	private String deleteFlag;	//删除标志
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private String cplxmc;	//产品类型名称
	private String cplxmc_ENG;	//产品类型名称
    private String cptpBase64;	//产品图片(Base64格式)
	private String src;//产品图片上传到服务器路径

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getQyid(){
		return qyid;
	}
	public void setQyid(String qyid){
		this.qyid = qyid;
	}

	public byte[] getCptp() {
		return cptp;
	}

	public void setCptp(byte[] cptp) {
		this.cptp = cptp;
	}

	public String getCplx(){
		return cplx;
	}
	public void setCplx(String cplx){
		this.cplx = cplx;
	}
	public String getCpjj(){
		return cpjj;
	}
	public void setCpjj(String cpjj){
		this.cpjj = cpjj;
	}
	public String getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
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
	public String getCjsj(){
		return cjsj;
	}
	public void setCjsj(String cjsj){
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
	public String getXgsj(){
		return xgsj;
	}
	public void setXgsj(String xgsj){
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

	public String getCplxmc() {
		return cplxmc;
	}

	public void setCplxmc(String cplxmc) {
		this.cplxmc = cplxmc;
	}

	public String getCplxmc_ENG() {
		return cplxmc_ENG;
	}

	public void setCplxmc_ENG(String cplxmc_ENG) {
		this.cplxmc_ENG = cplxmc_ENG;
	}

	public String getCptpBase64() {
        return cptpBase64;
    }

    public void setCptpBase64(String cptpBase64) {
        this.cptpBase64 = cptpBase64;
    }

	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}