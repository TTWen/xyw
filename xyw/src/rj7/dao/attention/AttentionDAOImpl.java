package rj7.dao.attention;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Attention;
import rj7.bean.MemberDetail;
import rj7.util.Connect;

public class AttentionDAOImpl implements IAttentionDAO{
	//��ע����
     public boolean AttentionUser(Attention atten) throws Exception{
        boolean flag=false;
    	Connect conn=Connect.getInstance();
 		String sql = "insert into tblatten (countid,userid,attenid,attentime)"
 				+ "values (?,?,?,STR_TO_DATE(?,'%Y-%m-%d %H:%i:%s'))";
 		ArrayList param=new ArrayList();
 		param.add(atten.getCoinid());
 	 	param.add(atten.getUserid());
 		param.add(atten.getCoinid());
 		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=format.format(date);
	    System.out.print(time); 
		param.add(time);
 		int result = conn.update(sql, param);
 		if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     //ȡ����ע
     public boolean UnAttentionUser(Attention atten) throws Exception{
    	 boolean flag=false;
     	Connect conn=Connect.getInstance();
     	String sql = "delete from tblatten where userid = ? && attenid = ?";
     	List<Object> param = new ArrayList<Object>();
		param.add(atten.getUserid());
        param.add(atten.getCoinid());
        int result = conn.update(sql, param);
        if(result>0){
 			flag = true;
 		}
 		return flag;
     }
     
     //��ѯ�����ѹ�ע�ĺ���
     public ArrayList <Attention> findById(String userid) throws Exception{
 		String sql = "select username,userage,iconurl from tblMemberDetail"
 				+ "where id = (select attenid from tblatten where userid = ?)";
 		Connect conn = Connect.getInstance();
 		List<Object> param = new ArrayList<Object>();
 		param.add(userid);
 		//����ѯ�����װ��javabean��
 		ArrayList<Attention> atten = (ArrayList)conn.queryForArrObject(sql, param, Attention.class);
 		return atten;
 	}
}
