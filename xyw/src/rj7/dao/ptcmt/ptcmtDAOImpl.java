package rj7.dao.ptcmt;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.ptcmt;
import rj7.util.Connect;

public class ptcmtDAOImpl implements IptcmtDAO {
	
	public boolean doCreate(ptcmt t) throws Exception { 
		 		// TODO Auto-generated method stub 
				boolean flag = false; 
				Connect conn=Connect.getInstance(); //��ȡ����ʵ�� 
				Date date=new Date();				//��ȡϵͳʱ�䲢���и�ʽ�� 
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	 		    String time=format.format(date); 
		        t.setCmtt(time); 
		 		String sql = "insert into tblptcmt" 
		 				+ "(ptid,cmtid,cmtdid,cmtt,cmtctt )" 
		 				+"values(?,?,?,?,?)";			//sql��� 
				ArrayList <Object> param=new ArrayList();		//paramΪ�����б� 
				    param.add(t.getPtid());							//��param���� 
		 			param.add(t.getCmtid()); 
					param.add(t.getCmtdid());
					param.add(t.getCmtt());
					param.add(t.getCmtctt());
				    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н���� 
					flag = true; 
			    } 
			    return flag;									//��ӳɹ�flag=true,����flag=false 
		} 

	
	

	
	public Object findByid(String tsid) throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					
		String sql = "select ptid,cmtid,cmtdid,cmtt,cmtctt"
				+ " from tblptcmt where ptid = ?";
		ArrayList<Object> param=new ArrayList();		
		param.add(tsid);
		List<Object> rs = conn.queryForArrObject(sql, param,ptcmt.class);
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
		String sql = "delete from tblptcmt where ptid = ?";	
			ArrayList<Object> param=new ArrayList();		
			param.add(tsid);							
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}



	@Override
	public boolean doUpdate(ptcmt t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					
		String sql = "update tblptcmt set  cmtdid=?,"
				+ "cmtid=?,cmtctt=?,cmtt=?"+
				"where ptid = ?";							
			ArrayList<Object> param=new ArrayList();		
			param.add(t.getCmtdid());						
			param.add(t.getCmtid()); 
			param.add(t.getCmtctt());
			param.add(t.getCmtt());
			
		    if(conn.update(sql, param)!=0){					
			flag = true;
		    }
		    return flag;									
	}
	

}



