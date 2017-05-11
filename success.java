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
 * Servlet implementation class for Servlet: success
 *
 */
 public class success extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public success() {
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
		String s1=request.getParameter("t2");
		double d=Double.parseDouble(s1);
		//HttpSession ses=request.getSession(true);
		PrintWriter out=response.getWriter();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String s2="shekhar";
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:db","dbadmin","dbadmin");
			st=con.prepareStatement("select req_space,squ_feet from mdetail where name=?");
			st.setString(1,s2);
	rs=st.executeQuery();
	while (rs.next())
	{
       double s4=rs.getDouble(1);
       double s5=rs.getDouble(2);
       //double d1=Double.parseDouble(s4); 
       //double d2=Double.parseDouble(s5);
       double d3=s4*s5;
      // out.print(d3);
      // String s6=""+d3;
       if(d==d3)
       {
		//out.print("Transaction is Successfully Completed");
		response.sendRedirect("trans.jsp");
	}else
	{
		response.sendRedirect("error2.jsp");
	}
	 }}
	catch(Exception e)
	
	{
		//e.getStackTrace();
		out.print(e);
	}
	}
	
}