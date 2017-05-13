package rj7.bean;

public class Traveltip {
	private String traveltipid;//帖子id
	private String time;//发帖时间
	private String userid;//发帖人id
	private String title;//标题
	private String content;//正文内容
	private String pic;//插入的图片
	private String viewcnt;//浏览量
	private String likecnt;//点赞量
	private String tsmtcnt;//转发量
	private String cmtcnt;//评论量
	public String getTraveltipid() {
		return traveltipid;
	}
	public void setTraveltipid(String traveltipid) {
		this.traveltipid = traveltipid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(String viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(String likecnt) {
		this.likecnt = likecnt;
	}
	public String getTsmtcnt() {
		return tsmtcnt;
	}
	public void setTsmtcnt(String tsmtcnt) {
		this.tsmtcnt = tsmtcnt;
	}
	public String getCmtcnt() {
		return cmtcnt;
	}
	public void setCmtcnt(String cmtcnt) {
		this.cmtcnt = cmtcnt;
	}

}