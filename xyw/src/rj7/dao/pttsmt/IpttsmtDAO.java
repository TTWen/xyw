package rj7.dao.pttsmt;

import rj7.bean.pttsmt;

public interface IpttsmtDAO  {

	
	public boolean doCreate(pttsmt t)throws Exception;//����ת��
	public boolean doDelete(String t)throws Exception;//ȡ��ת��
	public boolean doUpdate(pttsmt t)throws Exception;//����ת��
    public Object findByid(String tid)throws Exception; //����id����
}

 