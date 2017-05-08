package rj7.dao.traveltip;

import java.util.List;

import rj7.bean.Traveltip;

/**
 * 攻略dao层接口
 * @author 马华丽  2017.4.25
 * 
 */
public interface ITraveltipDAO {
	public Traveltip findById(String id, String tblname,String idtype);//按照id查找攻略
	public boolean doCreate(Traveltip t)throws Exception;//创建攻略
	public boolean doDelete(String t)throws Exception;//删除攻略
	public boolean doUpdate(Traveltip t)throws Exception;//更新攻略
	public List<Object> findAll()throws Exception;//查找所有攻略
}