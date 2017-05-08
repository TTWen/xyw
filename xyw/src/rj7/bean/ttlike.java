package rj7.bean;

public class ttlike {
	 String ttid;//攻略id
     String likeid;//点赞用户id
	 String likedid;//被点赞用户ID
	 String liket;
	public String getTtid() {
		return ttid;
	}
	public void setTtid(String ttid) {
		this.ttid = ttid;
	}
	public String getLikeid() {
		return likeid;
	}
	public void setLikeid(String likeid) {
		this.likeid = likeid;
	}
	public String getLikedid() {
		return likedid;
	}
	public void setLikedid(String likedid) {
		this.likedid = likedid;
	}
	public String getLiket() {
		return liket;
	}
	public void setLiket(String liket) {
		this.liket = liket;
	}//点赞时间
}