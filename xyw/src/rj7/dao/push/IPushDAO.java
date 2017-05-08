package rj7.dao.push;
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
	public List<Object> findAll()throws Exception;//查找所有推送
	public Object findByid(String pid)throws Exception;//按照id查找
	public List<Object> findBytype(String type)throws Exception;//按照推送类型查找
	public List<Object> findByhot()throws Exception;//按照热度查找
	
}
