package rj7.dao.tttsmt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.tttsmt;
import rj7.util.Connect;

public class tttsmtDAOImpl implements ItttsmtFDAO {
	
	public boolean doCreate(tttsmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); //��ȡ����ʵ�� 
				Date date=new Date();				//��ȡϵͳʱ�䲢���и�ʽ�� 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setTsmtt(time); 
		 		String sql = "insert into tbltttsmt" 
		 				+ "(ttid,tsmtid,tsmtdid,tsmtt )" 
		 				+"values(?,?,?,? )";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getTtid());							//��param���� 
		 			param.add(t.getTsmtid()); 
					param.add(t.getTsmtdid());
					param.add(t.getTsmtt());
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String glid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ttid,tsmtid,tsmtdid,tsmtt "
				+ " from tblGLZhuanF where glid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(glid);
		List<Object> rs = conn.queryForArrObject(sql, param,tttsmt.class);
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
		String sql = "delete from tbltttsmt where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(glid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(tttsmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tbltttsmt set  tsmtdid=?,"
				+ "tsmtid=?, tsmtt=?"+
				"where ttid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getTsmtdid());						
			param.add(t.getTsmtid()); 
			param.add(t.getTsmtt());
			param.add(t.getTtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



