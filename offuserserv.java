package ibm.space;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: offuserserv
 *
 */
 public class offuserserv extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public offuserserv() {
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
		Statement st=null;
		String sq=null;
		ResultSet rs=null;
		String s3=null,s4=null ;
		
		
		

	try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:db","dbadmin","dbadmin");
			st=con.createStatement();
          
			sq="select * from offuser where user_id='"+s1+"' and password='"+s2+"'";
			rs=st.executeQuery(sq);
			
			int flag=0;
			while(rs.next())
			{
				flag=1;
			}
			if(flag==1)
			{
				response.sendRedirect("update.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
	}  
		catch(Exception e){
			e.printStackTrace();
		}
	}   	  	    
}