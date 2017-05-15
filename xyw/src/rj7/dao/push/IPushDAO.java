package rj7.dao.push;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rj7.bean.Push;
/**
 * @author lawonder
 * 2017/5/8
 * 推送接口
 */
public interface IPushDAO {
	public boolean doCreate(Push t)throws Exception;//创建推送
	public boolean doDelete(String t)throws Exception;//删除推送
	public boolean doUpdate(Push t)throws Exception;//更新推送
	public ArrayList<Push> findAll()throws Exception;//查找所有推送
	public Push findByid(String pid)throws Exception;//按照id查找
	public ArrayList<Push> findBytype(String type)throws Exception;//按照推送类型查找
	public ArrayList<Push> findByhot()throws Exception;//按照热度查找
	public ArrayList<Push> findBytime(Date datebefore,Date dateafter)throws Exception;//按照时间查找
	public ArrayList<Push> findRecent(Date date)throws Exception;//查找最近
}
