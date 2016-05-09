package com.mpowebsite.rest.db;

import javax.naming.*;
import javax.sql.*;
import javax.ws.rs.Path;


/**
 * Skeleton pattern only one instance of the data source
 */

public class DbConnection {
	
	private static DataSource MPODATABASE = null;
	private static Context context = null;
	
	public static DataSource MpoDbConnection()throws Exception{
		
		if(MPODATABASE != null)
			return MPODATABASE;
		
		try {
			
			if(context == null){
				context = new InitialContext();
			}
			
			MPODATABASE = (DataSource) context.lookup("MPODATABASE");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exeption DB MPO, please configure the tunnel, or start the server ");
		}
		
		return MPODATABASE;
	}
	
}
