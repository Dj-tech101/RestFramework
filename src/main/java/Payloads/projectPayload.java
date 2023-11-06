package Payloads;

public class projectPayload {

	public static String postProject(String name) {
		String json = "{\r\n" + "  \"projectName\":\"" + name + "\"\r\n" + "}";
		return json;

	}

	public static String deleteProject(String projectid) {
		// TODO Auto-generated method stub
		
		return "{\r\n"
				+ "  \"projectId\": \""+projectid+"\"\r\n"
				+ "}";
	}

	public static String updateProject(String projectName, String projectId) {
		// TODO Auto-generated method stub
		return "{\r\n"
				+ "  \"projectId\": \""+projectId+"\",\r\n"
				+ "  \"projectName\": \""+projectName+"\"\r\n"
				+ "}";
	}
}
