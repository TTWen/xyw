package rj7.dao.push;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import rj7.bean.Push;
import rj7.util.Connect;
import rj7.util.DateUtil;
/**
 * @author lawonder
 * 2017/5/8
 * 推送接口实现
 */

public class PushDAOImpl implements IPushDAO {
	//获取连接实例
	static Connect conn = Connect.getInstance(); 
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//添加推送
	public boolean doCreate(Push t) throws Exception {
		boolean flag = false;
		//获取系统时间并进行格式化
		Date date = new Date();				
		String time = df.format(date);
	    t.setTime(time);
	    //sql语句
	    //param为参数列表
		String sql = "insert into tblPush"
				+ "(pid,admid,type,head,content,time,status,urlpush,browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt)"
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";			
			ArrayList<Object> param = new ArrayList<Object>();
			//向param中添加参数
			param.add(t.getPid());							
			param.add(t.getAdmid());
			param.add(t.getType());
			param.add(t.getHead());
			param.add(t.getContent());
			param.add(t.getTime());
			param.add(t.getStatus());
			param.add(t.getUrlpush());
			param.add(t.getBrowsecnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getCltcnt());
			
			//添加成功flag=true,否则flag=false
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}

	//删除推送
	public boolean doDelete(String pid) throws Exception {
		boolean flag = false;
		String sql = "delete from tblPush where pid = ?";	
			ArrayList<Object> param=new ArrayList<Object>();
			//向param中添加参数id
			param.add(pid);			
			//执行sql语句返回执行结果数
			//删除成功flag=true,否则flag=false
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}

	//修改推送
	public boolean doUpdate(Push t) throws Exception {
		boolean flag = false;
		String sql = "update tblPush set ";
		ArrayList<Object> param = new ArrayList<Object>();
		//可更新项
		if(t.getAdmid()!=null){
			sql = sql+"admid=?, ";
			param.add(t.getAdmid());
		}
		if(t.getType()!=null){
			sql = sql+"type=?, ";
			param.add(t.getType());
		}
		if(t.getHead()!=null){
			sql = sql+"head=?,";
			param.add(t.getHead());
		}
		if(t.getContent()!=null){
			sql = sql+"content=?, ";
			param.add(t.getContent());
		}
		if(t.getStatus()!=null){
			sql = sql+"status=?,";
			param.add(t.getStatus());
		}
		if(t.getUrlpush()!=null){
			sql = sql+"urlpush=?,";
			param.add(t.getUrlpush());
		}
		//每次修改，time必改变，末尾列无逗号
		Date date = new Date();				
		String time = df.format(date);
	    t.setTime(time);
		sql = sql+"time=? ";
		param.add(t.getTime());
		sql = sql+"where pid=?";
		param.add(t.getPid());
		//执行sql语句返回执行结果数
		//添加成功flag=true,否则flag=false
	    if(conn.update(sql, param)!=0){	
		flag = true;
	    }
	    return flag;									
	}
	
	//查询所有推送,调用时注意判空！
	public ArrayList<Push> findAll() throws Exception {
		String sql = "select pid,admid,type,head,content,time,status,urlpush,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush order by pid";
		//无参数时，param为null
		ArrayList<Push> push= new ArrayList<Push>();
		push = (ArrayList)conn.queryForArrObject(sql, null,Push.class);
		return push;
	}

	//按照id查找,调用时注意判空！
	public Push findByid(String pid) throws Exception {
		String sql = "select pid,admid,type,head,content,time,status,urlpush,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt"
				+ " from tblPush where pid = ?";
		ArrayList<Object> param = new ArrayList<Object>();		
		param.add(pid);
		ArrayList<Push> rs = (ArrayList)conn.queryForArrObject(sql, param,Push.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}

	//按照类型查找,调用时注意判空！
	public ArrayList<Push> findBytype(String type) throws Exception {
		String sql = "select pid,admid,type,head,content,time,status,urlpush,"
				+ "browsecnt,tsmtcnt,likecnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush where type = ?";
		ArrayList<Object> param = new ArrayList<Object>();		
		param.add(type);
		ArrayList<Push> push= new ArrayList<Push>();
		push = (ArrayList)conn.queryForArrObject(sql, param,Push.class);
		return  push;
	}

	//按照热度查找,调用时注意判空！
	public ArrayList<Push> findByhot(Date datebefore,Date dateafter) throws Exception {
		//从最近一段时间内选出符合要求的记录封装到list，对list内的元素进行排序，并返回
		ArrayList<Push> push= new ArrayList<Push>();
		String sql = "select pid,admid,type,head,content,time,status,urlpush,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush where ((browsecnt+likecnt+tsmtcnt+cmtcnt+shrecnt+cltcnt)>100 "
				+ "and (time between ? and ?)) limit 100";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(datebefore);
		param.add(dateafter);
		push = (ArrayList)conn.queryForArrObject(sql, param, Push.class);
	    this.findRecent();
		//比较器
		PushCmp cmp = new PushCmp();
		Collections.sort(push, cmp);
		return push;
	}

	//按照时间查找，调用时注意判空！
	//查找time在datebefore 和dataafter之间的推送
	public ArrayList<Push> findBytime(Date datebefore,Date dateafter ) throws Exception {
		//日期比较
		ArrayList<Push> push= new ArrayList<Push>();
		String sql = "select pid,admid,type,head,content,time,status,urlpush,"
				+ "browsecnt,likecnt,tsmtcnt,cmtcnt,shrecnt,cltcnt "
				+ "from tblPush"
				+ " where time between ? and ? ";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(datebefore);
		param.add(dateafter);
		push = (ArrayList)conn.queryForArrObject(sql, param, Push.class);
		return push;
	}
	
	//查找最近
	public ArrayList<Push> findRecent() throws Exception {
		//获取偏移时间，最近3天
		Date date = new Date();
		ArrayList<Push> push= new ArrayList<Push>();
		Date recent = DateUtil.getDate(date, -3);
		push = this.findBytime(recent, date);
		return push;
	}

	
}
