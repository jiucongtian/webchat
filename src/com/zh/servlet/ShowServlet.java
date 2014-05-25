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

		//��½�ɹ���־

        String LOGIN_FLAG="";
 
        //��ÿͻ����ύ�û�������
 
        String username = request.getParameter("username");

        String password = request.getParameter("password");

		//����UserDAO��isLogin�����ж��������û��������Ƿ���ȷ

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
		        output.writeUTF("������������:"+LOGIN_FLAG);
		        System.out.println(LOGIN_FLAG);
		        output.writeInt(1);
		          output.close();
		    }else{
		         //��¼ʧ�� 
		        LOGIN_FLAG="failure";
		        System.out.println(LOGIN_FLAG);
		        output.writeUTF("������������:"+LOGIN_FLAG);
		        output.close();
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}   	  	    
}