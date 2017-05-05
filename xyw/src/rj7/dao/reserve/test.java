package rj7.dao.reserve;

import rj7.bean.Reserve;
import rj7.util.DAOFactory;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

	public class test {

		public static void main(String[] args) throws Exception {
			String id="1";
			String idname="reserid";
//			Reserve res = (Reserve)DAOFactory.getDaoInstance().findById("tblreserve", id, Reserve.class, idname);
//			System.out.println(res.getReserid());
//			System.out.println(res.getReserbegtime());
//			Reserve yy = new Reserve();
//			yy.setReserid("3");
//			yy.setReserbegtime("1998-1-1");
//			yy.setYyuserid("1");
//			yy.setByyuserid("2");
//			yy.setResercity("zhengzhou");			
//		
//		    ReserDAOProxy r = new ReserDAOProxy();
//		    
//		    if(r.doCreate(yy)){
//		    	System.out.println("添加成功!");
//		    }
//		    
//		   yy.setResercity("zhoukou");
//		    if(r.doUpdate(yy)){
//		    	System.out.println("修改成功!");
//		    }
//		    
//		    if(r.doDelete(yy.getReserid())) {
//		    	System.out.println("删除成功!");
//		    }
			
		
			ReserDAOProxy rs = new ReserDAOProxy();		
			List  list1 = rs.findAll();
			List list2 = rs.findBycity("zhoukou");
			Object list3 = rs.findByid("1","tblreserve",idname);
           
			System.out.println("查找所有:");
			for(Object r1:list1){
				Reserve r2 = (Reserve)r1;
				System.out.println(r2.getReserid()+" "+r2.getResercity());
				
			}
				
			
			System.out.println("按用户id查找:");
			for(Object r1:list2){
				Reserve r2 = (Reserve)r1;
				System.out.println(r2.getReserid()+" "+r2.getResercity());
			}
			
			System.out.println("按id查找:");
			if(list3!=null){
				Reserve r2 = (Reserve)list3;
				System.out.println(r2.getReserid());
			}
			else{
				System.out.println("对不起，无记录！.");
			}
			return;
		}	
		
	}
		


			