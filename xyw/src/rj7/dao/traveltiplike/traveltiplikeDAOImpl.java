package rj7.dao.traveltiplike;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.traveltiplike;
import rj7.util.Connect;

public class traveltiplikeDAOImpl implements ItraveltiplikeDAO {
	
	public boolean doCreate(traveltiplike t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); //��ȡ����ʵ�� 
				Date date=new Date();				//��ȡϵͳʱ�䲢���и�ʽ�� 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setLiket(time); 
		 		String sql = "insert into tbltraveltiplike" 
		 				+ "(ttid,likeid,likedid,liket )" 
		 				+"values(?,?,?,? )";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getTtid());							//��param���� 
		 			param.add(t.getLikedid()); 
					param.add(t.getLikeid());
					param.add(t.getLiket());
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String glid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ttid, likeid, likedid, "
				+ "liket"
				+ " from tbltraveltiplike where ttid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(glid);
		List<Object> rs = conn.queryForArrObject(sql, param,traveltiplike.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
		}
	}





	@Override
	public boolean doDelete(String ttid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "delete from tbltraveltiplike where ttid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(ttid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(traveltiplike t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tbltraveltiplike set  likedid=?,"
				+ "likeid=? ,liket=?"+
				"where ttid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getLikeid());						
			param.add(t.getLikedid()); 
			param.add(t.getLiket());
			param.add(t.getTtid());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



