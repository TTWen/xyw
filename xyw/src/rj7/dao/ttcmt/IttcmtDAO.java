package rj7.dao.ttcmt;
import rj7.bean.ttcmt;
import java.util.List;

/**
 * 
 * 
 * 
 */
public interface IttcmtDAO  {

	
	public boolean doCreate(ttcmt t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ɾ������
	public boolean doUpdate(ttcmt t)throws Exception;//��������
    public Object findByid(String tid)throws Exception; //����id����
}

 
