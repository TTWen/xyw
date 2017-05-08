package rj7.dao.traveltipclt;
import rj7.bean.traveltipclt;


/**
 * 
 * 
 * 
 */
public interface ItraveltipcltCDAO  {

	
	public boolean doCreate(traveltipclt t)throws Exception;//�����ղ�
	public boolean doDelete(String t)throws Exception;//ȡ���ղ�
	public boolean doUpdate(traveltipclt t)throws Exception;//�����ղ�
    public Object findByid(String tid)throws Exception; //����id����
}

 


