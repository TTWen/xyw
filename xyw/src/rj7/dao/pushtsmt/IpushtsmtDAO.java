package rj7.dao.pushtsmt;

import rj7.bean.pushtsmt;

public interface IpushtsmtDAO  {

	
	public boolean doCreate(pushtsmt t)throws Exception;//����ת��
	public boolean doDelete(String t)throws Exception;//ȡ��ת��
	public boolean doUpdate(pushtsmt t)throws Exception;//����ת��
    public Object findByid(String tid)throws Exception; //����id����
}

 