package ibm.space;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: fakeserv
 *
 */
 public class chbookserve extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public chbookserve() {
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
		HttpSession ses=request.getSession(true);
		PrintWriter out=response.getWriter();
		double d1=Double.parseDouble(s1);
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String s2="shekhar";
		double d3;
		double t1,t2;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:db","dbadmin","dbadmin");
			st=con.prepareStatement("select available_space,squ_feet from cdetail where name=?");
			st.setString(1,s2);
			rs=st.executeQuery();
			while (rs.next())
			{
	           t1=rs.getDouble(1);
	           t2=rs.getDouble(2);
	           double d2=d1*t2;
				double d4=t1-d1;
				
				st=con.prepareStatement("update cdetail set available_space=?,req_space=? where name=?");
				st.setDouble(1,d4);
				
				st.setString(2,s1);
				st.setString(3, s2);
				st.executeUpdate();
			
				
	        String s=""+d2;
			
			ses.setAttribute("value",s);
			response.sendRedirect("display1.jsp");
			}
		
			}
		catch(Exception e)
		
		{
			e.getStackTrace();
		}
	
	}   	  	    
}