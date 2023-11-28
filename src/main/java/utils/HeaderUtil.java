package utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {

	public static Map<String, String> header;

	public static Map<String, String> getHeaders() {

		header = new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("Authorization", "Bearer 6564a79221d9730584d865bc");

		return header;

	}
}
