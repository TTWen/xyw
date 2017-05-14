package rj7.dao.ttcmt;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.ttcmt;
import rj7.util.Connect;
/*
 * @author zxq
 * 
 * 
 * 
*/

public class ttcmtDAOImpl implements IttcmtDAO {
	
	public boolean doCreate(ttcmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); 
				Date date=new Date();				
				//System.out.print("date = "+date);
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
	 		   System.out.print("time = "+time);
		        t.setCmtt(time); 
		 		String sql = "insert into tblttcmt" 
		 				+ "(ttid,cmtid,cmtdid,cmtt,cmtctt)" 
		 				+"values(?,?,?,?,? )";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getTtid());							//��param����Ӳ��� 
				    param.add(t.getCmtid());
				    param.add(t.getCmtdid());
				    param.add(t.getCmtt()); 
				    param.add(t.getCmtctt()); 
		 			
					
					
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String glid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select gttid,cmtid,cmtdid,cmtt,cmtctt"
				+ " from tblttcmt where ttid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(glid);
		List<Object> rs = conn.queryForArrObject(sql, param,ttcmt.class);
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
		String sql = "delete from tblttcmt where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(glid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(ttcmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblttcmt set  cmtdid=?,"
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



