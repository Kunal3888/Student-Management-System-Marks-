package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class result2
 */
public class result2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public result2() {
        super();
        // TODO Auto-generated constructor stub
    }
    char grade(int marks)
    {
    	if(marks>90)
    		return 'A';
    	else if(marks>80)
    		return 'B';
    	else if(marks>80)
    		return 'C';
    	else if(marks>70)
    		return 'D';
    	else
    		return 'F';
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int roll=Integer.parseInt(request.getParameter("roll"));
		PrintWriter out=response.getWriter();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","3888");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM studentdata.data");
			
			while(rs.next()==true)
			{
				if(roll==rs.getInt("stdid"))
				{
				int m1=rs.getInt("m1");
				int m2=rs.getInt("m2");
				int m3=rs.getInt("m3");
				int m4=rs.getInt("m4");
				int m5=rs.getInt("m5");
				int m6=rs.getInt("m6");
				out.print("roll "+roll+"m1: "+grade(m1)+" m2: "+grade(m2)+" m3: "+grade(m3)+" m4: "+grade(m1)+" m5: "+grade(m5)+" m6: "+grade(m6));
				out.println(" overall: " +grade((m1+m2+m3+m4+m5+m6)/6));
				
				}
			}
			con.close();
		}
		catch(SQLException e)
		{
			out.print(e);
		}
		catch (ClassNotFoundException e) {
			out.print(e);
		}
	}

}
