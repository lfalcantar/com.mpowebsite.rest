package com.mpowebsite.rest.user.query;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;

import com.mpowebsite.rest.db.*;
import com.mpowebsite.rest.users.Administrator;
import com.mpowebsite.rest.users.AuthenticatedUser;
import com.mpowebsite.rest.users.User;

public class UserQuery {

	public static  Administrator addAdministrator(Administrator admin)throws Exception {
		PreparedStatement query = null;
		String mystring = null;
		String result = null;
		Connection conn = null;
		
		try {
			conn = DbConnection.MpoDbConnection().getConnection();
			query = conn.prepareStatement(createQuery(admin));
			ResultSet  rs = query.executeQuery();
			// CHANGE: Add functional 
			query.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return admin;
				
	}

	
	
	public static String createQuery(AuthenticatedUser user){
		String query = new String();
		query = "";
		return query;
		
	}
}
