package rj7.dao.traveltipshre;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.traveltipshre;
import rj7.util.Connect;

public class traveltipshreDAOImpl implements ItraveltipshreXDAO {
	
	/*
	 * 向前 攻略分享
	 * */
	
	public boolean doCreate(traveltipshre t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance();
				Date date=new Date();				
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setShret(time); 
		 		String sql = "insert into tbltraveltipshre" 
		 				+ "(ttid,shreid,shredid,shret )" 
		 				+"values(?,?,?,? )";			
				ArrayList <Object> param=new ArrayList();		
				    param.add(t.getTtid());						
		 			param.add(t.getShreid()); 
					param.add(t.getShredid());
					param.add(t.getShret());
				    if(conn.update(sql, param)!=0){			
					flag = true; 
			    } 
			    return flag;								
		} 

	
	

	
	public Object findByid(String glid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ttid,shreid,shredid,shret"
				+ " from tbltraveltipshre where ttid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(glid);
		List<Object> rs = conn.queryForArrObject(sql, param,traveltipshre.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}





	@Override
	public boolean doDelete(String glid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "delete from tbltraveltipshre where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(glid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(traveltipshre t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tbltraveltipshre set  shredid=?,"
				+ "shreid=?,shret=?"+
				"where ttid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getShredid());						
			param.add(t.getShreid()); 
			param.add(t.getShret());
			param.add(t.getTtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



