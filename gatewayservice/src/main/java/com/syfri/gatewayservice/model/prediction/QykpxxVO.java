package com.syfri.gatewayservice.model.prediction;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class QykpxxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String qyid;	//企业ID
	private String kplx;	//开票类型
	private String kpgsmc;	//开票公司名称
	private String tyshxydm;	//统一社会信用代码/纳税人识别号
	private String gsdz;	//公司地址
	private String dhhm;	//电话号码
	private String khyh;	//开户银行
	private String yhzh;	//银行账户
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

	private String kplxmc;	//开票类型名称

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
	public String getKplx(){
		return kplx;
	}
	public void setKplx(String kplx){
		this.kplx = kplx;
	}
	public String getKpgsmc(){
		return kpgsmc;
	}
	public void setKpgsmc(String kpgsmc){
		this.kpgsmc = kpgsmc;
	}
	public String getTyshxydm(){
		return tyshxydm;
	}
	public void setTyshxydm(String tyshxydm){
		this.tyshxydm = tyshxydm;
	}
	public String getGsdz(){
		return gsdz;
	}
	public void setGsdz(String gsdz){
		this.gsdz = gsdz;
	}
	public String getDhhm(){
		return dhhm;
	}
	public void setDhhm(String dhhm){
		this.dhhm = dhhm;
	}
	public String getKhyh(){
		return khyh;
	}
	public void setKhyh(String khyh){
		this.khyh = khyh;
	}
	public String getYhzh(){
		return yhzh;
	}
	public void setYhzh(String yhzh){
		this.yhzh = yhzh;
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

	public String getKplxmc() {
		return kplxmc;
	}

	public void setKplxmc(String kplxmc) {
		this.kplxmc = kplxmc;
	}
}