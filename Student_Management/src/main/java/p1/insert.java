package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","3888");
			Statement st=con.createStatement();
			int roll=Integer.parseInt(request.getParameter("roll"));
			String name=request.getParameter("name");
			int m1=Integer.parseInt(request.getParameter("m1"));
			int m2=Integer.parseInt(request.getParameter("m2"));
			int m3=Integer.parseInt(request.getParameter("m3"));
			int m4=Integer.parseInt(request.getParameter("m4"));
			int m5=Integer.parseInt(request.getParameter("m5"));
			int m6=Integer.parseInt(request.getParameter("m6"));
			int i=st.executeUpdate("INSERT INTO `studentdata`.`data` (`stdid`, `stdname`, `m1`, `m2`, `m3`, `m4`, `m5`, `m6`) VALUES ('"+roll+"', '"+name+"', '"+m1+"', '"+m2+"', '"+m3+"', '"+m4+"', '"+m5+"', '"+m6+"')");
			if(i!=0)
				out.print("inserted succesfully");
			else
				out.print("not inserted");
			con.close();
		}
		catch(SQLException e)
		{
			out.print("not inserted");
		}
		catch (ClassNotFoundException e) {
			out.print(e);
		}
		
	}

}
