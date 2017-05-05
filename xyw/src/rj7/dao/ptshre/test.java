package rj7.dao.ptshre;

import rj7.bean.ptshre;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		ptshreDAOProxy t = new ptshreDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ptshre t2 = (ptshre)list1;
			System.out.println(t2.getPtid()+t2.getShreid()+t2.getShredid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
