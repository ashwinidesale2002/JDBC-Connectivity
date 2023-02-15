// create JDBC project using Maven for library management system showing JDBC connectivity.it should have add,update,delete and show facility.

package com.firstjdbc.studentjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
    	public static void Insertion()  //insertion method
    	{
    		System.out.println("Insert the data you want!!");
    	
    	try
    	{
    		//   System.out.println("Hello World");	
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root"); //connection mysql database
    		if(con.isClosed())
    		{
    			System.out.println("The connection is close");
    		}
    		else
    		{
    			System.out.println("The connection is establised");	//check to connection is establised or not
    		}
    		 String q="Insert into librarybooks(rollno,name,bookname,mobile_no,branch) values(?,?,?,?,?)"; //the insert table name librarybooks
			PreparedStatement pstmt=con.prepareStatement(q);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the rollno: ");
			int rollno=sc.nextInt();
			System.out.println("Enter the student Name: ");
			String name=sc.next();
			System.out.println("Enter the Book Name: ");
			String bookname=sc.next();
			System.out.println("Enter the mobile Number: ");
			int mobile_no=sc.nextInt();
			System.out.println("Enter the Branch: ");
			String branch=sc.next();
			
			//insert the value
			pstmt.setInt(1, rollno); 
			pstmt.setString(2,name);
			pstmt.setString(3, bookname);
			pstmt.setInt(4, mobile_no);
			pstmt.setString(5, branch);
			//EXECUTE THE QUERY
			pstmt.executeUpdate();
			System.out.println("Congratulation !!!");
			System.out.println("Your data insert successfully !!!");
			
			//CLOSE THE CONNECTION
			con.close();
		
    
    } 
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
}
	public static void Updation()	//updation method
	{
		System.out.println("Update the data you want!!");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			if(con.isClosed())
			{
				System.out.println("The connection is close");
			}
			else
			{
				System.out.println("The connection is established");
			}
			String q="update librarybooks set bookname=? ,  where rollno=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
		//INSERT RECORD USING SCANNER
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the rollno: ");
			int prn_no=sc.nextInt();
			System.out.println("Enter the BookName: ");
			String bookname=sc.next();
			
			
			pstmt.setString(1, bookname);
			
			pstmt.setInt(3, prn_no);
			
			
			//EXECUTE THE QUERY
			pstmt.executeUpdate();
			System.out.println("Congratulation !!!");
			System.out.println("Your data updated successfully !!!");
			
			//CLOSE THE CONNECTION
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void Deletion()		//deletion method
	{
		System.out.println("Delete the data you want!!");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			if(con.isClosed())
			{
				System.out.println("The connection is close");
			}
			else
			{
				System.out.println("The connection is established");
			}
			String q="Delete from librarybooks where rollno=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
		//INSERT RECORD USING SCANNER
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the rollno: ");
			int rollno=sc.nextInt();
			
			
			pstmt.setInt(1, rollno);
			
			
			//EXECUTE THE QUERY
			pstmt.executeUpdate();
			
			System.out.println("Your data deleted successfully !!!");
			
			//CLOSE THE CONNECTION
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void Display()	//display method
	{
		System.out.println("Display the data!!");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			if(con.isClosed())
			{
				System.out.println("The connection is close");
			}
			else
			{
				System.out.println("The connection is established");
			}
			
			//DISPLAY ALL THE RECORD
			String q="Select rollno,name,bookname,mobile_no,branch from librarybooks";
			PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet rset=pstmt.executeQuery();
    		
    		while(rset.next())
    		{
    			int rollno=rset.getInt(1);
    			String name=rset.getString(2);
    			String bookname=rset.getString(3);
    			int mobile_no=rset.getInt(4);
    			int branch=rset.getInt(5);
    			System.out.println("rollno: "+rollno+" "+"student Name: "+name+" "+"Book Name: "+bookname+" "+"mobile_No: "+mobile_no+"branch: "+branch);
    		}
		
			//CLOSE THE CONNECTION
			con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	 public static void main( String[] args )
	    {
	      //  System.out.println( "Hello World!" );
	    	
	    	{
	    	
	    	   Scanner sc= new Scanner(System.in);
	    	   System.out.println("Choose which operation do you want perform : ");
	    	   System.out.println("1 : Insertion, 2 : Updation, 3 : Deletion, 4 : Display");
	    	   int a=sc.nextInt();
	    	   
	    	//using swich case   
	    	   switch(a)
	    	   {
	    	   case 1: Insertion();			//choose to insertion method
	    	   break;
	    	   
	    	   case 2: Updation();			//choose to updation method
	    	   break;
	    	   
	    	   case 3: Deletion();			//choose to deletion method
	    	   break;
	    	   
	    	   case 4: Display();			//display method
	    	   break;
	    	   }
	    	 }
	    	
	    
	    	
	    }
		

}
    	












