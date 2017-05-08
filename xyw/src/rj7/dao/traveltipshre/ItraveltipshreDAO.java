package rj7.dao.traveltipshre;
import rj7.bean.traveltipshre;


/**
 * 
 * 
 * 
 */
public interface ItraveltipshreDAO  {

	
	public boolean doCreate(traveltipshre t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ȡ������
	public boolean doUpdate(traveltipshre t)throws Exception;//���·���
    public Object findByid(String tid)throws Exception; //����id����
}

 
