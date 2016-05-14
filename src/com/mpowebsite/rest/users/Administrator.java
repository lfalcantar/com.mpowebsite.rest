package com.mpowebsite.rest.users;

import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.*;


import com.mpowebsite.rest.user.query.UserQuery;


/**
 * This class represent the user:Administrator 
 * @author Luis Alcantar
 */

@Path("/User")
public class Administrator extends AuthenticatedUser {

	@Path("/Create")
	@POST
	public Response createUser(@FormParam("email") String email,@FormParam("password") String password, @FormParam("firstName") String firstName,
			@FormParam("middleName") String middleName, @FormParam("lastName") String LastName, @FormParam("organization") String organizations, 
			@FormParam("department") String Department, @FormParam("title") String title, @FormParam("phone") String phone, 
			@FormParam("userType") UserType type, @FormParam("permissions") byte permissions) throws Exception {
				
		HashMap<String,	String> user = new HashMap<String, String>();
		/*User Fields*/
		user.put("email", email);
		user.put("password", password);
		user.put("firstName", firstName);
		user.put("middleName", middleName);
		user.put("lastName", LastName);
		user.put("organization", organizations);
		user.put("department", Department);
		user.put("phone", phone);
		user.put("title",title);
				
		System.out.println("ADDING NEW USER_ADMINISTRATOR");
		UserAccount.createUser(type,permissions,user);
		return Response.ok("success").header("Access-Control-Allow-Origin", "*").build();

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
