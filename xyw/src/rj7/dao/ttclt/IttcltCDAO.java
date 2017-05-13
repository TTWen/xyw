package rj7.dao.ttclt;
import rj7.bean.ttclt;


/**
 * 
 * 
 * 
 */
public interface IttcltCDAO  {

	
	public boolean doCreate(ttclt t)throws Exception;//�����ղ�
	public boolean doDelete(String t)throws Exception;//ȡ���ղ�
	public boolean doUpdate(ttclt t)throws Exception;//�����ղ�
    public Object findByid(String tid)throws Exception; //����id����
}

 


