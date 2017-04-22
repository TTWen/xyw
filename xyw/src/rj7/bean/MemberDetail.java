package rj7.bean;

public class MemberDetail {

	private String id;
	private String icon; 
	private String attcnt; 
	private String fanscnt; 
	private String coincnt; 
	private String experience; //  经验ֵ
	private String ip; // 登录ip
	private String lastlogtime; // 上次登录时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAttcnt() {
		return attcnt;
	}
	public void setAttcnt(String attcnt) {
		this.attcnt = attcnt;
	}
	public String getFanscnt() {
		return fanscnt;
	}
	public void setFanscnt(String fanscnt) {
		this.fanscnt = fanscnt;
	}
	public String getCoincnt() {
		return coincnt;
	}
	public void setCoincnt(String coincnt) {
		this.coincnt = coincnt;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLastlogtime() {
		return lastlogtime;
	}
	public void setLastlogtime(String lastlogtime) {
		this.lastlogtime = lastlogtime;
	}
	
}
