package Environment;

import java.util.Map;

import utils.jsonUtils;

public class Configure {

	public static Map<String, Object> jsondata;

	{
		String path = System.getProperty("QA") == null ? "QA" : System.getProperty("QA");

		try {
			jsondata = jsonUtils.getJsonDataAsMap(path);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
