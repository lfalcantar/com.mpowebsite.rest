package com.mpowebsite.rest.users;

import java.sql.*;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;
import com.mpowebsite.rest.db.*;/*Database*/
import com.mpowebsite.rest.user.query.UserQuery;
import com.mpowebsite.rest.util.*;

import com.mpowebsite.rest.util.*;

/**
 * This class represent the user:Administrator 
 * @author Luis Alcantar
 */

@Path("/User")
public class Administrator extends AuthenticatedUser {

	@Path("/Create")
	@GET
	public void createUser(@QueryParam("email") String email,@QueryParam("password") String password, @QueryParam("firstName") String firstName,
						   @QueryParam("middleName") String middleName, @QueryParam("lastName") String LastName, @QueryParam("organizations") String organizations, 
						   @QueryParam("department") String Department, @QueryParam("title") String title, @QueryParam("phone") String phone, 
						   @QueryParam("userType") UserType type, @QueryParam("permissions") byte permissions) throws Exception {
				
		HashMap<String,	String> user = new HashMap<String, String>();
		/*User Fields*/
		user.put("email", email);
		user.put("password", password);
		user.put("firstName", firstName);
		user.put("middleName", middleName);
		user.put("lastName", LastName);
		user.put("organizations", organizations);
		user.put("department", Department);
		user.put("phone", phone);
		user.put("title",title);
		
		UserAccount.createUser(type,permissions,user );
	}
	
	@Path("/delete")
	@GET
	public void deleteUser(@QueryParam("id") String id) throws Exception {
		UserQuery.deleteUser(id);
	}
	
	
	@Path("/GetUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
	
		Response resutl = null;
		try {
			resutl =  UserQuery.getUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resutl;
	}
	
	@Path("/GetUser")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@QueryParam("id") String id) {
	
		Response resutl = null;
		try {
			resutl =  UserQuery.getUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resutl;
	}
	
	
}
