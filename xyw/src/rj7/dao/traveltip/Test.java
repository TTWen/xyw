package rj7.dao.traveltip;

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
		ts.setCommcnt("0");
		ts.setForwadcnt("0");
		ts.setCon("hahaha");
		ts.setTit("yoyoyo");
		ts.setId(null);			//设置为null后，从上一个id开始+1
		ts.setPic("1");
		
	
	    TraveltipDAOProxy t = new TraveltipDAOProxy();
	    if(t.doCreate(ts)){
	    	System.out.println("====================addok");
	    }
	    
	   
	  if(t.doDelete(ts.getId())){
	    	System.out.println("====================deleteok");
	    }
		
		
		TraveltipDAOProxy tt = new TraveltipDAOProxy();
	
		List list1 = tt.findAll();
	 
		Object list3 = tt.findById("9","tbltraveltip", "id");

		System.out.println("全部查找:");
		for(Object tt1:list1){
			Traveltip t2 = (Traveltip)tt1;
			System.out.println(t2.getId()+t2.getTit()+t2.getUserid());
			
		}
			
		
		System.out.println("按id查找:");
		if(list3!=null){
			Traveltip t2 = (Traveltip)list3;
			System.out.println(t2.getId()+t2.getTit()+t2.getUserid());
		}
		else{
			System.out.println("不存在！");
		}
		return;
	}
	
}

