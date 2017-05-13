package rj7.dao.traveltiptsmt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.traveltiptsmt;
import rj7.util.Connect;

public class traveltiptsmtDAOImpl implements ItraveltiptsmtFDAO {
	
	public boolean doCreate(traveltiptsmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); //��ȡ����ʵ�� 
				Date date=new Date();				//��ȡϵͳʱ�䲢���и�ʽ�� 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setTsmtt(time); 
		 		String sql = "insert into tbltraveltiptsmt" 
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

	
	

	
	public Object findByid(String ttid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ttid,tsmtid,tsmtdid,tsmtt "
				+ " from tbltraveltiptsmt where ttid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(ttid);
		List<Object> rs = conn.queryForArrObject(sql, param,traveltiptsmt.class);
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
		String sql = "delete from tbltraveltiptsmt where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(glid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(traveltiptsmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tbltraveltiptsmt set  tsmtdid=?,"
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



