package rj7.dao.attention;

import java.util.ArrayList;

import rj7.bean.Attention;

public interface IAttentionDAO {
	 public boolean AttentionUser(Attention atten) throws Exception; //��ע����
	 public boolean UnAttentionUser(Attention atten) throws Exception;//ȡ����ע
	 public ArrayList <Attention> findById(String userid) throws Exception;//��ѯ�ѱ���ע�ĺ���
}
