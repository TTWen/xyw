package rj7.dao.reserve;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import rj7.bean.Reserve;
import rj7.util.Connect;
import rj7.util.DAOFactory;



public  class ReserDAOImpl implements IReserDAO {

		@Override
		//锟斤拷锟皆ぴ�
		public boolean doCreate(Reserve r) throws Exception {
		
			boolean flag = false;
			Connect conn=Connect.getInstance(); //锟斤拷取锟斤拷锟斤拷实锟斤拷
			Date date=new Date();				//锟斤拷取系统时锟戒并锟斤拷锟叫革拷式锟斤拷
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
		    r.setReserfintime(time);
			String sql = "insert into tblreserve"
					+ "(reserid,reserbegtime,reserfintime,reserdealtime,yyuserid,byyuserid,resercity)"
					+"values(?,?,?,?,?,?,?)";			//sql锟斤拷锟�
				ArrayList<Object> param=new ArrayList();		//param为锟斤拷锟斤拷锟叫憋拷
				param.add(r.getReserid());	
				param.add(r.getReserbegtime());//锟斤拷param锟斤拷锟斤拷硬锟斤拷锟�
				param.add(r.getReserfintime());
				param.add(r.getReserdealtime());
				param.add(r.getYyuserid());
				param.add(r.getByyuserid());
				param.add(r.getResercity());
			    
				if(conn.update(sql, param)!=0){					//执锟斤拷sql锟斤拷浞碉拷锟街达拷薪锟斤拷锟斤拷
				flag = true;
			    }
			    return flag;									//锟斤拷映晒锟絝lag=true,锟斤拷锟斤拷flag=false
		}
	
		@Override
		//删锟斤拷预约
		public boolean doDelete(String reserid) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			Connect conn=Connect.getInstance();					//锟斤拷取锟斤拷锟斤拷实锟斤拷
				String sql = "delete from tblreserve where reserid= ?";	//sql锟斤拷锟�
				ArrayList<Object> param=new ArrayList();		//param为锟斤拷锟斤拷锟叫憋拷
				param.add(reserid);							//锟斤拷param锟斤拷锟斤拷硬锟斤拷锟絠d
				if(conn.update(sql, param)!=0){					//执锟斤拷sql锟斤拷浞碉拷锟街达拷薪锟斤拷锟斤拷
				flag = true;
			    }
			    return flag;									//删锟斤拷锟缴癸拷flag=true,锟斤拷锟斤拷flag=false
		}
	
		@Override
		//锟睫革拷预约
		public boolean doUpdate(Reserve r) throws Exception {
			// TODO Auto-generated method stub
			boolean flag = false;
			Connect conn=Connect.getInstance();					//锟斤拷取锟斤拷锟斤拷实锟斤拷
			String sql = "update tblreserve set reserbegtime=?,reserfintime=?,"
			+"reserdealtime=?,yyuserid=?,byyuserid=?,resercity=? where reserid= ?";					//sql锟斤拷锟�
				ArrayList<Object> param=new ArrayList();		//param为锟斤拷锟斤拷锟叫憋拷
				param.add(r.getReserbegtime());//锟斤拷param锟斤拷锟斤拷硬锟斤拷锟�
				param.add(r.getReserfintime());
				param.add(r.getReserdealtime());
				param.add(r.getYyuserid());
				param.add(r.getByyuserid());
				param.add(r.getResercity());
				param.add(r.getReserid());	
			    if(conn.update(sql, param)!=0){					//执锟斤拷sql锟斤拷浞碉拷锟街达拷薪锟斤拷锟斤拷
				flag = true;
			    }
			    return flag;									//锟斤拷映晒锟絝lag=true,锟斤拷锟斤拷flag=false
		}
		
		@Override
		//锟斤拷询锟斤拷锟斤拷预约,锟斤拷锟斤拷时注锟斤拷锟叫空ｏ拷
		public List<Object> findAll() throws Exception {
			Connect conn=Connect.getInstance();					//锟斤拷取锟斤拷锟斤拷实锟斤拷
			String sql = "select reserid ,reserbegtime,reserfintime,reserdealtime,yyuserid,byyuserid,resercity"
					+ " from tblreserve order by reserid";
			return conn.queryForArrObject(sql, null,Reserve.class);//锟睫诧拷锟斤拷时锟斤拷param为null
		}

		@Override
		//锟斤拷锟斤拷锟斤拷锟酵诧拷锟斤拷,锟斤拷锟斤拷时注锟斤拷锟叫空ｏ拷
		public List<Object> findByuserid(String userid) throws Exception {
			// TODO Auto-generated method stub
			Connect conn=Connect.getInstance();					//锟斤拷取锟斤拷锟斤拷实锟斤拷
			String sql = "select reserid,reserbegtime,reserfintime,"
					+"reserdealtime,yyuserid,byyuserid,resercity "
					+ "from tblreserve where yyuserid = ?";
			ArrayList<Object> param=new ArrayList();		//param为锟斤拷锟斤拷锟叫憋拷
			param.add(userid);
			return  conn.queryForArrObject(sql, param,Reserve.class);//锟斤拷List<Object>锟斤拷式锟斤拷锟斤拷
		}

		@Override
		//锟斤拷锟斤拷预约锟斤拷锟叫诧拷锟揭ｏ拷锟斤拷锟斤拷时锟斤拷注锟斤拷锟叫匡拷 
		public List<Object> findBycity(String resercity) throws Exception {
			// TODO Auto-generated method stub
			Connect conn=Connect.getInstance();					//锟斤拷取锟斤拷锟斤拷实锟斤拷
			String sql = "select reserid,reserbegtime,reserfintime,"
					+"reserdealtime,yyuserid,byyuserid,resercity "
					+ "from tblreserve where resercity = ?";
			ArrayList<Object> param=new ArrayList();		//param为锟斤拷锟斤拷锟叫憋拷
			param.add(resercity);
			return  conn.queryForArrObject(sql, param,Reserve.class);//锟斤拷List<Object>锟斤拷式锟斤拷锟斤拷
		}

	
	
	//锟斤拷锟斤拷预约id锟斤拷锟揭ｏ拷锟斤拷锟斤拷时锟斤拷注锟斤拷锟叫匡拷
	public Object findByid(String id, String tblname, String idname) {
		
		return (Reserve)DAOFactory.getDaoInstance().findById(tblname, id, Reserve.class,idname);
	}

}