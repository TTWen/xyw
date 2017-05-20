package rj7.dao.pushlike;

import rj7.bean.pushlike;



public class test {
	/*
	 * 向前 推送点赞
	 * */


	public static void main(String[] args) throws Exception {
		pushlike gp = new pushlike();
	
		gp.setLikeid("1");
		gp.setLikedid("1");

	    pushlikeDAOProxy t = new pushlikeDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加点赞成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新点赞成功！");
	    }
	   if(t.doDelete(gp.getLikeid())){
	    	System.out.println("删除点赞成功！");
	    }
		

		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			pushlike t2 = (pushlike)list1;
			System.out.println(t2.getPtid()+t2.getLikeid()+t2.getLikedid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
