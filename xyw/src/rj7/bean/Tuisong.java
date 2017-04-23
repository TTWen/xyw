package rj7.bean;
//推送javabean
public class Tuisong {				//推送
	private String tid;				//推送id
	private String admid;       	//发布推送的管理员id
	private String ttype;      		//推送类型
	private String thead;      	 	//推送标题     
	private String tcontent;    	//推送内容    
	private String ttime;       	//推送发布时间     
	private String tstatus;     	//推送状态 ,是否可以查看   
	private String browsecnt; 	//推送浏览量    
	private String dianzancnt;	//推送点赞量
	private String zhuanfacnt;	//推送转发量
	private String pingluncnt;	//推送评论量
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getAdmid() {
		return admid;
	}
	public void setAdmid(String admid) {
		this.admid = admid;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getThead() {
		return thead;
	}
	public void setThead(String thead) {
		this.thead = thead;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public String getTstatus() {
		return tstatus;
	}
	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}
	public String getBrowsecnt() {
		return browsecnt;
	}
	public void setBrowsecnt(String browsecnt) {
		this.browsecnt = browsecnt;
	}
	public String getDianzancnt() {
		return dianzancnt;
	}
	public void setDianzancnt(String dianzancnt) {
		this.dianzancnt = dianzancnt;
	}
	public String getZhuanfacnt() {
		return zhuanfacnt;
	}
	public void setZhuanfacnt(String zhuanfacnt) {
		this.zhuanfacnt = zhuanfacnt;
	}
	public String getPingluncnt() {
		return pingluncnt;
	}
	public void setPingluncnt(String pingluncnt) {
		this.pingluncnt = pingluncnt;
	}
	
}