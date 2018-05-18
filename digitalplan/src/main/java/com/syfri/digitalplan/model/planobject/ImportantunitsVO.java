package com.syfri.digitalplan.model.planobject;

import java.io.Serializable;
import java.util.List;

import com.syfri.baseapi.model.ValueObject;
import com.syfri.digitalplan.model.planobject.XiaofangliliangVO;

public class ImportantunitsVO extends ValueObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String uuid;	//主键（单位ID）
	private String dwmc;	//单位名称
	private String dwxz;	//单位性质
	private String dwdz;	//单位地址
	private String dwgk;	//单位概况
	private String xzqh;	//行政区划
	private String zbdh;	//值班电话
	private String fhdj;	//防火等级
	private String fhdzid;	//防火队站ID
	private String fhdzmc;	//防火队站名称
	private String mhdzid;	//灭火队站ID
	private String mhdzmc;	//灭火队站名称
	private String xfzrr;	//消防责任人
	private String xfzrrdh;	//消防责任人电话
	private String xfglr;	//消防管理人
	private String xfglrdh;	//消防管理人电话
	private String xfsssl;	//单位自动消防设施数量
	private String jzfl;	//建筑分类
	private String jzsl;	//建筑数量
	private String zdmj;	//占地面积
	private String jzmj;	//建筑面积
	private String gisX;	//GIS_X
	private String gisY;	//GIS_Y
	private String lon;	//经度
	private String lat;	//纬度
	private String plqkd;	//毗邻情况(东)
	private String plqkn;	//毗邻情况(南)
	private String plqkx;	//毗邻情况(西)
	private String plqkb;	//毗邻情况(北)
	private String bz;	//备注
	private String deleteFlag;	//删除标志
	private String datasource;	//数据来源[100000一体化]
	private String jdh;	//节点号
	private String sjc;	//时间戳
	private String reserve1;	//备用字段1
	private String reserve2;	//备用字段2
	private String reserve3;	//备用字段3
	private String reserve4;	//备用字段4

	private String dwxzmc;
	private String xzqhmc;
	private String fhdjmc;
	private String fhdzidmc;
	private String mhdzidmc;
	private String jzflmc;
	private String xfdwlxmc;

	public String getUuid(){
		return uuid;
	}
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	public String getDwmc(){
		return dwmc;
	}
	public void setDwmc(String dwmc){
		this.dwmc = dwmc;
	}
	public String getDwxz(){ return dwxz; }
	public void setDwxz(String dwxz){ this.dwxz = dwxz; }
	public String getDwdz(){ return dwdz; }
	public void setDwdz(String dwdz){ this.dwdz = dwdz; }
	public String getDwgk(){ return dwgk; }
	public void setDwgk(String dwgk){ this.dwgk = dwgk; }
	public String getXzqh(){ return xzqh; }
	public void setXzqh(String xzqh){ this.xzqh = xzqh; }
	public String getZbdh(){ return zbdh; }
	public void setZbdh(String zbdh){ this.zbdh = zbdh; }
	public String getFhdj(){ return fhdj; }
	public void setFhdj(String fhdj){ this.fhdj = fhdj; }
	public String getFhdzid(){ return fhdzid; }
	public void setFhdzid(String fhdzid){ this.fhdzid = fhdzid; }
	public String getFhdzmc(){ return fhdzmc; }
	public void setFhdzmc(String fhdzmc){ this.fhdzmc = fhdzmc; }
	public String getMhdzid(){ return mhdzid; }
	public void setMhdzid(String mhdzid){ this.mhdzid = mhdzid; }
	public String getMhdzmc(){ return mhdzmc; }
	public void setMhdzmc(String mhdzmc){ this.mhdzmc = mhdzmc; }
	public String getXfzrr(){ return xfzrr; }
	public void setXfzrr(String xfzrr){ this.xfzrr = xfzrr; }
	public String getXfzrrdh(){ return xfzrrdh; }
	public void setXfzrrdh(String xfzrrdh){ this.xfzrrdh = xfzrrdh; }
	public String getXfglr(){ return xfglr; }
	public void setXfglr(String xfglr){ this.xfglr = xfglr; }
	public String getXfglrdh(){ return xfglrdh; }
	public void setXfglrdh(String xfglrdh){ this.xfglrdh = xfglrdh; }
	public String getXfsssl(){ return xfsssl; }
	public void setXfsssl(String xfsssl){ this.xfsssl = xfsssl; }
	public String getJzfl(){ return jzfl; }
	public void setJzfl(String jzfl){ this.jzfl = jzfl; }
	public String getJzsl(){ return jzsl; }
	public void setJzsl(String jzsl){ this.jzsl = jzsl; }
	public String getZdmj(){ return zdmj; }
	public void setZdmj(String zdmj){ this.zdmj = zdmj; }
	public String getJzmj(){ return jzmj; }
	public void setJzmj(String jzmj){ this.jzmj = jzmj; }
	public String getGisX(){ return gisX; }
	public void setGisX(String gisX){ this.gisX = gisX; }
	public String getGisY(){ return gisY; }
	public void setGisY(String gisY){ this.gisY = gisY; }
	public String getLon(){ return lon; }
	public void setLon(String lon){ this.lon = lon; }
	public String getLat(){ return lat; }
	public void setLat(String lat){ this.lat = lat; }
	public String getPlqkd(){ return plqkd; }
	public void setPlqkd(String plqkd){ this.plqkd = plqkd; }
	public String getPlqkn(){ return plqkn; }
	public void setPlqkn(String plqkn){ this.plqkn = plqkn; }
	public String getPlqkx(){ return plqkx; }
	public void setPlqkx(String plqkx){ this.plqkx = plqkx; }
	public String getPlqkb(){ return plqkb; }
	public void setPlqkb(String plqkb){ this.plqkb = plqkb; }
	public String getBz(){ return bz; }
	public void setBz(String bz){ this.bz = bz; }
	public String getDeleteFlag(){ return deleteFlag; }
	public void setDeleteFlag(String deleteFlag){ this.deleteFlag = deleteFlag; }
	public String getDatasource(){ return datasource; }
	public void setDatasource(String datasource){ this.datasource = datasource; }
	public String getJdh(){ return jdh; }
	public void setJdh(String jdh){
		this.jdh = jdh;
	}
	public String getSjc(){
		return sjc;
	}
	public void setSjc(String sjc){
		this.sjc = sjc;
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

	public String getDwxzmc() { return dwxzmc; }
	public void setDwxzmc(String dwxzmc) { this.dwxzmc = dwxzmc; }
	public String getXzqhmc() {
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}
	public String getFhdjmc() {
		return fhdjmc;
	}
	public void setFhdjmc(String fhdjmc) {
		this.fhdjmc = fhdjmc;
	}
	public String getFhdzidmc() {
		return fhdzidmc;
	}
	public void setFhdzidmc(String fhdzidmc) {
		this.fhdzidmc = fhdzidmc;
	}
	public String getMhdzidmc() {
		return mhdzidmc;
	}
	public void setMhdzidmc(String mhdzidmc) {
		this.mhdzidmc = mhdzidmc;
	}
	public String getJzflmc() {
		return jzflmc;
	}
	public void setJzflmc(String jzflmc) {
		this.jzflmc = jzflmc;
	}
	public String getXfdwlxmc() { return xfdwlxmc; }
	public void setXfdwlxmc(String xfdwlxmc) { this.xfdwlxmc = xfdwlxmc; }
}