package ibm.space;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 public class welcomeserve extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   
	public welcomeserve() {
		super();
	}   	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		String s3=request.getParameter("t3");
		String s4=request.getParameter("t4");
		String s5=request.getParameter("t5");
	    PrintWriter out=response.getWriter();
	    Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try
	   {
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   con=DriverManager.getConnection("jdbc:odbc:db","dbadmin","dbadmin");
		  
		   st=con.prepareStatement("insert into login (fname,lname,phone_no,log_name,password) values(?,?,?,?,?)");
			st.setString(1,s1);
			st.setString(2,s2);
			st.setString(3,s3);
			st.setString(4,s4);
			st.setString(5,s5);
			st.executeUpdate();	
			
				response.sendRedirect("congrates.jsp");	
			
			
		}
	   catch(Exception e)
	   {
		   out.print(e);
	   }  
		
			
	}
}