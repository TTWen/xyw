package rj7.dao.pttsmt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.pttsmt;
import rj7.util.Connect;

public class pttsmtDAOImpl implements IpttsmtDAO {
	
	public boolean doCreate(pttsmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance();
				Date date=new Date();				 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setTsmtt(time); 
		 		String sql = "insert into tblpttsmt" 
		 				+ "(ptid,tsmtid,tsmtdid,tsmtt )" 
		 				+"values(?,?,?,?)";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getPtid());							//��param���� 
		 			param.add(t.getTsmtid()); 
					param.add(t.getTsmtdid());
					param.add(t.getTsmtt());
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String tsid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ptid,tsmtid,tsmtdid,tsmtt"
				+ " from tblpttsmt where ptid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(tsid);
		List<Object> rs = conn.queryForArrObject(sql, param,pttsmt.class);
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
		String sql = "delete from tblpttsmt where ptid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(tsid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(pttsmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblpttsmt set  tsmtdid=?,"
				+ "tsmtid=?, tsmtt=?"+
				"where ptid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getTsmtdid());						
			param.add(t.getTsmtid()); 
			param.add(t.getTsmtt());
			param.add(t.getPtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



