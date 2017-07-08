/**
 * 
 */
package rj7.dao.push;

import java.util.Comparator;

import rj7.bean.Push;

/**
 * @author lawonder
 * 2017/5/20
 *
 */
//推送比较器,按照不同权重排序
public class PushCmp implements Comparator<Object> {
	public int compare(Object obj1, Object obj2) {
		Push p1 = (Push)obj1;
		Push p2 = (Push)obj2;
		int flag;
		int i = 0;
		int j = 0;
		int browsecnt1 = Integer.parseInt(p1.getBrowsecnt());
		int cltcnt1 = Integer.parseInt(p1.getCltcnt());
		int cmtcnt1 = Integer.parseInt(p1.getCmtcnt());
		int likecnt1 = Integer.parseInt(p1.getLikecnt());
		int shrecnt1 = Integer.parseInt(p1.getShrecnt());
		int tsmtcnt1 = Integer.parseInt(p1.getTsmtcnt());
		i = (int) (browsecnt1*0.1+cltcnt1*0.2+cmtcnt1*0.3+likecnt1*0.4+shrecnt1*0.5+tsmtcnt1*0.6);
		int browsecnt2 = Integer.parseInt(p2.getBrowsecnt());
		int cltcnt2 = Integer.parseInt(p2.getCltcnt());
		int cmtcnt2 = Integer.parseInt(p2.getCmtcnt());
		int likecnt2 = Integer.parseInt(p2.getLikecnt());
		int shrecnt2 = Integer.parseInt(p2.getShrecnt());
		int tsmtcnt2 = Integer.parseInt(p2.getTsmtcnt());
		j = (int) (browsecnt2*0.1+cltcnt2*0.2+cmtcnt2*0.3+likecnt2*0.4+shrecnt2*0.5+tsmtcnt2*0.6);
		if(i<j){
			flag = -1;
		} else if(i==j){
			flag = 0;
		} else {
			flag = 1;
		}
		return flag;
	}

}
