package com.mpowebsite.rest.users;

import com.mpowebsite.rest.user.query.UserQuery;

public class UserAccount {

	public static String createUser(Administrator admin, String[] chars){	
		Administrator newAdmin = null;
		//TEST
		String result = "ERROR";
		try {
			
			admin = populateUser(admin,chars);
			
			result = UserQuery.addAdministrator(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
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
		// TODO Auto-generated method stub
		return admin;
	}
	
}
