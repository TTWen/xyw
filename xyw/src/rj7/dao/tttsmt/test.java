package rj7.dao.tttsmt;

import rj7.bean.tttsmt;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		tttsmtDAOProxy t = new tttsmtDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			tttsmt t2 = (tttsmt)list1;
			System.out.println(t2.getTtid()+t2.getTsmtid()+t2.getTsmtdid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
