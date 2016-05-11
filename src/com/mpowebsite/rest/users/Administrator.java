package com.mpowebsite.rest.users;

import java.sql.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;
import com.mpowebsite.rest.db.*;/*Database*/
import com.mpowebsite.rest.user.query.UserQuery;
import com.mpowebsite.rest.util.*;

/**
 * This class represent the user:Administrator 
 * @author Luis Alcantar
 */

@Path("/Users")
public class Administrator extends AuthenticatedUser {

	@Path("/Create")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String createUser() {
		//UserType user, String[] characteristics
		//switch (user) {
		//caseADMINISTRATOR:
		 String [] characteristics= new String[2];
		
		  return UserAccount.createUser(new Administrator(), characteristics);
		  
//			break;
//		case MPO_LEAD:
//		   return UserAccount.createUser(new MpoLead(), characteristics);
//			break;
//		case MPO_STAFF:
//		   return UserAccount.createUser(new MpoStaff(), characteristics);
//			break;
//		case PROJECT_LEAD:
//		   return UserAccount.createUser(new ProjectLead(), characteristics);
//			break;
		//}
	}
	
	@Path("/Get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
	
		Response resutl = null;
		try {
			resutl =  UserQuery.getUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resutl;
	}
	
}
