package rj7.dao.ptlike;

import rj7.bean.ptlike;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		ptlikeDAOProxy t = new ptlikeDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ptlike t2 = (ptlike)list1;
			System.out.println(t2.getPtid()+t2.getLikeid()+t2.getLikedid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
