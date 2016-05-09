package com.mpowebsite.rest.users;

import com.mpowebsite.rest.user.query.UserQuery;

public class UserAccount {

	public static Administrator createUser(Administrator admin, String[] chars){	
		Administrator newAdmin = null;
		try {
			
			admin = populateUser(admin,chars);
			
			newAdmin = UserQuery.addAdministrator(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newAdmin;
	}

	public static MpoLead createUser(MpoLead mpoLead, String[] characteristics) {
		// TODO Auto-generated method stub

		return mpoLead;
		
	}

	public static MpoStaff createUser(MpoStaff mpoStaff, String[] characteristics) {
		// TODO Auto-generated method stub

		return mpoStaff;
		
	}

	public static ProjectLead createUser(ProjectLead projectLead, String[] characteristics) {
		// TODO Auto-generated method stub

		return projectLead;
		
	}
	
	private static Administrator populateUser(Administrator admin,String [] chars){
		
		
		
		return admin;
	}
	
}
