import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class PracticeJdbc 
{
	public static void main(String[] args) throws Exception
	{
		//jdbc:mysql://localhost:3306/INTtech
		String url="jdbc:mysql://localhost:3306/telusko?useSSL=false";
		String uname="root";
		String pass="1234";
		String query = "select name from students where rollno=2";

		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();  
		String namee = rs.getString("name");
		System.out.println(namee );
	}

}
