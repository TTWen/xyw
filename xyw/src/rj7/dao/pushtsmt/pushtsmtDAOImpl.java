package rj7.dao.pushtsmt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.pushtsmt;
import rj7.util.Connect;

public class pushtsmtDAOImpl implements IpushtsmtDAO {
	
	public boolean doCreate(pushtsmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance();
				Date date=new Date();				 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setTsmtt(time); 
		 		String sql = "insert into tblpushtsmt" 
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
				+ " from tblpushtsmt where ptid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(tsid);
		List<Object> rs = conn.queryForArrObject(sql, param,pushtsmt.class);
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
		String sql = "delete from tblpushtsmt where ptid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(tsid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(pushtsmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblpushtsmt set  tsmtdid=?,"
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



