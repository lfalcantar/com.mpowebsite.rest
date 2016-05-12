package com.mpowebsite.rest.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {

	public static String encode(String passport_text){
		MessageDigest mDigest = null;
		StringBuffer sb = null;
		
		try {
			mDigest = MessageDigest.getInstance("SHA-256");
			byte[] result = mDigest.digest(passport_text.getBytes());
	        sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return  sb.toString();
	}
}
