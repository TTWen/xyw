package rj7.dao.idle;

import org.junit.Test;

import rj7.bean.Idle;
import rj7.bean.IdleFile;

//wt的test
public class test
{
	//测试按照id查找闲置物品
	/*@Test
	public  void test1()throws Exception
	{	
		String idleid = "14";
		Idle idle = (Idle) new IdleDAOProxy().findById(idleid);
		System.out.println(idle.getIdleid());
		System.out.println(idle.getIdledetail());
		System.out.println(idle.getIdlepicurl());
	}//测试成功*/
	
	
	//测试查找全部闲置物品
	/*@Test
	public void test2()throws Exception
	{
		List list = new IdleDAOProxy().findAll();
		Idle idle = null;
		System.out.println("list长度为:"+list.size());//长度为4
		if(list!=null)
		{
			for(int i = 0; i < list.size(); i++)
			{
				idle = (Idle) list.get(i);
				System.out.println("第"+(i+1)+"个闲置物品的信息如下：");
				System.out.println("idleid = "+idle.getIdleid());
				System.out.println("memid = "+idle.getMemid());
				System.out.println("idlename = "+idle.getIdlename());
				System.out.println("idledetail = "+idle.getIdledetail());
				System.out.println("idletype = "+idle.getIdletype());
				System.out.println("idletime = "+idle.getIdletime());
			}
		}
	}//测试完成
*/
	//按照用户id查找
	/*@Test
	public void test6() throws Exception
	{
		System.out.println("按照用户id查找：");
		String memid = "9";
		List<Object> list = new IdleDAOProxy().findByUser(memid);
		if(list != null)
		{
			System.out.println("list长度为："+list.size());
		}
		else
		{
			System.out.println("不存在");
		}
	}//测试成功*/
	
	
	//测试增加闲置物品
	/*@Test
	public  void test3() throws Exception
	{//测试完成
		//String idleid = "14";
		String memid = "4";
		String idlename = "coffee";
		String idledetail = "fresh";
		String idlepicurl = "d:\\pics";
		String idletype = "forfree";
		String idletime = "2017-04-25";
	
		Idle idle = new Idle();
		//idle.setIdleid(idleid);
		idle.setMemid(memid);
		idle.setIdlename(idlename);
		idle.setIdledetail(idledetail);
		idle.setIdletype(idletype);
		idle.setIdletime(idletime);
		
		boolean b = new IdleDAOProxy().addIdle(idle);
		System.out.println("b = "+b);
		if(b)
		{
			System.out.println("闲置物品增加成功！");//输出：闲置物品增加成功！查询数据库该条数据增加成功
		}
	}*/
	
	@Test
	public void test1() throws Exception
	
	{
		IdleFile file = new IdleFile();
		file.setIdleffilename("filename");
		file.setIdlefid("1");
		file.setIdlefsavepath("save");
		file.setIdlefupdatetime("time");
		file.setIdlefuuidname("uuid");
		file.setIdleid("idleid");
		System.out.println("idlefile = "+file);
		boolean b = new IdlefDAOProxy().addIdlef(file);
		System.out.println("b = "+b);
		if(b)
		{
			System.out.println("号");
		}
	}
	
	//测试按照id号删除闲置物品
	/*@Test
	public void test4() throws Exception
	{
		String idleid = "3";
		String idtype = "idleid";
		boolean b = new IdleDAOProxy().deleteIdle(idleid);
		
		if(b)
		{
			System.out.println("删除闲置物品成功！");
		}
	}//测试成功*/
	
	
	//修改更新闲置物品
	/*@Test
	public void test5()throws Exception
	{
		Idle idle = new Idle();
		idle.setIdleid("4");
		idle.setMemid("6");
		idle.setIdlename("cup");
		idle.setIdledetail("old");
		idle.setIdlepicurl("e:\\pics");
		idle.setIdletype("forsale");
		idle.setIdletime("2017-01-01");
		
		boolean b = new IdleDAOProxy().updateIdle(idle);
		if(b)
		{
			System.out.println("更新闲置物品信息成功！");
		}
	}//测试成功
*/	
}
