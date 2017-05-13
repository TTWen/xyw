package rj7.dao.ptshre;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.ptshre;
import rj7.util.Connect;

public class ptshreDAOImpl implements IptshreDAO {
	
	public boolean doCreate(ptshre t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); 
				Date date=new Date();				
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setShret(time); 
		 		String sql = "insert into tblptshre" 
		 				+ "(ptid,shreid,shredid,shret )" 
		 				+"values(?,?,?,?)";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getPtid());							//��param���� 
		 			param.add(t.getShreid()); 
					param.add(t.getShredid());
					param.add(t.getShret());
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String tsid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ptid,shreid,shredid,shret"
				+ " from tblptshre where ptid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(tsid);
		List<Object> rs = conn.queryForArrObject(sql, param,ptshre.class);
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
		String sql = "delete from tblptshre where ptid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(tsid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(ptshre t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblptshre set  shredid=?,"
				+ "shreid=?, shret=?"+
				"where ptid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getShredid());						
			param.add(t.getShreid()); 
			param.add(t.getShret());
			param.add(t.getPtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



