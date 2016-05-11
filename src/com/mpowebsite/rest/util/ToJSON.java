package com.mpowebsite.rest.util;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * This Class will convert a database data to JSON format 
 *@author Luis Alcantar
 */

public class ToJSON {
	
	public JSONArray toJSONArray(ResultSet resultSet){
		
		JSONArray json = new JSONArray();
		
		try {
			/*This method will give us the metadata of the result set, the colums*/
			java.sql.ResultSetMetaData rsmd = resultSet.getMetaData();
			
			
			while(resultSet.next()){
				
				/*Get number of columns from the resultSet*/
				int numColums = rsmd.getColumnCount();
				
				/*Each role in the resulSet will be converted into an object*/
				JSONObject obj = new JSONObject();
				
				/*Loop through all the columns and place them into JSON objects*/
				for (int i = 1; i < numColums ; i++) {
					String columnName = rsmd.getColumnName(i);
					
					switch (rsmd.getColumnType(i)) {
					case java.sql.Types.VARCHAR:
						obj.put(columnName, resultSet.getString(columnName));
						break;
					case java.sql.Types.INTEGER:
						obj.put(columnName, resultSet.getInt(columnName));
						break;
					case java.sql.Types.FLOAT:
						obj.put(columnName, resultSet.getFloat(columnName));
						break;
					case java.sql.Types.SMALLINT:
						obj.put(columnName, resultSet.getInt(columnName));
						break;
					case java.sql.Types.TINYINT:
						obj.put(columnName, resultSet.getInt(columnName));
						break;
					case java.sql.Types.DATE:
						obj.put(columnName, resultSet.getDate(columnName));
						break;
					case java.sql.Types.DECIMAL:
						obj.put(columnName, resultSet.getBigDecimal(columnName));
						break;
					default:
						obj.put(columnName, resultSet.getObject(columnName));
						// DEBUG: This will need to be debug no condition found
						System.out.println("ToJson-DEBUGG: " + columnName);		
					}//END of Switch
				}// END of for
				
				json.put(obj);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ToJSON- CATCH: This Exeption was catch from the toJSON CLass");
			e.printStackTrace();
		}
		return  json;
	}
}
