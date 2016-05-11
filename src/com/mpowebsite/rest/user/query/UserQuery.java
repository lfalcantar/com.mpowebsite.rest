package com.mpowebsite.rest.user.query;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;

import java.sql.*;

import com.mpowebsite.rest.db.*;
import com.mpowebsite.rest.users.Administrator;
import com.mpowebsite.rest.users.AuthenticatedUser;
import com.mpowebsite.rest.users.User;
import com.mpowebsite.rest.util.ToJSON;

/**
 * This Class will manage all user querys by constructing the  and sending them to the
 * data base
 *@author Luis Alcantar 
 */

public class UserQuery { 
	//CHANGE: This method need to be fix.
	public static String  addAdministrator(Administrator admin)throws Exception {
		PreparedStatement query = null;
		String result = " ";
		Connection conn = null;
		
		try {
			conn = DbConnection.MpoDbConnection().getConnection();
			query = conn.prepareStatement("Select * FROM SYSTEM_USERS");
			ResultSet rs = query.executeQuery();
			// CHANGE: Add functional 
			
			while(rs.next()){
				result += rs.getString("USER_FirstName");
			}
			
			query.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn != null)
				conn.close();
		}
		System.out.println(result);
		return result;	
	}
	
	
	/**
	 * This method will get the all the information from a user out of the user unique id. 
	 */
	public static Response  getUser()throws Exception {
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response result = null;

		try {
			conn = DbConnection.MpoDbConnection().getConnection();
			query = conn.prepareStatement("Select * FROM SYSTEM_USERS");
			/*Execute query*/
			ResultSet resutlSet = query.executeQuery();
			
			/*Convert to Json rs*/
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
	 * 
	 * @param user
	 * @return
	 * @author LEE
	 */
	public static String createQuery(AuthenticatedUser user){
		String query = new String();
		query = "";
		return query;
		
	}
	
}
