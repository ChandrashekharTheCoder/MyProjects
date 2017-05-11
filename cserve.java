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

/**
 * Servlet implementation class for Servlet: cserve
 *
 */
 public class cserve extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public cserve() {
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
		// TODO Auto-generated method stub
PrintWriter out=response.getWriter();
		
		
		Connection con=null;
		
		ResultSet rs=null;
         String sq=null;
         PreparedStatement st=null;
         String s1="shekhar";
         
         
         try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:db","dbadmin","dbadmin");
			st=con.prepareStatement("select available_space,squ_feet from cdetail where name=?");
		     st.setString(1, s1);
		    
			rs=st.executeQuery();
			while (rs.next())
	           {
			String t1=rs.getString(1);
			String t2=rs.getString(2);
			double d1=Double.parseDouble(t1);
			double d2=Double.parseDouble(t2);
           out.print("available space::"+d1+"<br>");
           out.print("per square feet::"+d2);
	           }
	}   
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}   	  	    
}