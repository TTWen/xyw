package rj7.dao.pushcmt;

import rj7.bean.pushcmt;



public class test {
	/*
	 * 向前 推送评论 coment
	 * */


	public static void main(String[] args) throws Exception {
		
		pushcmt gp = new pushcmt();
		gp.setPtid("1");
		gp.setCmtid("1");
		gp.setCmtdid("1");
		gp.setCmtctt("balababa");
	

	    pushcmtDAOProxy t = new pushcmtDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加评论成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新评论成功！");
	    }
	    
	   if(t.doDelete(gp.getCmtid())){
	    	System.out.println("删除评论成功！");
	    }
		

		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			pushcmt t2 = (pushcmt)list1;
			System.out.println(t2.getPtid()+t2.getCmtid()+t2.getCmtdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
