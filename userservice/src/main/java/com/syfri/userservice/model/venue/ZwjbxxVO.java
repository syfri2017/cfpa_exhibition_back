package com.syfri.userservice.model.venue;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;

public class ZwjbxxVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键
	private String zwh;	//展位号
	private String zwlb;	//展位类别,展位类型
	private String cklx;	//出口类型
	private String zwmj;	//展位面积
	private String zwzt;	//展位状态(0未交费，1已预订，2已缴费，3其他)
	private String qyid;	//企业ID
	private String zwkd;	//展位宽度
	private String zwcd;	//展位长度
	private String zwmc;	//展位名称
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
	private String zgid;	//展馆基本信息表ID
	private String bhzh;	//编号字号
	private String bhzt;	//编号字体
	private String bhzc;	//编号字粗
	private String bhzs;	//编号字色
	private String mczt;	//名称字体
	private String mczh;	//名称字号
	private String mczc;	//名称字粗
	private String mczs;	//名称字色
	private String qymc;	//企业名称
	private String gsjc;  //公司名称
	private String zwztmc; //展位状态
	private String lxr; //联系人
	private String lxrsj; //联系人手机
	private String bgdh;
	private String dzyx;
	private String yjdzxx; //邮寄地址详细

	private String gsmc;   //公司名称
	private String zwnum;   //公司已选展位数量
	private List<String> zgList;   //展馆List

	private String zwjg;	//展位价格
	private String zwjg_eng;	//展位价格_eng

	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}

	public String getDzyx() {
		return dzyx;
	}

	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}

	public String getGsjc() {
		return gsjc;
	}

	public void setGsjc(String gsjc) {
		this.gsjc = gsjc;
	}

	public String getCklx() {
		return cklx;
	}

	public void setCklx(String cklx) {
		this.cklx = cklx;
	}

	public String getZwztmc() {
		return zwztmc;
	}

	public void setZwztmc(String zwztmc) {
		this.zwztmc = zwztmc;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getZwh(){
		return zwh;
	}
	public void setZwh(String zwh){
		this.zwh = zwh;
	}
	public String getZwlb(){
		return zwlb;
	}
	public void setZwlb(String zwlb){
		this.zwlb = zwlb;
	}
	public String getZwmj(){
		return zwmj;
	}
	public void setZwmj(String zwmj){
		this.zwmj = zwmj;
	}
	public String getZwzt(){
		return zwzt;
	}
	public void setZwzt(String zwzt){
		this.zwzt = zwzt;
	}
	public String getQyid(){
		return qyid;
	}
	public void setQyid(String qyid){
		this.qyid = qyid;
	}
	public String getZwkd(){
		return zwkd;
	}
	public void setZwkd(String zwkd){
		this.zwkd = zwkd;
	}
	public String getZwcd(){
		return zwcd;
	}
	public void setZwcd(String zwcd){
		this.zwcd = zwcd;
	}
	public String getZwmc(){
		return zwmc;
	}
	public void setZwmc(String zwmc){
		this.zwmc = zwmc;
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
	public String getZgid(){
		return zgid;
	}
	public void setZgid(String zgid){
		this.zgid = zgid;
	}
	public String getBhzh(){
		return bhzh;
	}
	public void setBhzh(String bhzh){
		this.bhzh = bhzh;
	}
	public String getBhzt(){
		return bhzt;
	}
	public void setBhzt(String bhzt){
		this.bhzt = bhzt;
	}
	public String getBhzc(){
		return bhzc;
	}
	public void setBhzc(String bhzc){
		this.bhzc = bhzc;
	}
	public String getBhzs(){
		return bhzs;
	}
	public void setBhzs(String bhzs){
		this.bhzs = bhzs;
	}
	public String getMczt(){
		return mczt;
	}
	public void setMczt(String mczt){
		this.mczt = mczt;
	}
	public String getMczh(){
		return mczh;
	}
	public void setMczh(String mczh){
		this.mczh = mczh;
	}
	public String getMczc(){
		return mczc;
	}
	public void setMczc(String mczc){
		this.mczc = mczc;
	}
	public String getMczs(){
		return mczs;
	}
	public void setMczs(String mczs){
		this.mczs = mczs;
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
	public String getYjdzxx() {
		return yjdzxx;
	}
	public void setYjdzxx(String yjdzxx) {
		this.yjdzxx = yjdzxx;
	}

	public String getGsmc() {
		return gsmc;
	}
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}
	public String getZwnum() {
		return zwnum;
	}
	public void setZwnum(String zwnum) {
		this.zwnum = zwnum;
	}
    public List<String> getZgList() {
        return zgList;
    }
    public void setZgList(List<String> zgList) {
        this.zgList = zgList;
    }

	public String getZwjg() {
		return zwjg;
	}
	public void setZwjg(String zwjg) {
		this.zwjg = zwjg;
	}
	public String getZwjg_eng() {
		return zwjg_eng;
	}
	public void setZwjg_eng(String zwjg_eng) {
		this.zwjg_eng = zwjg_eng;
	}
}