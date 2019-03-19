package Com.assignments;
import java.util.*;
import java.sql.*;
public class DBDemo {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("testing");
		System.out.println("1: For Inserting");
		System.out.println("2: For Updating");
		System.out.println("3: For Deleting");
		System.out.println("4: For Displaying");
		System.out.println("5: to exit");
		System.out.println("Enter Ur Choice");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			Inserting();
			break;
		case 2:
			Updating();
				break;
		case 3:
			Deleting();
			break;
		case 4:
			
			Displaying();
			break;
		case 5:
			System.exit(0);
			
		}
		}
				
	}
	                          //Deleting//
	private static void Deleting() {
		// TODO Auto-generated method stub
		try {
			Connection con= createConnection();
			Statement stmt= con.createStatement();
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the name that to be deleted from data");
			String d= sc.next();
			String sql="delete from student where name='"+d+"'";
			int i=stmt.executeUpdate(sql);
			System.out.println("Successfully Deleted");
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
                      //Displaying//
	
	private static void Displaying() {
		// TODO Auto-generated method stub
		
		try {
			Connection con= createConnection();
			Statement stmt= con.createStatement();
			String pt="select * from student";
			ResultSet q = stmt.executeQuery(pt);
			while(q.next()) {
				System.out.println("id:"+" "+q.getInt(1)+" "+"Name:"+" "+q.getString(2)+" "+"Address:"+" "+q.getString(3));
				}
	stmt.close();
	con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
							//Updating//
	
	private static void Updating() {
		// TODO Auto-generated method stub
		try {
		Connection con= createConnection();
		Statement stmt= con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter which name should be updated");
		String w=sc.next();
		System.out.println("Enter the rollno");
		int x= sc.nextInt();
		System.out.println("Enter the name");
		String y= sc.next();
		System.out.println("Enter the address");
		String z= sc.next();
		String upd="update student set id='"+x+"',name='"+y+"',place='"+z+"' where id='"+w+"'";
		int q=stmt.executeUpdate(upd);
		System.out.println("successfully updated");
		stmt.close();
		con.close();
	
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
							//Inserting//		
	private static void Inserting() {
		// TODO Auto-generated method stub

		
		try {
			Connection con= createConnection();
			Statement stmt= con.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the rollno");
			int x= sc.nextInt();
			System.out.println("Enter the name");
			String y= sc.next();
			System.out.println("Enter the address");
			String z= sc.next();
			boolean flag=false;
			String sqlExceute="select * from student where name=?";
			PreparedStatement pstmt=con.prepareStatement(sqlExceute);
			pstmt.setString(1,y);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				flag =true;
				break;
			}
			if(flag) {
				System.out.println("please select the another customer");
				stmt.close();
				
			}
			//inserting the values//
			else {
				String sql="insert into student values(?,?,?)";
				PreparedStatement psmt=con.prepareStatement(sql);
				psmt.setInt(1,x);
				psmt.setString(2,y);
				psmt.setString(3, z);
			int i=psmt.executeUpdate(sql);
			System.out.println("values successfully inserted");
			stmt.close();
			}
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
