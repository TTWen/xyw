package rj7.dao.evaluate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import rj7.bean.Evaluate;
import rj7.util.Connect;
import rj7.util.DAOFactory;
/**
 * 浼氬憳dao灞傛帴鍙ｅ疄鐜?
 * @author 姊佺埥鐖?  
 *
 */
//预约接口实现
public  class EvaDAOImpl implements IEvaDAO {

		@Override
		//添加评价
		public boolean doCreate(Evaluate e) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			Connect conn=Connect.getInstance(); //获取连接实例
			Date date=new Date();				//获取系统时间并进行格式化
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
		    e.setEvatime(time);
			String sql = "insert into tblevaluate"
					+ "(evaid,evatime,pjuserid,bpjuserid,evastar,evacont)"
					+"values(?,?,?,?,?,?)";			//sql语句
				ArrayList<Object> param=new ArrayList();		//param为参数列表
				param.add(e.getEvaid());							//向param中添加参数
				param.add(e.getEvatime());
				param.add(e.getPjuserid());
				param.add(e.getBpjuserid());
				param.add(e.getEvastar());
				param.add(e.getEvacont());
				if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
				flag = true;
			    }
			    return flag;									//添加成功flag=true,否则flag=false
		}
	
		@Override
		//删除评价
		public boolean doDelete(String evaid) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			Connect conn=Connect.getInstance();					//获取连接实例
				String sql = "delete from tblevaluate where evaid = ?";	//sql语句
				ArrayList<Object> param=new ArrayList();		//param为参数列表
				param.add(evaid);							//向param中添加参数id
				if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
				flag = true;
			    }
			    return flag;									//删除成功flag=true,否则flag=false
		}
	
		@Override
		//修改评价
		public boolean doUpdate(Evaluate e) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "update tblevaluate set evatime=?,pjuserid=?,"
					+"bpjuserid=?,evastar=?,evacont=? where evaid = ?";					//sql语句
				ArrayList<Object> param=new ArrayList();                          //param为参数列表
				param.add(e.getEvatime());               //向param中添加参数
				param.add(e.getPjuserid());
				param.add(e.getBpjuserid());
				param.add(e.getEvastar());
				param.add(e.getEvacont());
				param.add(e.getEvaid());
			    if(conn.update(sql, param)!=0){					//执行sql语句返回执行结果数
				flag = true;
			    }
			    return flag;									//添加成功flag=true,否则flag=false
		}
		
		@Override
		//查询所有评价,调用时注意判空！
		public List<Object> findAll() throws Exception {
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select evaid,evatime,pjuserid,bpjuserid,evastar,evacont"
					+ " from tblevaluate order by evaid";
			return conn.queryForArrObject(sql, null,Evaluate.class);//无参数时，param为null
		}

		@Override
		//按照用户id查找,调用时注意判空！
		public List<Object> findByuserid(String userid) throws Exception {
			// TODO Auto-generated method stub
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select evaid,evatime,pjuserid,bpjuserid,evastar,evacont"
					+ " from tblreserve where yyuserid = ? or byyuserid =?";
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(userid);
			return  conn.queryForArrObject(sql, param,Evaluate.class);//以List<Object>形式返回
		}

		@Override
		//按照评价星级数查找，调用时请注意判空
		public List<Object> findBystar(String evastar) throws Exception {
			// TODO Auto-generated method stub
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select evaid,evatime,pjuserid,bpjuserid,evastar,evacont"
					+ " from tblevaluate where evastar = ?";
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(evastar);
			return  conn.queryForArrObject(sql, param,Evaluate.class);//以List<Object>形式返回
		}

	
	
	//按照评价id查找，调用时请注意判空
	public Object findByid(String id, String tblname, String idname) {
		
		return (Evaluate)DAOFactory.getDaoInstance().findById(tblname, id, Evaluate.class, idname);
	}

}