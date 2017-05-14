package rj7.dao.ptclt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.ptclt;
import rj7.util.Connect;

public class ptcltDAOImpl implements IptcltDAO {
	
	public boolean doCreate(ptclt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance();
				Date date=new Date();				
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setCltt(time); 
		 		String sql = "insert into tblptclt" 
		 				+ "(ptid,cltid,cltdid,cltt )" 
		 				+"values(?,?,?,?)";			
				ArrayList <Object> param=new ArrayList();		
				    param.add(t.getPtid());							
		 			param.add(t.getCltid()); 
					param.add(t.getCltdid());
					param.add(t.getCltt());
				    if(conn.update(sql, param)!=0){					
					flag = true; 
			    } 
			    return flag;									
		} 

	
	

	
	public Object findByid(String tsid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ptid,cltid,cltdid,cltt,"
				+ " from tblptclt where ptid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(tsid);
		List<Object> rs = conn.queryForArrObject(sql, param,ptclt.class);
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
		String sql = "delete from tblTSShouC where ptid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(tsid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(ptclt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblTSShouC set  beiscyhid=?,"
				+ "scyhid=?, sctime=?"+
				"where ptid = ?";							
			ArrayList<Object> param=new ArrayList();		
									
 			param.add(t.getCltid()); 
			param.add(t.getCltdid());
			param.add(t.getCltt());
			param.add(t.getPtid());	
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



