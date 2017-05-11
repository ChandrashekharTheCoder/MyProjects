package ibm.space;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: upmumserv
 *
 */
 public class upmumserv extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public upmumserv() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		
		
	  
		PrintWriter out=response.getWriter();
		
		
		Connection con=null;
		PreparedStatement st=null;
		String s3="shekhar";
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:db","dbadmin","dbadmin");
			st=con.prepareStatement("update mdetail set available_space=?,squ_feet=? where name=?");
			st.setString(1,s1);
			st.setString(2,s2);
			st.setString(3, s3);
			st.executeUpdate();
			response.sendRedirect("congrates1.jsp");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}   	  	    
}