package rj7.dao.traveltip;

import java.util.List;

import rj7.bean.Traveltip;

/**
 * ����dao��ӿ�
 * @author ����  2017.4.25
 * 
 */
public interface ITraveltipDAO {
	public Object findByid(String traveltipid)throws Exception;//����id���ҹ���
	public boolean doCreate(Traveltip t)throws Exception;//��������
	public boolean doDelete(String t)throws Exception;//ɾ������
	public boolean doUpdate(Traveltip t)throws Exception;//���¹���
	public List<Object> findAll()throws Exception;//�������й���
}