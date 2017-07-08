package rj7.bean;

import java.util.Date;

/**
 * 闲置物品图片Javabean 
 * @author TTWen 2017.6.19
 *
 */
public class IdleFile {
	private String idlefid;
	private String idlefuuidname;  //上传文件的名称，文件的uuid名
	private String idleffilename; //上传文件的真实名称
	private String idlefsavepath;     //记住文件的位置
	private String fdir1;//低四位
	private String fdir2;//高四位
	private String idlefupdatetime;     //文件的上传时间
	private String idleid;
	public String getIdlefid() {
		return idlefid;
	}
	public void setIdlefid(String idlefid) {
		this.idlefid = idlefid;
	}
	public String getIdlefuuidname() {
		return idlefuuidname;
	}
	public void setIdlefuuidname(String idlefuuidname) {
		this.idlefuuidname = idlefuuidname;
	}
	public String getIdleffilename() {
		return idleffilename;
	}
	public void setIdleffilename(String idleffilename) {
		this.idleffilename = idleffilename;
	}
	public String getIdlefsavepath() {
		return idlefsavepath;
	}
	public void setIdlefsavepath(String idlefsavepath) {
		this.idlefsavepath = idlefsavepath;
	}
	public String getFdir1() {
		return fdir1;
	}
	public void setFdir1(String fdir1) {
		this.fdir1 = fdir1;
	}
	public String getFdir2() {
		return fdir2;
	}
	public void setFdir2(String fdir2) {
		this.fdir2 = fdir2;
	}
	public String getIdlefupdatetime() {
		return idlefupdatetime;
	}
	public void setIdlefupdatetime(String idlefupdatetime) {
		this.idlefupdatetime = idlefupdatetime;
	}
	public String getIdleid() {
		return idleid;
	}
	public void setIdleid(String idleid) {
		this.idleid = idleid;
	}
	
	
}

