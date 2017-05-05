package rj7.dao.ttshre;
import rj7.bean.ttshre;


/**
 * 
 * 
 * 
 */
public interface IttshreXDAO  {

	
	public boolean doCreate(ttshre t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ȡ������
	public boolean doUpdate(ttshre t)throws Exception;//���·���
    public Object findByid(String tid)throws Exception; //����id����
}

 
