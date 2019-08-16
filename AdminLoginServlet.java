package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bean.Admin;
import com.service.Service;

/**
 * Servlet implementation class LoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//EmpService es = new EmpService();
		Service es=new Service();
		
		
		String action = request.getParameter("action");
		if(action.equals("login")){
		int adminid = Integer.parseInt(request.getParameter("adminid"));
		String adminpwd = request.getParameter("adminpwd");
		
		Admin l = new Admin(adminid, adminpwd);
		boolean flag = es.sValidate(adminid, adminpwd);
		if(action.equals("login")){
			HttpSession sn= request.getSession();
			sn.setAttribute("s1", adminid);
			RequestDispatcher rd= request.getRequestDispatcher("hello.jsp");
			rd.forward(request, response);
			
			
		}else {
			HttpSession sn= request.getSession(	);
		sn.setAttribute("s1", "invalid user");
		RequestDispatcher rd= request.getRequestDispatcher("hello.jsp");
		rd.forward(request, response);
		}
		}
//		if(action.equals("view")){
//			ArrayList<Login> al=es.sGetUsers();
//
//			HttpSession sn= request.getSession();
//			sn.setAttribute("s1", al);
//			RequestDispatcher rd= request.getRequestDispatcher("hello.jsp");
//			rd.forward(request, response);
//		}
	
	
//		if(action.equals("detail")) {
//			int pid = Integer.parseInt(request.getParameter("pid"));
//			Product p=es.sGetDetail(pid);
//			HttpSession sn= request.getSession();
//			sn.setAttribute("s1", p);
//			RequestDispatcher rd= request.getRequestDispatcher("NewFile.jsp");
//			rd.forward(request, response);
//			
//		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
