package rj7.dao.tuisong;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import rj7.bean.Tuisong;

public class test {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*Tuisong ts = new Tuisong();
		ts.setAdmid("8");
		ts.setDianzancnt("0");
		ts.setBrowsecnt("0");;
		ts.setPingluncnt("0");
		ts.setContent("hahaha");
		ts.setHead("yoyoyo");
		ts.setTid(null);			//设置为null后，从上一个id开始+1
		ts.setStatus("1");
		ts.setType("公告");
		ts.setContent("aiyouwei");
		
	    TuisongDAOProxy t = new TuisongDAOProxy();
	    if(t.doCreate(ts)){
	    	System.out.println("====================addok");
	    }*/
	    
	    /*ts.setTtype("新闻");
	    if(t.doUpdate(ts)){
	    	System.out.println("====================updateok");
	    }*/
	   /*if(t.doDelete(ts.getTid())){
	    	System.out.println("====================deleteok");
	    }*/
		
		
		TuisongDAOProxy t = new TuisongDAOProxy();
		List list0 = t.findBytype("公告");
		List list1 = t.findAll();
		List list2 = t.findByhot();
		Object list3 = t.findByid("9");
		
		System.out.println("按类型查找:");
		for(Object t1:list0){
			Tuisong t2 = (Tuisong)t1;
			System.out.println(t2.getTid()+t2.getAdmid()+t2.getHead());
		}
			

		System.out.println("全部查找:");
		for(Object t1:list1){
			Tuisong t2 = (Tuisong)t1;
			System.out.println(t2.getTid()+t2.getAdmid()+t2.getHead());
			
		}
			
		
		System.out.println("按热度查找:");
		for(Object t1:list2){
			Tuisong t2 = (Tuisong)t1;
			System.out.println(t2.getTid()+t2.getAdmid()+t2.getHead());
		}
		
		System.out.println("按id查找:");
		if(list3!=null){
			Tuisong t2 = (Tuisong)list3;
			System.out.println(t2.getTid()+t2.getAdmid()+t2.getHead());
		}
		else{
			System.out.println("不存在！");
		}
		
		return;
	}
	
}
