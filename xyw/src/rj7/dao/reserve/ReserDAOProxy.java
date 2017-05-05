package rj7.dao.reserve;


import rj7.bean.Reserve;
import java.util.*;
import rj7.util.Connect;

//ԤԼ�Ĵ�����
public class ReserDAOProxy implements IReserDAO {
	ReserDAOImpl dao =  new ReserDAOImpl();
	Connect conn = Connect.getInstance();
	
	@Override
	//����ԤԼ
	public boolean doCreate(Reserve r) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(dao.doCreate(r)){
			flag = true;
		}
		return flag;
	}

	@Override
	//ɾ��ԤԼ
	public boolean doDelete(String reserid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doDelete(reserid)){
			flag = true;
		}
		return flag;
	}
	//�޸�ԤԼ
	public boolean doUpdate(Reserve r) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(this.dao.doUpdate(r)){
			flag = true;
		}
		return flag;
	}

	
	@Override
	//��������
	public List<Object> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findAll();
		return list; 
	}
	
	
	
	//����ԤԼid����
	public Object findByid(String id,String tblname,String idname) throws Exception {
		// TODO Auto-generated method stub
		Object obj = null;
		obj = this.dao.findByid(id,tblname,idname);
		return obj; 
	}
	
	
	@Override
	//���û�id����
	public List<Object> findByuserid(String userid) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findByuserid(userid);
		return list; 
	}


	@Override
	//����ԤԼ���в���
	public List<Object> findBycity(String resercity) throws Exception {
		// TODO Auto-generated method stub
		List<Object> list = null;
		list = this.dao.findBycity(resercity);
		return list; 
	}
}



