package rj7.dao.ttcmt;

import rj7.bean.ttcmt;


public class Test {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ttcmt gp = new ttcmt();
		gp.setTtid("1");
		gp.setCmtid("1");
		gp.setCmtdid("1");
		gp.setCmtctt("hahaha");
	
	
	
	    ttvmtDAOProxy t = new ttvmtDAOProxy();
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
			ttcmt t2 = (ttcmt)list;
			System.out.println(t2.getTtid()+t2.getCmtid()+t2.getCmtdid());
		}
		else{
			System.out.println("找不到");
		}
		
		return;
	}
	
}
