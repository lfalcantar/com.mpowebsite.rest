package com.mpowebsite.rest.users;

import java.sql.SQLException;
import java.util.HashMap;

import com.mpowebsite.rest.user.query.UserQuery;

public class UserAccount {
	/**
	 * this method will be controlling which user to create. 
	 * @param type
	 * @param permissions
	 * @param user
	 * @throws Exception 
	 */
	public static void createUser(UserType type, byte permissions, HashMap<String, String> userFields) throws Exception {
		
		String User_type = type.toString();
		System.out.println("TYPEUSER"+User_type);
		if(User_type.compareTo("ADMINISTRATOR") == 0)
			createUser(new Administrator(), permissions,userFields);
		else if(User_type.compareTo("MPO_LEAD") == 0)
			createUser(new MpoLead(), permissions,userFields);
		else if(User_type.compareTo("MPO_STAFF") == 0)
			createUser(new MpoStaff(), permissions,userFields);
		else if(User_type.compareTo("PROJECT_LEAD") == 0)
			createUser(new ProjectLead(), permissions,userFields);
		
	}

	/**
	 * This method will user the method populateUser and it will call the database 
	 * @param administrator
	 * @param permissions
	 * @param userFields
	 * @throws Exception 
	 */
	private static void createUser(Administrator administrator, byte permissions, HashMap<String, String> userFields) throws Exception{	
		// TODO Auto-generated method stub
		administrator = populateUser(administrator, permissions, userFields);
		UserQuery.createUser(administrator);
	}
	

	private static void createUser(MpoLead mpoLead, byte permissions, HashMap<String, String> userFields) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ADING MPOLEAD");
		mpoLead = populateUser(mpoLead, permissions, userFields);
		UserQuery.createUser(mpoLead);

	}

	private static void createUser(MpoStaff mpoStaff,byte permissions, HashMap<String, String> userFields) throws Exception {
		// TODO Auto-generated method stub
		mpoStaff = populateUser(mpoStaff, permissions, userFields);
		UserQuery.createUser(mpoStaff);

		
	}

	private static void createUser(ProjectLead projectLead, byte permissions, HashMap<String, String> userFields) throws Exception {
		// TODO Auto-generated method stub
		projectLead = populateUser(projectLead, permissions, userFields);
		UserQuery.createUser(projectLead);

	}
	
	/**
	 * The populate method will help the create user to populate the Object Administrator
	 * @param administrator
	 * @param permissions
	 * @param userFields
	 * @return
	 */
	private static Administrator populateUser(Administrator administrator,byte permissions, HashMap<String, String> userFields){
		
		administrator.setId(GenerateID.generateUserID(userFields.get("firstName"), userFields.get("lastName")));
		administrator.setEmail(userFields.get("email"));
		administrator.setPassword(userFields.get("password"));
		administrator.setFirstName(userFields.get("firstName"));
		administrator.setMiddleName(userFields.get("middleName"));
		administrator.setLastNAme(userFields.get("lastName"));
		administrator.setOrganization(userFields.get("organization"));
		administrator.setDepartment(userFields.get("department"));
		administrator.setPositionTitle(userFields.get("title"));
		administrator.setDepartmentContactInformation(userFields.get("phone"));
		administrator.setPermissions(permissions);
		administrator.setType(UserType.ADMINISTRATOR);	
		
		return administrator;
	}
	private static MpoStaff populateUser(MpoStaff mpoStaff,byte permissions, HashMap<String, String> userFields){
		
		mpoStaff.setId(GenerateID.generateUserID(userFields.get("firstName"), userFields.get("lastName")));
		mpoStaff.setEmail(userFields.get("email"));
		mpoStaff.setPassword(userFields.get("password"));
		mpoStaff.setFirstName(userFields.get("firstName"));
		mpoStaff.setMiddleName(userFields.get("middleName"));
		mpoStaff.setLastNAme(userFields.get("lastName"));
		mpoStaff.setOrganization(userFields.get("organizations"));
		mpoStaff.setDepartment(userFields.get("department"));
		mpoStaff.setPositionTitle(userFields.get("title"));
		mpoStaff.setDepartmentContactInformation(userFields.get("phone"));
		mpoStaff.setPermissions(permissions);
		mpoStaff.setType(UserType.MPO_STAFF);	
		
		return mpoStaff;
	}
	private static ProjectLead populateUser(ProjectLead projectLead,byte permissions, HashMap<String, String> userFields){
		
		projectLead.setId(GenerateID.generateUserID(userFields.get("firstName"), userFields.get("lastName")));
		projectLead.setEmail(userFields.get("email"));
		projectLead.setPassword(userFields.get("password"));
		projectLead.setFirstName(userFields.get("firstName"));
		projectLead.setMiddleName(userFields.get("middleName"));
		projectLead.setLastNAme(userFields.get("lastName"));
		projectLead.setOrganization(userFields.get("organizations"));
		projectLead.setDepartment(userFields.get("department"));
		projectLead.setPositionTitle(userFields.get("title"));
		projectLead.setDepartmentContactInformation(userFields.get("phone"));
		projectLead.setPermissions(permissions);
		projectLead.setType(UserType.MPO_LEAD);
		
		return projectLead;
	}
	private static MpoLead populateUser(MpoLead mpoLead,byte permissions, HashMap<String, String> userFields){
		
		mpoLead.setId(GenerateID.generateUserID(userFields.get("firstName"), userFields.get("lastName")));
		mpoLead.setEmail(userFields.get("email"));
		mpoLead.setPassword(userFields.get("password"));
		mpoLead.setFirstName(userFields.get("firstName"));
		mpoLead.setMiddleName(userFields.get("middleName"));
		mpoLead.setLastNAme(userFields.get("lastName"));
		mpoLead.setOrganization(userFields.get("organizations"));
		mpoLead.setDepartment(userFields.get("department"));
		mpoLead.setPositionTitle(userFields.get("title"));
		mpoLead.setDepartmentContactInformation(userFields.get("phone"));
		mpoLead.setPermissions(permissions);
		mpoLead.setType(UserType.MPO_LEAD);
			
		return mpoLead;

	}	
}
