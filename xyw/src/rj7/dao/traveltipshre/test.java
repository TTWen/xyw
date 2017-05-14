package rj7.dao.traveltipshre;

import rj7.bean.traveltipshre;



public class test {


	public static void main(String[] args) throws Exception {
		traveltipshre gp = new traveltipshre();
		gp.setTtid("1");
		gp.setShreid("1");
		gp.setShredid("1");
		gp.setShrectt("hahaha");
	
	
	
	    traveltipshreDAOProxy t = new traveltipshreDAOProxy();
	    if(t.doCreate(gp)){
	    	System.out.println("添加分享成功！");
	    }
	    
	    
	    if(t.doUpdate(gp)){
	    	System.out.println("更新分享成功！");
	    }
	   if(t.doDelete(gp.getShreid())){
	    	System.out.println("删除分享成功！");
	    }
	   
		Object list1 = t.findByid("9");
		
		System.out.println("按id查找:");
		if(list1!=null){
			traveltipshre t2 = (traveltipshre)list1;
			System.out.println(t2.getTtid()+t2.getShreid()+t2.getShredid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
