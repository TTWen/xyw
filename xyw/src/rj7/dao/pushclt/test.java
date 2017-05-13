package rj7.dao.pushclt;

import rj7.bean.pushclt;



public class test {
/*
 * 向前 推送收藏collect
 * */

	public static void main(String[] args) throws Exception {
		pushclt gp = new pushclt();
		gp.setPtid("1");
		gp.setCltid("1");
		gp.setCltdid("1");
		
	

	    pushcltDAOProxy t = new pushcltDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加收藏成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新收藏成功！");
	    }
	    
	   if(t.doDelete(gp.getCltid())){
	    	System.out.println("删除收藏成功！");
	    }
		

        Object list1 = t.findByid("1");

		System.out.println("按id查找:");
		if(list1!=null){
			pushclt t2 = (pushclt)list1;
			System.out.println(t2.getPtid()+t2.getCltid()+t2.getCltdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
