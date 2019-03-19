package Com.assignments;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner Sc= new Scanner(System.in);

while(true) {
System.out.println("1:Display all");
System.out.println("2:Add new Book");
System.out.println("3: Exit");
System.out.println("Enter the choice:");
int x=Sc.nextInt();
switch(x){
case 1:
	Display();
	break;
case 2:
	Inserting();
	break;
case 3:
	System.exit(0);
}}

	}

	private static void Inserting() {
		// TODO Auto-generated method stub
		try {
			Connection con= createConnection();
			Statement stmt= con.createStatement();
			boolean flag=false;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the id of book");
			int x=sc.nextInt();
			System.out.println("Enter the name of book");
			String y=sc.next();
			System.out.println("Enter the place of book");
			String z=sc.next();
			String pattern="^[a-zA-Z]+$";
			String s="select * from books";
			String sqlExceute="select * from student where id=?";
			PreparedStatement pstmt=con.prepareStatement(sqlExceute);
			pstmt.setInt(1, x);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				flag =true;
				break;
			}
			if(flag) {
				System.out.println("please write the  book id again");
				stmt.close();
				}
			//inserting the values//
			else {
				
				if(y.matches(pattern)==true) {
					String sql="insert into books values('"+x+"','"+y+"','"+z+"')";
					int i= stmt.executeUpdate(sql);
					System.out.println("Values are inserted");
					stmt.close();
				}
				else {
				System.out.println("Invalid name **it should be in characters**");
				stmt.close();
				}
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	private static void Display() {
		// TODO Auto-generated method stub
		try {
			Connection con= createConnection();
			Statement stmt= con.createStatement();
			String sql="select * from books";
			ResultSet w = stmt.executeQuery(sql);
			while(w.next()) {
				System.out.println("id:"+" "+w.getInt(1)+" "+"Name:"+" "+w.getString(2)+" "+"Address:"+" "+w.getString(3));
				}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	public static Connection createConnection() {
		try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Honeykiliki47&");
		return con;
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
