package rj7.dao.idle;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rj7.bean.Idle;
import rj7.util.DAOFactory;

//wt的test
public class test
{
	@Test
	public  void test1()throws Exception
	{//测试按照id查找闲置物品
		//数据库里已经设置好了两组数据
		
		
		String idleid = "1";
		Idle idle = (Idle) DAOFactory.getDaoInstance().findById("tblidle",  idleid, Idle.class, "idleid");
		System.out.println(idle.getIdleid());//输出：1
		System.out.println(idle.getIdledetail());//输出：new
		System.out.println(idle.getIdlepicurl());//输出：d:\pics
		
		
		/*String idleid = "2";
		Idle idle = (Idle) DAOFactory.getDaoInstance().findById("tblidle", idleid, "idleid",Idle.class);
		System.out.println(idle.getIdleid());//输出：2
		System.out.println(idle.getIdledetail());//输出：old
		System.out.println(idle.getIdletime());//输出：2017-04-23*/	
	}
	
	@Test
	public void test2()throws Exception
	{//测试查找全部闲置物品
		List list = DAOFactory.getIDaoInstance().findAll();
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
				System.out.println("idlepicurl = "+idle.getIdlepicurl());
				System.out.println("idletype = "+idle.getIdletype());
				System.out.println("idletime = "+idle.getIdletime());
			}
		}
	}//测试完成，依次输出每个闲置物品的所有属性
	
	@Test
	public  void test3() throws Exception
	{//测试增加闲置物品
		String idleid = "4";
		String memid = "4";
		String idlename = "coffee";
		String idledetail = "fresh";
		String idlepicurl = "d:\\pics";
		String idletype = "forfree";
		String idletime = "2017-04-25";
	
		Idle idle = new Idle();
		idle.setIdleid(idleid);
		idle.setMemid(memid);
		idle.setIdlename(idlename);
		idle.setIdledetail(idledetail);
		idle.setIdlepicurl(idlepicurl);
		idle.setIdletype(idletype);
		idle.setIdletime(idletime);
		
		boolean b = DAOFactory.getIDaoInstance().addIdle(idle);
		if(b)
		{
			System.out.println("闲置物品增加成功！");//输出：闲置物品增加成功！查询数据库该条数据增加成功
		}
	}
	
	@Test
	public void test4() throws Exception
	{//测试按照id号删除闲置物品
		String idleid = "2";
		String idtype = "idleid";
		boolean b = DAOFactory.getIDaoInstance().deleteIdle(idleid);
		
		if(b)
		{
			System.out.println("删除闲置物品成功！");
		}
	}
	
	@Test
	public void test5()throws Exception
	{
		Idle idle = new Idle();
		idle.setIdleid("3");
		idle.setMemid("4");
		idle.setIdlename("cup");
		idle.setIdledetail("new");
		idle.setIdlepicurl("e:\\pics");
		idle.setIdletype("forsale");
		idle.setIdletime("2017-04-26");
		
		boolean b = DAOFactory.getIDaoInstance().updateIdle(idle);
		if(b)
		{
			System.out.println("更新闲置物品信息成功！");
		}
	}
}









