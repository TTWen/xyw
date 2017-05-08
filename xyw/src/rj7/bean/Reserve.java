package rj7.bean;

public class Reserve {
	private String reserid;  //预约id
	private String reserbegtime;//预约开始旅游时间
	private String reserfintime;//预约生成时间
	private String reserdealtime;//预约处理时间
	private String reuserid;  //预约用户id
	private String reduserid;  //被预约用户id
	private String resercity;
	public String getReserid() {
		return reserid;
	}
	public void setReserid(String reserid) {
		this.reserid = reserid;
	}
	public String getReserbegtime() {
		return reserbegtime;
	}
	public void setReserbegtime(String reserbegtime) {
		this.reserbegtime = reserbegtime;
	}
	public String getReserfintime() {
		return reserfintime;
	}
	public void setReserfintime(String reserfintime) {
		this.reserfintime = reserfintime;
	}
	public String getReserdealtime() {
		return reserdealtime;
	}
	public void setReserdealtime(String reserdealtime) {
		this.reserdealtime = reserdealtime;
	}
	public String getReuserid() {
		return reuserid;
	}
	public void setReuserid(String reuserid) {
		this.reuserid = reuserid;
	}
	public String getReduserid() {
		return reduserid;
	}
	public void setReduserid(String reduserid) {
		this.reduserid = reduserid;
	}
	public String getResercity() {
		return resercity;
	}
	public void setResercity(String resercity) {
		this.resercity = resercity;
	}
	
	
}