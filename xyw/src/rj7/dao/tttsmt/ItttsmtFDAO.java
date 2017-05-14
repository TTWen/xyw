package rj7.dao.tttsmt;
import rj7.bean.tttsmt;


/**
 * 
 * 
 * 
 */
public interface ItttsmtFDAO  {

	
	public boolean doCreate(tttsmt t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ȡ������
	public boolean doUpdate(tttsmt t)throws Exception;//���µ���
    public Object findByid(String tid)throws Exception; //����id����
}

 
