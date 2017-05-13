package rj7.bean;

public class ptclt {
	private String ptid;//推送id
	private String cltid;//收藏用户ID
	private String cltdid;//被收藏用户id
	private String cltt;//收藏时间
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getCltid() {
		return cltid;
	}
	public void setCltid(String cltid) {
		this.cltid = cltid;
	}
	public String getCltdid() {
		return cltdid;
	}
	public void setCltdid(String cltdid) {
		this.cltdid = cltdid;
	}
	public String getCltt() {
		return cltt;
	}
	public void setCltt(String cltt) {
		this.cltt = cltt;
	}//收藏时间
}	
