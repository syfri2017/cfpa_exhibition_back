package com.syfri.gatewayservice.model.prediction;

import java.io.Serializable;

import com.syfri.baseapi.model.ValueObject;

public class QyzwyxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String qyid;	//企业ID
	private String bzzwgs;	//标准展位(每个12平方米)个数
	private String sngdzw;	//室内光地展位(需要特装搭建，24平方米起)
	private String swgdzw;	//室外光地展位(仅限消防车类)
	private String deleteFlag;	//删除标志
	private String cjrid;	//创建人ID
	private String cjrmc;	//创建人名称
	private String cjsj;	//创建时间
	private String xgrid;	//修改人ID
	private String xgrmc;	//修改人姓名
	private String xgsj;	//修改时间

	private String S1;	//24-50 m2
	private String S2;	//50-100 m2
	private String S3;	//100-200m2
	private String S4;	//200 m2以上。

	private String zwmjfw;//展位面积范围类型
	private String zwmjfwmc;//展位面积范围名称
	private String sl;//展位面积范围数量

	private String zwgsmc;	//中文公司名称
	private String ywgsmc;	//英文公司名称
	private String lxr;	//联系人
	private String lxrsj;	//联系人手机

	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4


	public String getZwmjfw() {
		return zwmjfw;
	}

	public void setZwmjfw(String zwmjfw) {
		this.zwmjfw = zwmjfw;
	}

	public String getZwmjfwmc() {
		return zwmjfwmc;
	}

	public void setZwmjfwmc(String zwmjfwmc) {
		this.zwmjfwmc = zwmjfwmc;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	private String cplx;	//产品类型
	private String cplxmc;	//产品类名称

	private String codeValue;	//代码值
	private String codeName;	//代码名称

	private String czqysl;	//参展企业数量

	private String gdzwmj;//光地展位面积

	private String bwzwgssl;//标准展位数量


	public String getS1() {
		return S1;
	}

	public void setS1(String s1) {
		S1 = s1;
	}

	public String getS2() {
		return S2;
	}

	public void setS2(String s2) {
		S2 = s2;
	}

	public String getS3() {
		return S3;
	}

	public void setS3(String s3) {
		S3 = s3;
	}

	public String getBwzwgssl() {
		return bwzwgssl;
	}

	public String getS4() {
		return S4;
	}

	public void setS4(String s4) {
		S4 = s4;
	}

	public void setBwzwgssl(String bwzwgssl) {
		this.bwzwgssl = bwzwgssl;
	}

	public String getGdzwmj() {
		return gdzwmj;
	}

	public void setGdzwmj(String gdzwmj) {
		this.gdzwmj = gdzwmj;
	}

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
	public String getBzzwgs(){
		return bzzwgs;
	}
	public void setBzzwgs(String bzzwgs){
		this.bzzwgs = bzzwgs;
	}
	public String getSngdzw(){
		return sngdzw;
	}
	public void setSngdzw(String sngdzw){
		this.sngdzw = sngdzw;
	}
	public String getSwgdzw(){
		return swgdzw;
	}
	public void setSwgdzw(String swgdzw){
		this.swgdzw = swgdzw;
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

	public String getCplx() {
		return cplx;
	}

	public void setCplx(String cplx) {
		this.cplx = cplx;
	}

	public String getCplxmc() {
		return cplxmc;
	}

	public void setCplxmc(String cplxmc) {
		this.cplxmc = cplxmc;
	}

	public String getCzqysl() {
		return czqysl;
	}

	public void setCzqysl(String czqysl) {
		this.czqysl = czqysl;
	}

	public String getZwgsmc() {
		return zwgsmc;
	}

	public void setZwgsmc(String zwgsmc) {
		this.zwgsmc = zwgsmc;
	}

	public String getYwgsmc() {
		return ywgsmc;
	}

	public void setYwgsmc(String ywgsmc) {
		this.ywgsmc = ywgsmc;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxrsj() {
		return lxrsj;
	}

	public void setLxrsj(String lxrsj) {
		this.lxrsj = lxrsj;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
}