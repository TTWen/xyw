package rj7.dao.ptclt;

import rj7.bean.ptclt;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		ptcltDAOProxy t = new ptcltDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ptclt t2 = (ptclt)list1;
			System.out.println(t2.getPtid()+t2.getCltid()+t2.getCltdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
