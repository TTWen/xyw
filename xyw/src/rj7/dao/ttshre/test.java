package rj7.dao.ttshre;

import rj7.bean.ttshre;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		ttshreDAOProxy t = new ttshreDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ttshre t2 = (ttshre)list1;
			System.out.println(t2.getTtid()+t2.getShreid()+t2.getShredid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
