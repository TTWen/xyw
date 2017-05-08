package rj7.dao.traveltipclt;

import rj7.bean.traveltipclt;



public class test {
	/*
	 * 向前 攻略收藏
	 * */


	public static void main(String[] args) throws Exception {
		traveltipclt gp = new traveltipclt();
		gp.setTtid("1");
		gp.setCltid("1");
		gp.setCltdid("1");
	
	    traveltipcltDAOProxy t = new traveltipcltDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加收藏成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新收藏成功！");
	    }
	   if(t.doDelete(gp.getCltid())){
	    	System.out.println("删除收藏成功！");
	    }
	
	
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			traveltipclt t2 = (traveltipclt)list1;
			System.out.println(t2.getTtid()+t2.getCltid()+t2.getCltdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
