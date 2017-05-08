package rj7.dao.pushshre;

import rj7.bean.pushshre;



public class test {
	/*
	 * 向前 推送分享
	 * */


	public static void main(String[] args) throws Exception {
		pushshre gp = new pushshre();
		gp.setPtid("1");
		gp.setShreid("1");
		gp.setShredid("1");
		gp.setShrectt("lalala");
		
	
	
	
	    pushshreDAOProxy t = new pushshreDAOProxy();
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
	
		
		
		Object list = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			pushshre t2 = (pushshre)list1;
			System.out.println(t2.getPtid()+t2.getShreid()+t2.getShredid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
