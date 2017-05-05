package rj7.dao.evaluate;

import rj7.util.DAOFactory;
import rj7.bean.Evaluate;
import rj7.util.DAOFactory;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

	public class test {

		public static void main(String[] args) throws Exception {
			String id="2";
			String idname="evaid";
			Evaluate eva = (Evaluate)DAOFactory.getDaoInstance().findById("tblevaluate", id, Evaluate.class, idname);
			System.out.println(eva.getEvaid());
			Evaluate e = new Evaluate();
			e.setEvaid("6");
			e.setPjuserid("1");
			e.setBpjuserid("2");
			e.setEvastar("4");
			e.setEvacont("hahaha");
			
		    EvaDAOProxy r = new EvaDAOProxy();
		    
		    if(r.doCreate(e)){
		    	System.out.println(e.getEvatime());
	    	System.out.println("ADD SUCESSFULLY!");
		    }
//		    
//		    e.setEvaid("3");
//		    if(r.doUpdate(e)){
//		    	System.out.println("UPDATE SUCCESSFULLY!");
//		    }
		    
//		    if(r.doDelete(e.getReserid())) {
//		    	System.out.println("DELETE SUCCESSFULLY!");
//		    }
			
		
			EvaDAOProxy ev = new EvaDAOProxy();
			
			List  list1 = ev.findAll();
			List list2 = ev.findBystar("4");
			Object list3 = ev.findByid("1","tblEvaluate",idname);
			
			System.out.println("查找所有:");
			for(Object r1:list1){
				Evaluate r2 = (Evaluate)r1;
				System.out.println(r2.getEvaid()+" "+r2.getEvatime()+" "+r2.getEvastar());
				
			}
				
			
//			System.out.println("按评价星级数查找:");
//			for(Object r1:list2){
//				Evaluate r2 = (Evaluate)r1;
//				System.out.println(r2.getEvaid()+" "+r2.getEvatime()+" "+r2.getEvastar());
//			}
//			
//			System.out.println("按id查找:");
//			if(list3!=null){
//				Evaluate r2 = (Evaluate)list3;
//				System.out.println(r2.getEvaid()+" "+r2.getEvatime()+" "+r2.getEvastar());}
//			else{
//				System.out.println("对不起，无记录！");
//			}
			return;
		}	
		
	}
		

