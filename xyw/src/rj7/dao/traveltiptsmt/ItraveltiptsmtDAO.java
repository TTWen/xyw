package rj7.dao.traveltiptsmt;
import rj7.bean.traveltiptsmt;


/**
 * 
 * 
 * 
 */
public interface ItraveltiptsmtDAO  {

	
	public boolean doCreate(traveltiptsmt t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ȡ������
	public boolean doUpdate(traveltiptsmt t)throws Exception;//���µ���
    public Object findByid(String tid)throws Exception; //����id����
}

 
