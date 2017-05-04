package rj7.bean;

public class TSFenX {
	private String tsid;//推送id
	private String fxyhid;//
	private String beifxyhid;//被分享用户id
	private String fxtime;
	private String fxcontent;//分享内容
	public String getTsid() {
		return tsid;
	}
	public void setTsid(String tsid) {
		this.tsid = tsid;
	}
	public String getFxyhid() {
		return fxyhid;
	}
	public void setFxyhid(String fxyhid) {
		this.fxyhid = fxyhid;
	}
	public String getBeifxyhid() {
		return beifxyhid;
	}
	public void setBeifxyhid(String beifxyhid) {
		this.beifxyhid = beifxyhid;
	}
	public String getFxtime() {
		return fxtime;
	}
	public void setFxtime(String fxtime) {
		this.fxtime = fxtime;
	}
	public String getFxcontent() {
		return fxcontent;
	}
	public void setFxcontent(String fxcontent) {
		this.fxcontent = fxcontent;
	}

}
