package rj7.dao.ptshre;

import rj7.bean.ptshre;

public interface IptshreDAO  {

	
	public boolean doCreate(ptshre t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ȡ������
	public boolean doUpdate(ptshre t)throws Exception;//��������
    public Object findByid(String tid)throws Exception; //����id����
}

 