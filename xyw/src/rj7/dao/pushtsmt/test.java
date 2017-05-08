package rj7.dao.pushtsmt;

import rj7.bean.pushtsmt;


public class test {
/*
 * 向前 推送转发
 * */

	public static void main(String[] args) throws Exception {
		pushtsmt gp = new pushtsmt();
		gp.setPtid("1");
		gp.setTsmtid("1");
		gp.setTsmtdid("1");
		gp.setTsmtctt("lalala");
			
	    pushtsmtDAOProxy t = new pushtsmtDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加转发成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新转发成功！");
	    }
	   if(t.doDelete(gp.getTsmtid())){
	    	System.out.println("删除转发成功！");
	    }
		
		
		Object list1 = t.findByid("9");

		Object list = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			pushtsmt t2 = (pushtsmt)list1;
			System.out.println(t2.getPtid()+t2.getTsmtid()+t2.getTsmtdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
