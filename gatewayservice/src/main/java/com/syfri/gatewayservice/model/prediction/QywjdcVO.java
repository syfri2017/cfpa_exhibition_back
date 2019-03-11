package com.syfri.gatewayservice.model.prediction;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;

public class QywjdcVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String qyid;	//企业ID
	private String gsxz;	//公司性质
	private String sfhwdlcp;	//是否代理海外产品[0]否，[1]是
	private String hwdlcppp;	//海外代理产品品牌
	private String fmzl;	//发明专利(项）
	private String syxxzl;	//实用新型专利(项）
	private String wgsjzl;	//外观设计专利(项）
	private String sfgxjsqy;	//是否高新技术企业[0]否，[1]是
	private String gxjsjb;	//高新技术级别
	private String zycp;	//主营产品
	private String sfhyxydj;	//是否获得行业信用等级评价[0]否，[1]是
	private String hyxydj;	//行业信用等级
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

	private String gsxzmc;	//公司性质名称
	private String gxjsjbmc;	//高新技术级别名称
	private String hyxydjmc;	//行业信用等级名称

	List<String> zycpList;

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
	public String getGsxz(){
		return gsxz;
	}
	public void setGsxz(String gsxz){
		this.gsxz = gsxz;
	}
	public String getSfhwdlcp(){
		return sfhwdlcp;
	}
	public void setSfhwdlcp(String sfhwdlcp){
		this.sfhwdlcp = sfhwdlcp;
	}
	public String getHwdlcppp(){
		return hwdlcppp;
	}
	public void setHwdlcppp(String hwdlcppp){
		this.hwdlcppp = hwdlcppp;
	}
	public String getFmzl(){
		return fmzl;
	}
	public void setFmzl(String fmzl){
		this.fmzl = fmzl;
	}
	public String getSyxxzl(){
		return syxxzl;
	}
	public void setSyxxzl(String syxxzl){
		this.syxxzl = syxxzl;
	}
	public String getWgsjzl(){
		return wgsjzl;
	}
	public void setWgsjzl(String wgsjzl){
		this.wgsjzl = wgsjzl;
	}
	public String getSfgxjsqy(){
		return sfgxjsqy;
	}
	public void setSfgxjsqy(String sfgxjsqy){
		this.sfgxjsqy = sfgxjsqy;
	}
	public String getGxjsjb(){
		return gxjsjb;
	}
	public void setGxjsjb(String gxjsjb){
		this.gxjsjb = gxjsjb;
	}
	public String getZycp(){
		return zycp;
	}
	public void setZycp(String zycp){
		this.zycp = zycp;
	}
	public String getSfhyxydj(){
		return sfhyxydj;
	}
	public void setSfhyxydj(String sfhyxydj){
		this.sfhyxydj = sfhyxydj;
	}
	public String getHyxydj(){
		return hyxydj;
	}
	public void setHyxydj(String hyxydj){
		this.hyxydj = hyxydj;
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

	public String getGsxzmc() {
		return gsxzmc;
	}

	public void setGsxzmc(String gsxzmc) {
		this.gsxzmc = gsxzmc;
	}

	public String getGxjsjbmc() {
		return gxjsjbmc;
	}

	public void setGxjsjbmc(String gxjsjbmc) {
		this.gxjsjbmc = gxjsjbmc;
	}

	public String getHyxydjmc() {
		return hyxydjmc;
	}

	public void setHyxydjmc(String hyxydjmc) {
		this.hyxydjmc = hyxydjmc;
	}

	public List<String> getZycpList() {
		return zycpList;
	}

	public void setZycpList(List<String> zycpList) {
		this.zycpList = zycpList;
	}
}