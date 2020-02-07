package blockchain;

import java.security.MessageDigest;

public class StringUtil {

	public static String applySha256(String input){
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer();
			for (int count = 0; count < hash.length; count++) {
				String hex = Integer.toHexString(0xff & hash[count]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}	
	}
}
