package utils;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonUtils {

	public static Map<String, Object> data;

	static ObjectMapper mapper = new ObjectMapper();

	public static Map<String, Object> getJsonDataAsMap(String path) {
		try {
			data = mapper.readValue(new File(path), new TypeReference<Map<String, Object>>() {});

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return data;

	}

}
