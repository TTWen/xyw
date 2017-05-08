package rj7.bean;

public class traveltipcmt {
/*
 * @author zxq 攻略评论
 * 
 * */
	private String ttid;//攻略id
	private String cmtid;//评论用户id
	private String cmtdid;//被评论用户id
	private String cmtt;//评论时间
	private String cmtctt;//评论内容
	public String getTtid() {
		return ttid;
	}
	public void setTtid(String ttid) {
		this.ttid = ttid;
	}
	public String getCmtid() {
		return cmtid;
	}
	public void setCmtid(String cmtid) {
		this.cmtid = cmtid;
	}
	public String getCmtdid() {
		return cmtdid;
	}
	public void setCmtdid(String cmtdid) {
		this.cmtdid = cmtdid;
	}
	public String getCmtt() {
		return cmtt;
	}
	public void setCmtt(String cmtt) {
		this.cmtt = cmtt;
	}
	public String getCmtctt() {
		return cmtctt;
	}
	public void setCmtctt(String cmtctt) {
		this.cmtctt = cmtctt;
	}
	

}
