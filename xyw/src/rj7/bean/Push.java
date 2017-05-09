package rj7.bean;
/**
 * @author lawonder
 * 2017/5/8
 * 推送javabean
 */

public class Push {			//推送
	private String pid;			//推送id
	private String admid;       //发布推送的管理员id
	private String type;      	//推送类型
	private String head;      	//推送标题     
	private String content;    	//推送内容    
	private String time;       	//推送发布时间     
	private String status;     	//推送状态 ,是否可以查看   
	private String browsecnt; 	//推送浏览量 
	private String tsmtcnt;		//推送转发量
	private String likecnt;		//推送点赞量
	private String cmtcnt;		//推送评论量
	private String shrecnt;		//推送分享量
	private String cltcnt;		//推送收藏量
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAdmid() {
		return admid;
	}
	public void setAdmid(String admid) {
		this.admid = admid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBrowsecnt() {
		return browsecnt;
	}
	public void setBrowsecnt(String browsecnt) {
		this.browsecnt = browsecnt;
	}
	public String getTsmtcnt() {
		return tsmtcnt;
	}
	public void setTsmtcnt(String tsmtcnt) {
		this.tsmtcnt = tsmtcnt;
	}
	public String getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(String likecnt) {
		this.likecnt = likecnt;
	}
	public String getCmtcnt() {
		return cmtcnt;
	}
	public void setCmtcnt(String cmtcnt) {
		this.cmtcnt = cmtcnt;
	}
	public String getShrecnt() {
		return shrecnt;
	}
	public void setShrecnt(String shrecnt) {
		this.shrecnt = shrecnt;
	}
	public String getCltcnt() {
		return cltcnt;
	}
	public void setCltcnt(String cltcnt) {
		this.cltcnt = cltcnt;
	}
}