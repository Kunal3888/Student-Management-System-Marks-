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
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				int roll=Integer.parseInt(request.getParameter("roll"));
				int marks=Integer.parseInt(request.getParameter("marks"));
				String subject=request.getParameter("subject");
				
				PrintWriter out=response.getWriter();
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","3888");
					Statement st=con.createStatement();
					int i=st.executeUpdate("UPDATE `studentdata`.`data` SET `"+subject+"` = '"+marks+"' WHERE (`stdid` = '"+roll+"')");
					if(i!=0)
						out.print("updated succesfully");
					else
						out.print("not updated");
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
