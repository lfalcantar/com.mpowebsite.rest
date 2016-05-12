package com.mpowebsite.rest.db;

import java.sql.Connection;
import javax.naming.*;
import javax.sql.*;


/**
 * Skeleton pattern only one instance of the data source
 * this class will construct and connect the database
 * 
 * @author Luis Alcantar
 */

public class DbConnection {
	
	private static DataSource mpoDatabase = null;
	private static Context context = null;
	
	public static DataSource mpoDbConnection()throws Exception{
		
		if(mpoDatabase != null)
			return mpoDatabase;
		
		try {
			
			if(context == null){
				context = new InitialContext();
			}
			
			mpoDatabase = (DataSource) context.lookup("mpoDatabase");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Exeption DB MPO, please configure the tunnel, or start the server ");
		}
		
		return mpoDatabase;
	}	
}
