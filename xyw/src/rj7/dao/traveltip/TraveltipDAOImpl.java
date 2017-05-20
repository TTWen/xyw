package rj7.dao.traveltip;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Traveltip;
import rj7.bean.Tuisong;
import rj7.util.Connect;
import rj7.util.DAOFactory;

/**
 * 攻略dao层接口实现
 * @author 马华丽  2017.4.25
 * 
 */

public class TraveltipDAOImpl implements ITraveltipDAO { 
	
	//按id查找
	public Object findByid(String traveltipid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select traveltipid,time,userid,title,content,pic,"
				+ "viewcnt,likecnt,tsmtcnt,cmtcnt"
				+ " from tbltraveltip where traveltipid = ?";
		//param为参数列表
		ArrayList<Object> param=new ArrayList();		
		param.add(traveltipid);
		Connect conn=Connect.getInstance();
		List<Object> rs = conn.queryForArrObject(sql, param,Traveltip.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
			}
		}
	//创建攻略贴
	public boolean doCreate(Traveltip t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance(); //获取连接实例
		Date date=new Date();				//获取系统时间并进行格式化
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
	    t.setTime(time);
		String sql = "insert into tbltraveltip"
				+ "(traveltipid,time,userid,title,content,pic,viewcnt,likecnt,tsmtcnt,cmtcnt)"
				+"values(?,?,?,?,?,?,?,?,?,?)";			//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getTraveltipid());							//向param中添加参数
			param.add(t.getTime());
			param.add(t.getUserid());
			param.add(t.getTitle());
			param.add(t.getContent());
			param.add(t.getPic());
			param.add(t.getViewcnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//添加成功flag=true,否则flag=false
	}

	@Override
	//删除攻略贴
	public boolean doDelete(String traveltipid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "delete from tbltraveltip where traveltipid = ?";	//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(traveltipid);							//向param中添加参数id
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//删除avel成功flag=true,否则flag=false
	}

	@Override
	//修改攻略贴
	public boolean doUpdate(Traveltip t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "update tbltraveltip set time=?,userid=?,title=?,content=?,"
				+ "pic=?,viewcnt=?,likecnt=?,tsmtcnt=?,cmtcnt=? "+
				"where traveltipid = ?";							//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getTime());						//向param中添加参数
			param.add(t.getUserid());
			param.add(t.getTitle());
			param.add(t.getContent());
			param.add(t.getPic());
			param.add(t.getViewcnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getTraveltipid());	
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//添加成功flag=true,否则flag=false
	}
	@Override
	//查询所有攻略,调用时注意判空！
	public List<Object> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "select traveltipid,time,userid,title,content,pic,"
				+ "viewcnt,likecnt,tsmtcnt,cmtcnt "
				+ "from tbltraveltip order by traveltipid";
		return conn.queryForArrObject(sql, null,Traveltip.class);//无参数时，param为null
	}
}