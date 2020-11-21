package com.tutorial.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersTable {
	// uid=ron, pwd=ron123
	public static int registerUser(String uid,String pwd,  Connection conn) throws  SQLException
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement
            		("insert into login (userid,password) values ( ?,?)");
            stmt.setString(1, uid); // binding , 
            //first que mark is replaced with value of uid that is ron
            stmt.setString(2, pwd);
            //sec que mark is replaced with value of pwd that is ron123
            //insert into login (userid,password) values ( 'ron','ron123')
            
            int count= stmt.executeUpdate();
            System.out.println("records created :"+count);
            return count;
        }
        catch (SQLException e)
        {
        	throw e;
        }
        finally
        {
            try{
            	stmt.close();} catch(SQLException s){}
        }
    }

	
	//updateOrder("john","new_pasword")
	public static int  updatePwd(String uid,String pwd, Connection conn) throws  SQLException
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement("update login set password=? where userid=?");
            stmt.setString(1, pwd);
            stmt.setString(2, uid);
            int count= stmt.executeUpdate();
            System.out.println("records updated:"+count);
            return count;
        }
        catch (SQLException e)
        {
        	throw e;
        }
        finally
        {
            try{
            	stmt.close();} catch(SQLException s){}
        }
     
    }
	

	public static int deleteUser(String delUid,Connection conn) throws  SQLException
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement("delete from login where userid=?");
            stmt.setString(1, delUid);
            int rowsupdated=stmt.executeUpdate();
            System.out.println("records deleted:"+rowsupdated);
            return rowsupdated;
        }
        catch (SQLException e)
        {
        	throw e;
        }
        finally
        {
            try{
            	stmt.close();} catch(SQLException s){}
        }
     
    }
 

	public static boolean validateLogin(String userid,String pwd,Connection conn) throws SQLException 
    {
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try
        {
        	stmt = conn.prepareStatement
        			("select userid,password from login where userid =? and password=?");
        	stmt.setString(1, userid);
        	stmt.setString(2, pwd);
            resultSet = stmt.executeQuery();
            if(resultSet.next())
            	return true;
            else
            	return false;
            
            /*
            //userid, password
            //jane	abc
            //jane	andy1!
            
            while(resultSet.next()) // read/navigate row by row
            {
            	// read column by column in each row
            	String u=resultSet.getString("userid");
            	String p=resultSet.getString(2);
            	System.out.println(u);
            	System.out.println(p);
            }
            */
            
        }
        catch (SQLException e)
        {
        	System.out.println("Exception occired");
        	e.printStackTrace();
            throw e;
        }
        finally
        {
        	try{
        		resultSet.close(); } catch(SQLException s){}
            try{
            	stmt.close();} catch(SQLException s){}
            
        }
        
    }
	

	public static void main(String args[]) {
		Connection conn=null;
		try {
			conn = DatabaseConnection.getDBConnection();
			conn.setAutoCommit(false);

			//registerUser("a", "a", conn);
			//deleteUser("a", conn);
			boolean res=validateLogin("jane", "jane", conn);
			System.out.println(res);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		}finally {
			try {
				conn.close();
			}catch(Exception ee) {}
		}
		
	}
	
	
	
	/*
	 Connection conn =null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				// connection string
			    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/website","root","root"); 
		  return conn;
		}
		try {
			conn = DatabaseConnection.getDBConnection();
			conn.setAutoCommit(false);
			registerUser("newuser","newpwd",  conn) 
			conn.commit();
		} catch (Exception e) {
				conn.rollback();
		}finally {
				conn.close();
		}
		*/
}







