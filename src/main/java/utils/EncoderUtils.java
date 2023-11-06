package utils;

import java.net.URLEncoder;
import java.util.List;

public class EncoderUtils {

	
	public static String encodeString(List<String>arr) {
		
		
		String queryString=String.join(",", arr);
		
		String encodedString=null;
		
		try {
			encodedString=URLEncoder.encode(queryString, "UTF-8");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		return encodedString;
	}
}
