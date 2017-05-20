package rj7.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rj7.bean.Member;
import rj7.dao.member.IMemberDAO;
import rj7.util.DAO;
import rj7.util.DAOFactory;

/**
 * 会员信息修改servlet
 * @author 梁爽爽  2017.5.18
 */
@WebServlet("/MemInfoServ")
public class MemInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemInfoServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dowhat = request.getParameter("dowhat");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		// 获取DAO实例
		IMemberDAO memdao = DAOFactory.getIMemberDAOInstance();
		
		if("modifybaseinfo".equals(dowhat)) {
			// 获取用户输入的修改信息
			String birth = request.getParameter("birth");
			String sex = request.getParameter("sex");
			String pvc = request.getParameter("user.province");
			String city = request.getParameter("user.city");
			String area = request.getParameter("user.area");
			
			// 转码
			pvc = new String(pvc.getBytes("iso8859-1"),"utf-8");
			city = new String(city.getBytes("iso8859-1"),"utf-8");
			area = new String(area.getBytes("iso8859-1"),"utf-8");
			
			// 构造member对象
			Member mem = new Member();
			// 获取当前用户id
//			session.getAttribute("crtid");
			String crtid = "1";
			mem.setId(crtid);
			mem.setBirth(birth);
			mem.setSex(sex);
			mem.setCity(pvc + city + area);
			String year = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date = null;
			try {
				date = sdf.parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			// 获取年份，计算年龄
			Calendar c = Calendar.getInstance();
			Calendar cnow = Calendar.getInstance();
			c.setTime(date);
			cnow.setTime(new Date());
			mem.setAge(cnow.get(Calendar.YEAR) - c.get(Calendar.YEAR) + "");
			
			// 修改信息
			memdao.modifyInfo(mem);
		}
	}
}
