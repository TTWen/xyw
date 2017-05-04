package rj7.bean;

public class TSPingL {
	private String tsid;//推送id
	private String plyhid;//
	private String beiplyhid;//被评论用户id
	private String pltime;
	private String plcontent;//评论内容
	public String getTsid() {
		return tsid;
	}
	public void setTsid(String tsid) {
		this.tsid = tsid;
	}
	public String getPlyhid() {
		return plyhid;
	}
	public void setPlyhid(String plyhid) {
		this.plyhid = plyhid;
	}
	public String getBeiplyhid() {
		return beiplyhid;
	}
	public void setBeiplyhid(String beiplyhid) {
		this.beiplyhid = beiplyhid;
	}
	public String getPltime() {
		return pltime;
	}
	public void setPltime(String pltime) {
		this.pltime = pltime;
	}
	public String getPlcontent() {
		return plcontent;
	}
	public void setPlcontent(String plcontent) {
		this.plcontent = plcontent;
	}

}
