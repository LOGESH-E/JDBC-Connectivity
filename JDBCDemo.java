package jdbc;
import java.sql.*;
import java.util.Scanner;
public class JDBCDemo 
{
	
	
	//main method
	public static void main(String[] args) throws Exception
	{
		deleteRecordbyPst();
	}
	
	
	//read records
	public static void readRecords() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		String query = "select * from employe;";
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{	
			System.out.println("Id is "+rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+rs.getInt(3));
		}
		
		
		
		con.close();
		
	}
	
	
	//insert records by hard code
	public static void insertRecords() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		String query = "insert into employe values(5, 'ramesh' ,350000)";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("Number of rows affected: "+rows);
		
		System.out.println(query);
		
		con.close();
		
	}
	
	
	//insert using variables
	// insert as variables
	public static void insertVariable() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		Scanner scan = new Scanner(System.in);
		
		int id=0;
		String name="";
		String jobTitle="";
		String phoneNumber="";
		String mailId="";
		int age=0;
		int salary=0;
		int num=1;
		int rows=0;
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		while(num==1)
		{
		
			System.out.println("Enter Employee ID :");
			id = scan.nextInt();
			
			scan.nextLine();
			System.out.println("Enter Employee Name :");
			name = scan.nextLine();
			
			
			System.out.println("Enter the the salary Amount :");
			salary = scan.nextInt();
			
			scan.nextLine();
			System.out.println("Enter job_Title :");
			jobTitle = scan.nextLine();
			
			
			System.out.println("Enter Phone Number :");
			phoneNumber = scan.nextLine();
			
			
			System.out.println("Enter Mail ID :");
			mailId = scan.nextLine();
			
			
			System.out.println("Enter Age");
			age = scan.nextInt();
			
			String query = "insert into employe values("+id+",'"+name+"',"+salary+",'"+jobTitle+"','"+phoneNumber+"','"+mailId+"',"+age+");";
			
			if(st.executeUpdate(query)==1)
			{
				rows++;
			}
			System.out.println("Enter 1 to insert values or 2 to finish");
			num = scan.nextInt();
			
		}
		
		
				
		System.out.println("Number of rows Inserted: "+rows);
		con.close();
		scan.close();
	}
	
	
	//insert using prepared statement
	//insert with prepared statement
	public static void insertUsingPst() throws Exception
	{
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		Connection con = DriverManager.getConnection(url,userName,password);
		
		String jobTitle="";
		String phoneNumber="";
		String mailId="";
		int age=0;
		int rows=0;
		
		System.out.println("Enter 1 to Insert or 2 to Exit :");
		int num = scan.nextInt();
		
		while(num==1)
		{
		
			System.out.println("Enter Employee ID :");
			int id = scan.nextInt();
			
			scan.nextLine();
			System.out.println("Enter Employe Name :");
			String name = scan.nextLine();
			
			System.out.println("Enter Salary Amount :");
			int salary = scan.nextInt();
			
			scan.nextLine();
			System.out.println("Enter job_Title :");
			jobTitle = scan.nextLine();
			
			
			System.out.println("Enter Phone Number :");
			phoneNumber = scan.nextLine();
			
			
			System.out.println("Enter Mail ID :");
			mailId = scan.nextLine();
			
			
			System.out.println("Enter Age");
			age = scan.nextInt();
			
			String query = "insert into employe values(?,?,?,?,?,?,?);";
		
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,id);
			pst.setString(2, name);
			pst.setInt(3,salary);
			pst.setString(4,jobTitle);
			pst.setString(5,phoneNumber);
			pst.setString(6,mailId);
			pst.setInt(7, age);
			
			if(pst.executeUpdate()==1)
			{
				rows++;
			}
			System.out.println("Enter 1 to Insert or 2 to Exit :");
			num=scan.nextInt();
			
		}
		System.out.println("Number of rows Inserted: "+rows);
		con.close();
		scan.close();
		
	}
	
	
	//delete
	public static void deleteRecord() throws Exception
	{
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		
		
		System.out.println("number of rows you want to delete :");
		int size = scan.nextInt();
		
		int arr[] = new int[size];
		
		int rows=0;
		int i;
		System.out.println("Enter the Employee Ids you want to delete :");
		for(i=0; i<size; i++)
		{
			arr[i]=scan.nextInt();
		}
		
		
		for(int ids:arr)
		{
			int id = ids;
			String query = "delete from employe where emp_id = "+id+";";
			if(st.executeUpdate(query)==1)
			{
				rows++;
			}
		}
		
		System.out.println("Number of rows affected: "+rows);
		con.close();
		scan.close();
		

	}
	
	
	// delete by prepared statement
	public static void deleteRecordbyPst() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		Connection con = DriverManager.getConnection(url,userName,password);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Number of Reords want to delete :");
		int size = scan.nextInt();
		int arr[] = new int[size];
		
		int i,rows=0;
		System.out.println("Id No of Records:");
		for(i=0; i<size; i++)
		{
			arr[i]=scan.nextInt();
		}
		
		for(int ids:arr)
		{
			int id = ids;
			String query = "delete from employe where emp_id = (?);";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,id);
			if(pst.executeUpdate()==1)
			{
				rows++;
			}
		}
					
		System.out.println("Number of rows deleted: "+rows);
		con.close();
		
	}
	
	
	//update
	public static void update() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		String query = "update employe set salary = 150000 where emp_id=1";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("Number of rows affected: "+rows);
		
		con.close();
		
	}
	
	
	// Types of statement
	
	// Normal statement (createStatement();)
	//prepared Statement
	//call able Statement
	
	
	//calling simple stored procedure
	public static void stordProcedure() throws Exception
	{
		String url ="jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		
		CallableStatement cst = con.prepareCall("{call GetEmp()}");
		ResultSet rs = cst.executeQuery();
		
		while(rs.next())
		{	
			System.out.println("Id is "+rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+rs.getInt(3));
		}
		
		
		con.close();
	}
	
	
	//calling stored procedure with input parameter parameter
	public static void spWithInputParameter() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		int id = 3;
		
		Connection con = DriverManager.getConnection(url,userName,password);
		String query="{call GetEmpById(?)}";
		CallableStatement cst = con.prepareCall(query);
		cst.setInt(1, id);
		ResultSet rs = cst.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Id is "+ rs.getInt(1));
			System.out.println("Name is + rs "+ rs.getString(2));
			System.out.println("Salary is "+ rs.getInt(3));
		}
		
		
	}

	
	//calling stored procedure with input and output procedure
	public static void spWithInandOutParameter() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		int id = 3;
		Connection con = DriverManager.getConnection(url,userName,password);
		String query = "{GetNameById(?,?);}";
		CallableStatement cst = con.prepareCall(query);
		cst.setInt(1,id);
		cst.registerOutParameter(2,Types.VARCHAR);
		cst.executeUpdate();
		
		System.out.println(cst.getString(2));
		
		con.close();
	}
	
	
	//commit vs Auto commit
	public static void autoCommit() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		String query1 = "update employe set salary = 600000 where emp_id=1";
		String query2 = "update employe set salary = 650000 where emp_id=2";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement st = con.createStatement();
		
		int rows1 = st.executeUpdate(query1);
		int rows2 = st.executeUpdate(query2);
		
		System.out.println("Rows affected "+rows1);
		System.out.println("Rows affected "+rows2);
		
		con.close();
	}


	public static void manualCommit() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		String query1 = "update employe set salary = 600000 where emp_id=1";
		String query2 = "update employe set salary = 650000 where emp_id=2";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		
		int rows1 = st.executeUpdate(query1);
		int rows2 = st.executeUpdate(query2);
		
		System.out.println("Rows affected "+rows1);
		System.out.println("Rows affected "+rows2);
		
		if(rows1>0 && rows2>0)
			con.commit();
		
		con.close();
	}

	
	//batch processing
	public static void batchDemo() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		String query1 = "update employe set salary = 300000 where emp_id=1";
		String query2 = "update employe set salary = 300000 where emp_id=2";
		String query3 = "update employe set salary = 300000 where emp_id=3";
		String query4 = "update employe set salary = 300000 where emp_id=4";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		
		st.addBatch(query1);
		st.addBatch(query2);
		st.addBatch(query3);
		st.addBatch(query4);
		
		int res[] = st.executeBatch();
		for(int i: res)
		{
			if(i>0)
				continue;
			else
				con.rollback();
		}
		con.commit();
		con.close();
	}

	
	//Alter process (add columns)
	public static void alterTable() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		String userName = "root";
		String password = "Logesh@4055";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		
		
		String query = "ALTER TABLE employe "
		        + "ADD COLUMN Job_Title VARCHAR(100), "
		        + "ADD COLUMN PhoneNumber VARCHAR(15), "
		        + "ADD COLUMN email VARCHAR(50), "
		        + "ADD COLUMN Age INT";
		
		Statement pst = con.createStatement();
		int cols = pst.executeUpdate(query);
		
		System.out.println(cols);
	}
}





