package rj7.dao.ptcmt;

import rj7.bean.ptcmt;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		TSPingLDAOProxy t = new TSPingLDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ptcmt t2 = (ptcmt)list1;
			System.out.println(t2.getPtid()+t2.getCmtid()+t2.getCmtdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
