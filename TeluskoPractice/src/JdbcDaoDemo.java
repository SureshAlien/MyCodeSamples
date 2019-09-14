import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class JdbcDaoDemo 
{

	public static void main(String[] args)
	{
		StudentDao dao = new StudentDao(); 
		dao.connect();
		Student s1= dao.getStudent(2); //get student code
		System.out.println(s1.sname);
		//Student s2=new Student();//add student code
		//s2.rollno = 5;
		//s2.sname = "Amuthaa";
		//dao.connect();
		//dao.addStudent(s2);
	}

}
class StudentDao
{
	Connection con=null;
	public void connect()
	{
		String url="jdbc:mysql://localhost:3306/telusko?useSSL=false";
		String uname="root";
		String pass="1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			System.out.println("Connected");

		} catch (Exception e) {
			System.out.println(" Not Connected");
			System.out.println(e);
		}
	}
	public Student getStudent(int rollno)
	{
		System.out.println("Enters Get STudent");
		try {
			
			Student s=new Student();
			s.rollno=rollno;
			System.out.println(s.rollno);

			
			String query = "select name from students where rollno="+rollno;
			System.out.println("Query passed");
			try {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);

				System.out.println(rs);

				rs.next();
				String name= rs.getString(1);
				System.out.println(name);

				s.sname=name;

			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("Query passed");

			
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	public void addStudent(Student s) 
	{
		String query = "insert into students values('Amutha',6)";
		PreparedStatement pst;
		try{
			 pst = con.prepareStatement(query);
			 //pst.setString(1,s.sname);
			// pst.setInt(2,s.rollno);
			 pst.executeUpdate();
		}catch (Exception e) {
			
			System.out.println(e);
		}
	}
}

class Student
{
	int rollno;
	String sname;
	
}