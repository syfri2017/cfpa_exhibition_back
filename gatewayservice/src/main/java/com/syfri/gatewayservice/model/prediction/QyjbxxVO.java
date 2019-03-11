package com.syfri.gatewayservice.model.prediction;

import java.io.Serializable;
import java.math.BigDecimal;

import com.syfri.baseapi.model.ValueObject;

public class QyjbxxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String qyid;	//企业ID
	private String userid;	//用户ID
	private String zwgsmc;	//中文公司名称
	private String ywgsmc;	//英文公司名称
	private String frdb;	//法人代表
	private String frdbdh;	//法人代表电话
	private String yjdzsheng;	//邮寄地址(省）
	private String yjdzshi;	//邮寄地址(市）
	private String yjdzxx;	//邮寄地址(详细）
	private String bgdh;	//办公电话
	private String cz;	//传真
	private String lxr;	//联系人
	private String lxrsj;	//联系人手机
	private String wz;	//网址
	private String dzyx;	//电子邮箱
	private byte[] yyzz;	//营业执照
	private String sjzt;	//数据状态
	private String shzt;	//审核状态
	private String shrid;	//审核人ID
	private String shrmc;	//审核人名称
	private String shsj;	//审核时间
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
	private String email;//英文版电子邮箱
	private String yyzzgs;//营业执照格式
	private String src;//营业执照src

	private String gsmc;	//公司名称（查询用）
	private String yjdz;	//邮寄地址
	private String sjztmc;	//数据状态名称
	private String shztmc;	//审核状态名称
	private String yjdzshengmc;	//邮寄地址(省）名称
	private String yjdzshimc;	//邮寄地址(市）名称
	private String approveflag;	//审核查询标识

	private String tyshxydm;	//统一社会信用代码/纳税人识别号
	private String yyzzBase64;	//营业执照(Base64格式)

	private String username;   //登陆账号
	private String pkid;   //用户表主键
	private String usertype;   //用户类型
	private String usertypeName;   //用户类型中文

	private String qrzt;   //确认状态
	private String qrsj;	//确认时间
	private String qrztmc; //确认状态名称
	private String qrztsl; //确认状态数量
	private BigDecimal qrztpercent; //确认状态比重
	private String qrsj_start;
	private String qrsj_end;

	private String cygsmc;		//曾用公司名称
	private String gsjc;		//公司简称

	public String getQyid(){
		return qyid;
	}
	public void setQyid(String qyid){
		this.qyid = qyid;
	}
	public String getUserid(){
		return userid;
	}
	public void setUserid(String userid){
		this.userid = userid;
	}
	public String getZwgsmc(){
		return zwgsmc;
	}
	public void setZwgsmc(String zwgsmc){
		this.zwgsmc = zwgsmc;
	}
	public String getYwgsmc(){
		return ywgsmc;
	}
	public void setYwgsmc(String ywgsmc){
		this.ywgsmc = ywgsmc;
	}
	public String getFrdb(){
		return frdb;
	}
	public void setFrdb(String frdb){
		this.frdb = frdb;
	}
	public String getFrdbdh(){
		return frdbdh;
	}
	public void setFrdbdh(String frdbdh){
		this.frdbdh = frdbdh;
	}
	public String getYjdzsheng(){
		return yjdzsheng;
	}
	public void setYjdzsheng(String yjdzsheng){
		this.yjdzsheng = yjdzsheng;
	}
	public String getYjdzshi(){
		return yjdzshi;
	}
	public void setYjdzshi(String yjdzshi){
		this.yjdzshi = yjdzshi;
	}
	public String getYjdzxx(){
		return yjdzxx;
	}
	public void setYjdzxx(String yjdzxx){
		this.yjdzxx = yjdzxx;
	}
	public String getBgdh(){
		return bgdh;
	}
	public void setBgdh(String bgdh){
		this.bgdh = bgdh;
	}
	public String getCz(){
		return cz;
	}
	public void setCz(String cz){
		this.cz = cz;
	}
	public String getLxr(){
		return lxr;
	}
	public void setLxr(String lxr){
		this.lxr = lxr;
	}
	public String getLxrsj(){
		return lxrsj;
	}
	public void setLxrsj(String lxrsj){
		this.lxrsj = lxrsj;
	}
	public String getWz(){
		return wz;
	}
	public void setWz(String wz){
		this.wz = wz;
	}
	public String getDzyx(){
		return dzyx;
	}
	public void setDzyx(String dzyx){
		this.dzyx = dzyx;
	}

	public byte[] getYyzz() {
		return yyzz;
	}

	public void setYyzz(byte[] yyzz) {
		this.yyzz = yyzz;
	}

	public String getSjzt(){
		return sjzt;
	}
	public void setSjzt(String sjzt){
		this.sjzt = sjzt;
	}
	public String getShzt(){
		return shzt;
	}
	public void setShzt(String shzt){
		this.shzt = shzt;
	}
	public String getShrid(){
		return shrid;
	}
	public void setShrid(String shrid){
		this.shrid = shrid;
	}
	public String getShrmc(){
		return shrmc;
	}
	public void setShrmc(String shrmc){
		this.shrmc = shrmc;
	}
	public String getShsj(){
		return shsj;
	}
	public void setShsj(String shsj){
		this.shsj = shsj;
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

	public String getGsmc() {
		return gsmc;
	}

	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}

	public String getYjdz() {
		return yjdz;
	}
	public void setYjdz(String yjdz) {
		this.yjdz = yjdz;
	}
	public String getSjztmc() {
		return sjztmc;
	}
	public void setSjztmc(String sjztmc) {
		this.sjztmc = sjztmc;
	}
	public String getShztmc() {
		return shztmc;
	}
	public void setShztmc(String shztmc) {
		this.shztmc = shztmc;
	}

	public String getYjdzshengmc() {
		return yjdzshengmc;
	}

	public void setYjdzshengmc(String yjdzshengmc) {
		this.yjdzshengmc = yjdzshengmc;
	}

	public String getYjdzshimc() {
		return yjdzshimc;
	}

	public void setYjdzshimc(String yjdzshimc) {
		this.yjdzshimc = yjdzshimc;
	}

	public String getTyshxydm() {
		return tyshxydm;
	}
	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}
	public String getYyzzBase64() {
		return yyzzBase64;
	}
	public void setYyzzBase64(String yyzzBase64) {
		this.yyzzBase64 = yyzzBase64;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPkid() {
		return pkid;
	}
	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUsertypeName() {
		return usertypeName;
	}
	public void setUsertypeName(String usertypeName) {
		this.usertypeName = usertypeName;
	}

	public String getApproveflag() {
		return approveflag;
	}
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getYyzzgs() {
		return yyzzgs;
	}
	public void setYyzzgs(String yyzzgs) {
		this.yyzzgs = yyzzgs;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}

	public String getQrzt() {
		return qrzt;
	}

	public void setQrzt(String qrzt) {
		this.qrzt = qrzt;
	}

	public String getQrsj() {
		return qrsj;
	}

	public void setQrsj(String qrsj) {
		this.qrsj = qrsj;
	}

	public String getQrztmc() {
		return qrztmc;
	}

	public void setQrztmc(String qrztmc) {
		this.qrztmc = qrztmc;
	}

	public String getQrztsl() {
		return qrztsl;
	}

	public void setQrztsl(String qrztsl) {
		this.qrztsl = qrztsl;
	}

	public BigDecimal getQrztpercent() {
		return qrztpercent;
	}

	public void setQrztpercent(BigDecimal qrztpercent) {
		this.qrztpercent = qrztpercent;
	}

	public String getQrsj_start() {
		return qrsj_start;
	}

	public void setQrsj_start(String qrsj_start) {
		this.qrsj_start = qrsj_start;
	}

	public String getQrsj_end() {
		return qrsj_end;
	}

	public void setQrsj_end(String qrsj_end) {
		this.qrsj_end = qrsj_end;
	}
	public String getCygsmc() {
		return cygsmc;
	}
	public void setCygsmc(String cygsmc) {
		this.cygsmc = cygsmc;
	}

	public String getGsjc() {
		return gsjc;
	}

	public void setGsjc(String gsjc) {
		this.gsjc = gsjc;
	}
}