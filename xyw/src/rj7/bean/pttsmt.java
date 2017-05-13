package rj7.bean;

public class pttsmt {
	private String ptid;//推送id
	private String tsmtid;//转发用户
	private String tsmtdid;//被转发用户id
	private String tsmtt;//转发时间
	private String tsmtctt;//转发理由ת
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getTsmtid() {
		return tsmtid;
	}
	public void setTsmtid(String tsmtid) {
		this.tsmtid = tsmtid;
	}
	public String getTsmtdid() {
		return tsmtdid;
	}
	public void setTsmtdid(String tsmtdid) {
		this.tsmtdid = tsmtdid;
	}
	public String getTsmtt() {
		return tsmtt;
	}
	public void setTsmtt(String tsmtt) {
		this.tsmtt = tsmtt;
	}
	public String getTsmtctt() {
		return tsmtctt;
	}
	public void setTsmtctt(String tsmtctt) {
		this.tsmtctt = tsmtctt;
	}
	
}
