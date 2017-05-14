 package rj7.dao.traveltiplike;

 import rj7.bean.traveltiplike;



public class test {
	/*
	 * 向前 攻略点赞
	 * */


	public static void main(String[] args) throws Exception {
		
		traveltiplike gp = new traveltiplike();
		gp.setTtid("1");
		gp.setLikeid("1");
		gp.setLikedid("1");
		
	
	
	
	    traveltiplikeDAOProxy t = new traveltiplikeDAOProxy();
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
			traveltiplike t2 = (traveltiplike)list1;
			System.out.println(t2.getTtid()+t2.getLikeid()+t2.getLikedid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
