package com.zh.servlet;

import java.io.DataOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: ShowServlet
 *
 */
 public class ShowServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ShowServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //response.getWriter().println("hello world from servlet!");
	    
	    //doPost(request,response);
	    response.getWriter().println("after doPost");
	    
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//登陆成功标志

        String LOGIN_FLAG="";
 
        //获得客户端提交用户名密码
 
        String username = request.getParameter("username");

        String password = request.getParameter("password");

		//调用UserDAO中isLogin方法判断数据中用户名密码是否正确

        boolean flag;//=true;//UserDAO.isLogin(username, password);

        
        if(username == "zhenghao" && password == "123123") {
        	flag = true;
        } else {
        	flag = false;
        }
        
        
        
        try {

		    DataOutputStream output=new DataOutputStream(response.getOutputStream());
		    if (flag) {
		        LOGIN_FLAG="success";
		        output.writeUTF("服务器端数据:"+LOGIN_FLAG);
		        System.out.println(LOGIN_FLAG);
		        output.writeInt(1);
		          output.close();
		    }else{
		         //登录失败 
		        LOGIN_FLAG="failure";
		        System.out.println(LOGIN_FLAG);
		        output.writeUTF("服务器端数据:"+LOGIN_FLAG);
		        output.close();
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}   	  	    
}