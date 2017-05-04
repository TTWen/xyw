package rj7.bean;

public class TSZhuanF {
	private String tsid;//推送id
	private String zfyhid;//
	private String beizfyhid;//被转发用户id
	private String zftime;
	private String zfcontent;//转发内容
	public String getTsid() {
		return tsid;
	}
	public void setTsid(String tsid) {
		this.tsid = tsid;
	}
	public String getZfyhid() {
		return zfyhid;
	}
	public void setZfyhid(String zfyhid) {
		this.zfyhid = zfyhid;
	}
	public String getBeizfyhid() {
		return beizfyhid;
	}
	public void setBeizfyhid(String beizfyhid) {
		this.beizfyhid = beizfyhid;
	}
	public String getZftime() {
		return zftime;
	}
	public void setZftime(String zftime) {
		this.zftime = zftime;
	}
	public String getZfcontent() {
		return zfcontent;
	}
	public void setZfcontent(String zfcontent) {
		this.zfcontent = zfcontent;
	}

}
