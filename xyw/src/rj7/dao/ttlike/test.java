 package rj7.dao.ttlike;

 import rj7.bean.ttlike;


public class test {


	public static void main(String[] args) throws Exception {
	
		
		ttlikeDAOProxy t = new ttlikeDAOProxy();
		Object list1 = t.findByid("9");

		System.out.println("按id查找:");
		if(list1!=null){
			ttlike t2 = (ttlike)list1;
			System.out.println(t2.getTtid()+t2.getLikeid()+t2.getLikedid());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
