package rj7.bean;

public class ptcmt {
	private String ptid;//推送id
	private String cmtid;//评论用户id
	private String cmtdid;//被评论用户id
	private String cmtt;//评论时间
	private String cmtctt;//评论内容
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
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
