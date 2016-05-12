package com.mpowebsite.rest.users;

import java.util.Random;

import com.mpowebsite.rest.user.query.UserQuery;


public class GenerateID {
	
	/**
	 * This method will ensure that the user adquires a unique id
	 * @param firstName
	 * @param lastName
	 * @return the String representing the unique id of a user
	 */
	public static String generateUserID(String firstName, String lastName){
		String id = null;
		Random  rd = new Random();
		int i = rd.nextInt(100 - 1 + 1) + 1;
		
		try {
			do{
				id = firstName + lastName + "" +i;
				
				i = rd.nextInt(100 - 1 + 1) + 1;
			}while(!UserQuery.uniqueId(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return id;
	}
	
	public static String generateProjectID(String projectLead, String projectDistrict){
		String id = null;
		int i = 1;
		
		try {
			do{
				id = projectLead + projectDistrict + "" +i;
				
				i = (int)Math.random() * 100 +1;
			}while(UserQuery.uniqueId(id));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return id;
	}


}
