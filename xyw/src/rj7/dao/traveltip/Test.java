package rj7.dao.traveltip;

import java.util.ArrayList;
import java.util.List;

import rj7.bean.Traveltip;
import rj7.util.Connect;
import rj7.util.DAOFactory;

/**
 * 攻略dao层测试
 * @author 马华丽  2017.4.25
 * 
 */
public class Test
{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Traveltip ts = new Traveltip();
		ts.setUserid("8");
		ts.setLikecnt("0");
		ts.setViewcnt("0");;
		ts.setCmtcnt("0");
		ts.setTsmtcnt("0");
		ts.setContent("hahaha");
		ts.setTitle("yoyoyo");
		
	
	    TraveltipDAOProxy t = new TraveltipDAOProxy();
	    if(t.doCreate(ts)){
	    	System.out.println("====================addok");
	    }
	   
	  if(t.doDelete("4")){
	    	System.out.println("====================deleteok");
	    }
		
		
		TraveltipDAOProxy tt = new TraveltipDAOProxy();
	
		List list1 = tt.findAll();
	 
		Object list3 = tt.findByid("2");

		System.out.println("全部查找:");
		for(Object tt1:list1){
			Traveltip t2 = (Traveltip)tt1;
			System.out.println(t2.getTraveltipid()+t2.getTitle()+t2.getUserid());
			
		}
			
		
		System.out.println("按id查找:");
		if(list3!=null){
			Traveltip t2 = (Traveltip)list3;
			System.out.println(t2.getTraveltipid()+t2.getTitle()+t2.getUserid());
		}
		else{
			System.out.println("不存在！");
		}
		return;
	}
	
}

