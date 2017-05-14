package rj7.dao.traveltipcmt;

import rj7.bean.traveltipcmt;
/*
 * 郑向前 攻略评论 
 * */

public class Test {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		traveltipcmt gp = new traveltipcmt();
		gp.setTtid("1");
		gp.setCmtid("1");
		gp.setCmtdid("1");
		gp.setCmtctt("hahaha");
	
	
	
	    traveltipcmtDAOProxy t = new traveltipcmtDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加评论成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新评论成功！");
	    }
	   if(t.doDelete(gp.getCmtid())){
	    	System.out.println("删除评论成功！");
	    }
		
		
		
		Object list = t.findByid("9");

		System.out.println("按id查找:");
		if(list!=null){
			traveltipcmt t2 = (traveltipcmt)list;
			System.out.println(t2.getTtid()+t2.getCmtid()+t2.getCmtdid());
		}
		else{
			System.out.println("找不到");
		}
		
		return;
	}
	
}
