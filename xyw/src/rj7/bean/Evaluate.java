package rj7.bean;
/**
 * 
 * @author zf
 * 2017-05-08
 * 评价javabean
 *
 */
public class Evaluate {
	private String evaid;//评价id
	private String evatime;//评价时间
	private String evauserid;//评价用户id
	private String evaduserid;//被评价用户id
	private String evastar;//评价星级数
	private String evacont;//评价内容
	public String getEvaid() {
		return evaid;
	}
	public void setEvaid(String evaid) {
		this.evaid = evaid;
	}
	public String getEvatime() {
		return evatime;
	}
	public void setEvatime(String evatime) {
		this.evatime = evatime;
	}
	public String getEvauserid() {
		return evauserid;
	}
	public void setEvauserid(String evauserid) {
		this.evauserid = evauserid;
	}
	public String getEvaduserid() {
		return evaduserid;
	}
	public void setEvaduserid(String evaduserid) {
		this.evaduserid = evaduserid;
	}
	public String getEvastar() {
		return evastar;
	}
	public void setEvastar(String evastar) {
		this.evastar = evastar;
	}
	public String getEvacont() {
		return evacont;
	}
	public void setEvacont(String evacont) {
		this.evacont = evacont;
	}
}