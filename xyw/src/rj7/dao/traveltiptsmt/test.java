package rj7.dao.traveltiptsmt;

import rj7.bean.traveltiptsmt;

public class test {
/*
 * 
 * 向前 攻略转发
 * */	
	
	


	public static void main(String[] args) throws Exception {
		traveltiptsmt gp = new traveltiptsmt();
		gp.setTtid("1");
		gp.setTsmtid("1");
		gp.setTsmtdid("1");
		gp.setTsmtctt("hahaha");
	
	
	
	    traveltiptsmtDAOProxy t = new traveltiptsmtDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加转发成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新转发成功！");
	    }
	   if(t.doDelete(gp.getTsmtid())){
	    	System.out.println("删除转发成功！");
	    }
		
		
		
		Object list = t.findByid("9");
		
		
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			traveltiptsmt t2 = (traveltiptsmt)list1;
			System.out.println(t2.getTtid()+t2.getTsmtid()+t2.getTsmtdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
