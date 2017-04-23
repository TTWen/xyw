package rj7.dao.tuisong;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import rj7.bean.Tuisong;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Tuisong ts = new Tuisong();
		ts.setAdmid("7");
		ts.setDianzancnt("0");
		ts.setBrowsecnt("0");;
		ts.setPingluncnt("0");
		ts.setTcontent("hahaha");
		ts.setThead("yoyoyo");
		ts.setTid(null);			//设置为null后，从上一个id开始+1
		ts.setTstatus("1");
		ts.setTtype("公告");
		ts.setTcontent("aiyouwei");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
	    ts.setTtime(time);
	    TuisongDAOproxy t = new TuisongDAOproxy();
	    if(t.doCreate(ts)){
	    	System.out.println("====================addok");
	    }
	    
	    
	    /*ts.setTtype("新闻");
	    if(t.doUpdate(ts)){
	    	System.out.println("====================updateok");
	    }*/
	   /*if(t.doDelete(ts.getTid())){
	    	System.out.println("====================deleteok");
	    }*/
	    return;
	}

	
}
