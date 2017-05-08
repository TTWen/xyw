package rj7.dao.pushcmt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.pushcmt;
import rj7.util.Connect;

public class pushcmtDAOImpl implements IpushcmtDAO {
	
	public boolean doCreate(pushcmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); 
				Date date=new Date();				
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setCmtt(time); 
		 		String sql = "insert into tblpushcmt" 
		 				+ "(ptid,cmtid,cmtdid,cmtt,cmtctt )" 
		 				+"values(?,?,?,?,?)";			
				ArrayList <Object> param=new ArrayList();		
				    param.add(t.getPtid());						
		 			param.add(t.getCmtid()); 
					param.add(t.getCmtdid());
					param.add(t.getCmtt());
					param.add(t.getCmtctt());
				    if(conn.update(sql, param)!=0){					
					flag = true; 
			    } 
			    return flag;								
		} 

	
	

	
	public Object findByid(String tsid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ptid,cmtid,cmtdid,cmtt,cmtctt"
				+ " from tblpushcmt where ptid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(tsid);
		List<Object> rs = conn.queryForArrObject(sql, param,pushcmt.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}





	@Override
	public boolean doDelete(String tsid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "delete from tblpushcmt where ptid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(tsid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(pushcmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblpushcmt set  cmtdid=?,"
				+ "cmtid=?,cmtctt=?,cmtt=?"+
				"where ptid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getCmtdid());						
			param.add(t.getCmtid()); 
			param.add(t.getCmtctt());
			param.add(t.getCmtt());
			param.add(t.getPtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



