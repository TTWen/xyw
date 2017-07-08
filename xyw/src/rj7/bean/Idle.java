package rj7.bean;

//闲置物品的Javabean 
public class Idle
{
	private String idleid;//闲置物品id
	private String memid;//闲置物品拥有者用户id
	private String idlename;//闲置物品名称
	private String idledetail;//存放闲置物品的详情描述ַ
	private String idletype;//存放闲置物品的类型，forfree还是forsale
	private String idletime;//存放闲置物品的发布时间
	
	public Idle() {
		super();
	}
	public String getIdleid() {
		return idleid;
	}
	public void setIdleid(String idleid) {
		this.idleid = idleid;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getIdlename() {
		return idlename;
	}
	public void setIdlename(String idlename) {
		this.idlename = idlename;
	}
	public String getIdledetail() {
		return idledetail;
	}
	public void setIdledetail(String idledetail) {
		this.idledetail = idledetail;
	}
	public String getIdletype() {
		return idletype;
	}
	public void setIdletype(String idletype) {
		this.idletype = idletype;
	}
	public String getIdletime() {
		return idletime;
	}
	public void setIdletime(String idletime) {
		this.idletime = idletime;
	}
}