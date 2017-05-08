package rj7.dao.traveltipcmt;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.traveltipcmt;
import rj7.util.Connect;
/*
 * @author 郑向前 攻略评论
 * 
 * 
 * 
*/

public class traveltipcmtDAOImpl implements ItraveltipcmtDAO {
	
	public boolean doCreate(traveltipcmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); 
				Date date=new Date();				
				//System.out.print("date = "+date);
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
	 		   System.out.print("time = "+time);
		        t.setCmtt(time); 
		 		String sql = "insert into tbltraveltipcmt" 
		 				+ "(ttid,cmtid,cmtdid,cmtt,cmtctt)" 
		 				+"values(?,?,?,?,? )";			
				ArrayList <Object> param=new ArrayList();	
				    param.add(t.getTtid());							
				    param.add(t.getCmtid());
				    param.add(t.getCmtdid());
				    param.add(t.getCmtt()); 
				    param.add(t.getCmtctt()); 
		 			
					
					
				    if(conn.update(sql, param)!=0){					
					flag = true; 
			    } 
			    return flag;									 
		} 

	
	

	
	public Object findByid(String ttid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ttid,cmtid,cmtdid,cmtt,cmtctt"
				+ " from tbltraveltipcmt where ttid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(ttid);
		List<Object> rs = conn.queryForArrObject(sql, param,traveltipcmt.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}





	@Override
	public boolean doDelete(String t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "delete from tbltraveltipcmt where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(t);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(traveltipcmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tbltraveltipcmt set  cmtdid=?,"
				+ "cmtid=?, cmtctt=?,cmtt=?"+
				"where ttid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getCmtdid());						
			param.add(t.getCmtid());
			param.add(t.getCmtctt());
			param.add(t.getCmtt());
			param.add(t.getTtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



