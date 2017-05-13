package rj7.dao.traveltip;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rj7.bean.Traveltip;
import rj7.bean.Tuisong;
import rj7.util.Connect;
import rj7.util.DAOFactory;

/**
 * ����dao��ӿ�ʵ��
 * @author ����  2017.4.25
 * 
 */

public class TraveltipDAOImpl implements ITraveltipDAO { 
	
	//��id����
	public Object findByid(String traveltipid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select traveltipid,time,userid,title,content,pic,"
				+ "viewcnt,likecnt,tsmtcnt,cmtcnt"
				+ " from tbltraveltip where traveltipid = ?";
		//paramΪ�����б�
		ArrayList<Object> param=new ArrayList();		
		param.add(traveltipid);
		Connect conn=Connect.getInstance();
		List<Object> rs = conn.queryForArrObject(sql, param,Traveltip.class);
		if(rs.size()!=0){
			return rs.get(0);
		}
		else{
			return null;
			}
		}
	//����������
	public boolean doCreate(Traveltip t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance(); //��ȡ����ʵ��
		Date date=new Date();				//��ȡϵͳʱ�䲢���и�ʽ��
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
	    t.setTime(time);
		String sql = "insert into tbltraveltip"
				+ "(traveltipid,time,userid,title,content,pic,viewcnt,likecnt,tsmtcnt,cmtcnt)"
				+"values(?,?,?,?,?,?,?,?,?,?)";			//sql���
			ArrayList<Object> param=new ArrayList();		//paramΪ�����б�
			param.add(t.getTraveltipid());							//��param����Ӳ���
			param.add(t.getTime());
			param.add(t.getUserid());
			param.add(t.getTitle());
			param.add(t.getContent());
			param.add(t.getPic());
			param.add(t.getViewcnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
		    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н����
			flag = true;
		    }
		    return flag;									//��ӳɹ�flag=true,����flag=false
	}

	@Override
	//ɾ��������
	public boolean doDelete(String traveltipid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//��ȡ����ʵ��
		String sql = "delete from tbltraveltip where traveltipid = ?";	//sql���
			ArrayList<Object> param=new ArrayList();		//paramΪ�����б�
			param.add(traveltipid);							//��param����Ӳ���id
		    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н����
			flag = true;
		    }
		    return flag;									//ɾ��avel�ɹ�flag=true,����flag=false
	}

	@Override
	//�޸Ĺ�����
	public boolean doUpdate(Traveltip t) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connect conn=Connect.getInstance();					//��ȡ����ʵ��
		String sql = "update tbltraveltip set time=?,userid=?,title=?,content=?,"
				+ "pic=?,viewcnt=?,likecnt=?,tsmtcnt=?,cmtcnt=? "+
				"where traveltipid = ?";							//sql���
			ArrayList<Object> param=new ArrayList();		//paramΪ�����б�
			param.add(t.getTime());						//��param����Ӳ���
			param.add(t.getUserid());
			param.add(t.getTitle());
			param.add(t.getContent());
			param.add(t.getPic());
			param.add(t.getViewcnt());
			param.add(t.getLikecnt());
			param.add(t.getTsmtcnt());
			param.add(t.getCmtcnt());
			param.add(t.getTraveltipid());	
		    if(conn.update(sql, param)!=0){					//ִ��sql��䷵��ִ�н����
			flag = true;
		    }
		    return flag;									//��ӳɹ�flag=true,����flag=false
	}
	@Override
	//��ѯ���й���,����ʱע���пգ�
	public List<Object> findAll() throws Exception {
		// TODO Auto-generated method stub
		Connect conn=Connect.getInstance();					//��ȡ����ʵ��
		String sql = "select traveltipid,time,userid,title,content,pic,"
				+ "viewcnt,likecnt,tsmtcnt,cmtcnt "
				+ "from tbltraveltip order by traveltipid";
		return conn.queryForArrObject(sql, null,Traveltip.class);//�޲���ʱ��paramΪnull
	}
}