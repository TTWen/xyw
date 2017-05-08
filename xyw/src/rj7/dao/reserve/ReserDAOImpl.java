package rj7.dao.reserve;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import rj7.bean.Reserve;
import rj7.util.Connect;
import rj7.util.DAOFactory;
/**
 * 
 * @author zf
 * 2017-05-08
 * 预约接口实现
 *
 */
public  class ReserDAOImpl implements IReserDAO {

		//添加预约
		public boolean doCreate(Reserve r) throws Exception {
			boolean flag = false;
			Connect conn=Connect.getInstance(); //获取连接实例
			Date date=new Date();				//获取系统时间，并格式化
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
		    r.setReserfintime(time);
			String sql = "insert into tblreserve"
					+ "(reserid,reserbegtime,reserfintime,reserdealtime,reuserid,reduserid,resercity)"
					+"values(?,?,?,?,?,?,?)";			//sql语句
				ArrayList<Object> param=new ArrayList();		//param为参数列表
				param.add(r.getReserid());						//向param中添加预约id
				param.add(r.getReserbegtime());					//添加预约开始时间
				param.add(r.getReserfintime());					//添加预约生成时间
				param.add(r.getReserdealtime());				//添加预约处理时间
				param.add(r.getReuserid());
				param.add(r.getReduserid());
				param.add(r.getResercity());
			    
				if(conn.update(sql, param)!=0){					//执行sql语句，返回执行结果数
				flag = true;
			    }
			    return flag;									//成功flag=true,否则flag=false
		}
	
		//删除预约
		public boolean doDelete(String reserid) throws Exception {
			boolean flag = false;
			Connect conn=Connect.getInstance();					//获取连接实例
				String sql = "delete from tblreserve where reserid= ?";	//sql语句
				ArrayList<Object> param=new ArrayList();		//param为参数列表
				param.add(reserid);								//向param中添加预约id		
				if(conn.update(sql, param)!=0){					//执行sql语句，返回执行结果数
				flag = true;
			    }
			    return flag;									//删除成功flag=true,否则flag=false
		}
	
		//修改预约
		public boolean doUpdate(Reserve r) throws Exception {
			boolean flag = false;
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "update tblreserve set reserbegtime=?,reserfintime=?,"
			+"reserdealtime=?,reuserid=?,reduserid=?,resercity=? where reserid= ?";		//sql语句
				ArrayList<Object> param=new ArrayList();		//param为参数列表
				param.add(r.getReserbegtime());//锟斤拷param锟斤拷锟斤拷硬锟斤拷锟�
				param.add(r.getReserfintime());
				param.add(r.getReserdealtime());
				param.add(r.getReuserid());
				param.add(r.getReduserid());
				param.add(r.getResercity());
				param.add(r.getReserid());	
			    if(conn.update(sql, param)!=0){					//执行sql语句，返回执行结果数
				flag = true;
			    }
			    return flag;									//修改成功flag=true,否则flag=false
		}
		
		//查找所有预约，调用时注意判空
		public List<Object> findAll() throws Exception {
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select reserid ,reserbegtime,reserfintime,reserdealtime,reuserid,reduserid,resercity"
					+ " from tblreserve order by reserid";
			return conn.queryForArrObject(sql, null,Reserve.class);//无参数时，param为null
		}

		//按照预约用户id查找预约，调用时注意判空
		public List<Object> findByuserid(String userid) throws Exception {
			
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select reserid,reserbegtime,reserfintime,"
					+"reserdealtime,reuserid,reduserid,resercity "
					+ "from tblreserve where yyuserid = ?";
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(userid);
			return  conn.queryForArrObject(sql, param,Reserve.class);//以List<Object>形式返回
		}

		//按照预约城市查找预约，调用时注意判空 
		public List<Object> findBycity(String resercity) throws Exception {
			
			Connect conn=Connect.getInstance();					//获取连接实例
			String sql = "select reserid,reserbegtime,reserfintime,"
					+"reserdealtime,reuserid,reduserid,resercity "
					+ "from tblreserve where resercity = ?";
			ArrayList<Object> param=new ArrayList();		//param为参数列表
			param.add(resercity);
			return  conn.queryForArrObject(sql, param,Reserve.class);//以List<Object>形式返回
		}

	
	
	//按照预约id查找预约，调用时注意判空
	public Object findByid(String id, String tblname, String idname) {
		
		return (Reserve)DAOFactory.getDaoInstance().findById(tblname, id, Reserve.class,idname);
	}

}