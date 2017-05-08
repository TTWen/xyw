package rj7.dao.pushshre;

import rj7.bean.pushshre;

public interface IpushshreDAO  {

	
	public boolean doCreate(pushshre t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ȡ������
	public boolean doUpdate(pushshre t)throws Exception;//��������
    public Object findByid(String tid)throws Exception; //����id����
}

 