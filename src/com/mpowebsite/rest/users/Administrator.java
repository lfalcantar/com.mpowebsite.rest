package com.mpowebsite.rest.users;

import javax.ws.rs.Path;
import javax.ws.rs.core.*;


@Path("/Query/Users")
public class Administrator extends AuthenticatedUser {

	@Path("/Create")
	public void createUser( UserType user, String[] characteristics) {
		switch (user) {
		case ADMINISTRATOR:
		   UserAccount.createUser(new Administrator(), characteristics);
			break;
		case MPO_LEAD:
		   UserAccount.createUser(new MpoLead(), characteristics);
			break;
		case MPO_STAFF:
		   UserAccount.createUser(new MpoStaff(), characteristics);
			break;
		case PROJECT_LEAD:
		   UserAccount.createUser(new ProjectLead(), characteristics);
			break;
		}
	}
}
