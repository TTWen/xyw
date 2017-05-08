package rj7.dao.evaluate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import rj7.bean.Evaluate;
import rj7.util.Connect;
import rj7.util.DAOFactory;
/**
 * 
 * @author zf
 * 2017-05-08
 * 评价接口实现
 *
 */

//评价接口实现
public  class EvaDAOImpl implements IEvaDAO {
	
		//添加评价
		public boolean doCreate(Evaluate e) throws Exception {
			boolean flag = false;
			Connect conn=Connect.getInstance(); //获取连接实例
			Date date=new Date();				//获取系统时间并格式化
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
			String time=format.format(date);
		    e.setEvatime(time);
			String sql = "insert into tblevaluate"
					+ "(evaid,evatime,evauserid,evaduserid,evastar,evacont)"
					+"values(?,?,?,?,?,?)";			//sql语句
				ArrayList<Object> param=new ArrayList();		//paramΪ为参数列表
				param.add(e.getEvaid());							//向param中添加参数,添加评价id
				param.add(e.getEvatime());							//添加评价时间
				param.add(e.getEvauserid());						//添加评价用户id
				param.add(e.getEvaduserid());						//添加被评价用户id
				param.add(e.getEvastar());							//添加评价星级数
				param.add(e.getEvacont());							//添加评价内容
				if(conn.update(sql, param)!=0){					//ִ执行sql语句，返回执行结果数
				flag = true;									
			    }
			    return flag;									//添加成功flag=true,否则为false
		}
	
		//删除评价
		public boolean doDelete(String evaid) throws Exception {
			boolean flag = false;
			Connect conn=Connect.getInstance();					//获取连接实例
				String sql = "delete from tblevaluate where evaid = ?";	//sql语句
				ArrayList<Object> param=new ArrayList();		//param为参数列表
				param.add(evaid);							//向param中添加评价id
				if(conn.update(sql, param)!=0){					//执行sql语句，返回执行结果数ִ
				flag = true;
			    }
			    return flag;									//删除成功flag=true,否则为false
		}
	
		//修改评价
		public boolean doUpdate(Evaluate e) throws Exception {
			boolean flag = false;
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "update tblevaluate set evatime=?,evauserid=?,"
					+"evaduserid=?,evastar=?,evacont=? where evaid = ?";					//sql语句
				ArrayList<Object> param=new ArrayList();                          //param为参数列表
				param.add(e.getEvatime());               //向param中添加评价时间
				param.add(e.getEvauserid());
				param.add(e.getEvaduserid());
				param.add(e.getEvastar());
				param.add(e.getEvacont());
				param.add(e.getEvaid());
			    if(conn.update(sql, param)!=0){					//执行sql语句，返回执行结果数
				flag = true;
			    }
			    return flag;									//修改成功flag=true,否则为false
		}
		
		//查找所有评价，调用时注意判空
		public List<Object> findAll() throws Exception {
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select evaid,evatime,evauserid,evaduserid,evastar,evacont"
					+ " from tblevaluate order by evaid";
			return conn.queryForArrObject(sql, null,Evaluate.class);//无参数时，param为null
		}

		//按照评价用户id查找，调用时注意判空
		public List<Object> findByuserid(String userid) throws Exception {
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select evaid,evatime,evauserid,evaduserid,evastar,evacont"
					+ " from tblevaluate where yyuserid = ? ";
			ArrayList<Object> param=new ArrayList();		//paramΪ为参数列表
			param.add(userid);
			return  conn.queryForArrObject(sql, param,Evaluate.class);//以List<Object>形式返回
		}

		//按照评价星级数查找，调用时注意判空
		public List<Object> findBystar(String evastar) throws Exception {
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select evaid,evatime,evauserid,evaduserid,evastar,evacont"
					+ " from tblevaluate where evastar = ?";
			ArrayList<Object> param=new ArrayList();		
			param.add(evastar);								//向param中添加评价星级数
			return  conn.queryForArrObject(sql, param,Evaluate.class);//以List<Object>形式返回
		}

		//按照id查找
		public Object findByid(String id, String tblname, String idname) {
		
			return (Evaluate)DAOFactory.getDaoInstance().findById(tblname, id, Evaluate.class, idname);
	}

}