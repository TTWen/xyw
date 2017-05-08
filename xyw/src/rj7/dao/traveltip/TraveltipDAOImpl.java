package rj7.dao.traveltip;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Traveltip;
import rj7.util.Connect;
import rj7.util.DAOFactory;

/**
 * 攻略dao层接口实现
 * @author 马华丽  2017.4.25
 * 
 */

public class TraveltipDAOImpl implements ITraveltipDAO { 
	//按id查找
	public Traveltip findById(String postid, String tblname, String idtype)
	{
		return (Traveltip)DAOFactory.getDaoInstance().findById(tblname, postid, Traveltip.class,idtype);
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
		String sql = "insert into tbltrveltip"
				+ "(id,time,usererid,tit,con,pic,viewcnt,likecnt,forwadcnt,commcnt)"
				+"values(?,?,?,?,?,?,?,?,?,?)";			//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getId());							//向param中添加参数
			param.add(t.getTime());
			param.add(t.getUserid());
			param.add(t.getTit());
			param.add(t.getCon());
			param.add(t.getPic());
			param.add(t.getViewcnt());
			param.add(t.getLikecnt());
			param.add(t.getForwadcnt());
			param.add(t.getCommcnt());
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//添加成功flag=true,否则flag=false
	}

	@Override
	//删除攻略贴
	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "delete from tbltraveltip where id = ?";	//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(id);							//向param中添加参数id
		    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
			flag = true;
		    }
		    return flag;									//删除成功flag=true,否则flag=false
	}

	@Override
	//修改攻略贴
	public boolean doUpdate(Traveltip t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//获取连接实例
		String sql = "update tbltrveltip set time=?,userid=?,tit=?,con=?,"
				+ "pic=?,viewcnt=?,likecnt=?,forwadcnt=?,commcnt=? "+
				"where id = ?";							//sql语句
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(t.getTime());						//向param中添加参数
			param.add(t.getUserid());
			param.add(t.getTit());
			param.add(t.getCon());
			param.add(t.getPic());
			param.add(t.getViewcnt());
			param.add(t.getLikecnt());
			param.add(t.getForwadcnt());
			param.add(t.getCommcnt());
			param.add(t.getId());	
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
		String sql = "select id,time,usererid,tit,con,pic,"
				+ "viewcnt,likecnt,forwadcnt,commcnt "
				+ "from tbltrveltip order by id";
		return conn.queryForArrObject(sql, null,Traveltip.class);//无参数时，param为null
	}
}