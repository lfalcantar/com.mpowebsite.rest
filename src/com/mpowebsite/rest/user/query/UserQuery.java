package com.mpowebsite.rest.user.query;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;

import java.sql.*;

import com.mpowebsite.rest.db.*;
import com.mpowebsite.rest.users.Administrator;
import com.mpowebsite.rest.users.AuthenticatedUser;
import com.mpowebsite.rest.users.MpoLead;
import com.mpowebsite.rest.users.User;
import com.mpowebsite.rest.util.Encode;
import com.mpowebsite.rest.util.ToJSON;

/**
 * This Class will manage all user querys by constructing the  and sending them to the
 * data base
 *@author Luis Alcantar 
 */

public class UserQuery { 
	/**
	 * This method will get the all the information from a user out of the user unique id. 
	 */
	public static Response getUser()throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response result = null;

		try {
			conn = DbConnection.mpoDbConnection().getConnection();

			query = conn.prepareStatement("Select * FROM SYSTEM_USERS");
			/*Execute query*/
			ResultSet resutlSet = query.executeQuery();
			
			/*Convert to Json */
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			/*Generate json array*/
			json = converter.toJSONArray(resutlSet);
			
			/*Close connection*/
			query.close();
			
			/*Transform it in response form*/
			returnString = json.toString();
			result = Response.ok(returnString).build();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn != null)
				conn.close();
		}

		return result;	
	}
	/**
	 * THis method will retuyrn a single user from the database
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Response getUser(String id)throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response result = null;

		try {
			conn = DbConnection.mpoDbConnection().getConnection();

			query = conn.prepareStatement("Select * FROM SYSTEM_USERS WHERE USER_ID = ?");
			
			/*Add parameters*/
			query.setString(1, id);
			
			/*Execute query*/
			ResultSet resutlSet = query.executeQuery();
			
			
			/*Convert to Json */
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			/*Generate json array*/
			json = converter.toJSONArray(resutlSet);
			
			/*Close connection*/
			query.close();
			
			/*Transform it in response form*/
			returnString = json.toString();
			result = Response.ok(returnString).build();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn != null)
				conn.close();
		}

		return result;	
	}
	
	/**
	 * This method is used to create a new user and installed in the database
	 * @param user
	 * @throws Exception
	 */
	public static void createUser(AuthenticatedUser user) throws Exception{
		PreparedStatement query = null;
		Connection conn = null;

		try {
			conn = DbConnection.mpoDbConnection().getConnection();
			query = insertUserQuery(conn,user);
			/*Execute query*/
			query.executeUpdate();
			
			/*Close connection*/
			query.close();
						
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			if(conn != null) conn.close();
		}	
	}
	
	/**
	 * This method is used to generate the query to insert a user
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	private static PreparedStatement insertUserQuery(Connection conn, AuthenticatedUser user) throws SQLException {
	   PreparedStatement query = null;
	   
	   query = conn.prepareStatement("INSERT INTO SYSTEM_USERS VALUES (? , ? , ? , ? , ? , ?, ?, ? , ?, ?, ?, ?)");
	   query.setString(1, user.getId());	  
	   query.setString(2, user.getEmail());
	   query.setString(3, user.getPassword());
	   query.setString(4, user.getFirstName());
	   query.setString(5, user.getMiddleName());
	   query.setString(6, user.getLastNAme());
	   query.setString(7, user.getOrganization());
	   query.setString(8, user.getDepartment());
	   query.setString(9, user.getPositionTitle());
	   query.setString(10, user.getDepartmentContactInformation());
	   query.setString(11, user.getType().toString());
	   query.setString(12, user.getPermissions()+"");
	  		
	   return query;
	}


	/**
	 * This method will verify that the User id will be unique
	 */
	public static boolean  uniqueId(String id)throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		boolean guard = false;

		try {
			conn = DbConnection.mpoDbConnection().getConnection();
			query = conn.prepareStatement("Select USER_ID FROM SYSTEM_USERS WHERE USER_ID = ? ");
			
			/*Add the values to the query*/
			query.setString(1,  id);
			
			/*Execute query*/
			ResultSet resutlSet = query.executeQuery();
			
			/*if the result set is empty there no similar id*/
			if(!resutlSet.next()){
				guard =  true;
			}
			
			/*Close connection*/
			query.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("USERQUERY-UNIQUEID-DEBUGG");
		}finally {
			if(conn != null) conn.close();
		}
		
		return guard;
	}

	/**
	 * This method is used to delete a user based on the 
	 * unique id
	 * @param id
	 * @throws SQLException
	 */
	public static String deleteUser(String id) throws SQLException {
		PreparedStatement query = null;
		Connection conn = null;

		try {
			conn = DbConnection.mpoDbConnection().getConnection();
			query = conn.prepareStatement("DELETE FROM  USER_ID  WHERE USER_ID = ? ");
			
			/*Add the values to the query*/
			query.setString(1,  id);
			
			/*Execute query*/
			query.executeUpdate();
			
			/*Close connection*/
			query.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) conn.close();
		}
		return "";
	}
	
	public static String logIn(String user, String password) throws Exception{
		PreparedStatement query = null;
		Connection conn = null;
		String result = "INCORRECT USERNAME OR PASSWORD";

		try {
			conn = DbConnection.mpoDbConnection().getConnection();

			query = conn.prepareStatement("Select * FROM SYSTEM_USERS WHERE USER_Email = ? AND USER_Password = ?");
			query.setString(1, user);
			query.setString(2, Encode.encode(password));
			
			/*Execute query*/
			ResultSet resutlSet = query.executeQuery();
		
			if(resutlSet.next())
				result = "success";
			
			/*Close connection*/
			query.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn != null){
				conn.close();
			}
			
		}
		System.out.println("DEBUGG"+result);
		return result;	
	}
	
}
