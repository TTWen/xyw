package rj7.dao.pttsmt;

import rj7.bean.pttsmt;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		pttsmtDAOProxy t = new pttsmtDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			pttsmt t2 = (pttsmt)list1;
			System.out.println(t2.getPtid()+t2.getTsmtid()+t2.getTsmtdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
