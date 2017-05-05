package rj7.dao.ttclt;

import rj7.bean.ttclt;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		ttcltDAOProxy t = new ttcltDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ttclt t2 = (ttclt)list1;
			System.out.println(t2.getTtid()+t2.getCltid()+t2.getCltdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
