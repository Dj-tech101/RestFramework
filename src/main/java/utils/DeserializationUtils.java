package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationUtils {
	 public static <T> T deserializeJsonResponse(String response, Class<T> responseType) {
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            return objectMapper.readValue(response, responseType);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null; // You may want to handle exceptions more gracefully
	        }
	    }
}
