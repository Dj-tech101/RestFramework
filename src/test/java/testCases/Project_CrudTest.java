package testCases;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Payloads.projectPayload;
import ProjectApi.endpoints;
import ProjectResponse.Data;
import ProjectResponse.ProjectResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import projectIdResponse.Root;
import utils.DataUtils;
import utils.DeserializationUtils;
import utils.HeaderUtil;
import utils.jsonUtils;

public class Project_CrudTest {
	static ProjectResponse projectres;
	public static Root root;
public static String projectId;

	@Test(dataProvider = "projectData")
	public static void CreateProject(String projectName) throws JsonMappingException, JsonProcessingException {

		Response response = endpoints.createProject(projectName);

		String json = response.asString();

		projectres = DeserializationUtils.deserializeJsonResponse(json, ProjectResponse.class);

		System.out.println("***Project creation message is  " + projectres.getMessage());

		// System.out.println(response.asPrettyString());

	}

	@Test(dependsOnMethods = "CreateProject")
	public static void getProject() {

		Response response = endpoints.getProject(projectres.getData().getProjectId());

		System.out.println("******** project details get sucessfully **");

		root = DeserializationUtils.deserializeJsonResponse(response.asString(), Root.class);

		projectId=root.getData().getId();
		
		System.out.println("Status Code is  " + root.getStatus_code());
	}

	@Test(dependsOnMethods = "getProject", dataProvider = "updatedata")
	public static void updateProject(String projectName) {

		Response response = endpoints.updateProject(projectName, root.getData().getId());

		System.out.println("******** project details update sucessfully **");
		projectres = DeserializationUtils.deserializeJsonResponse(response.asString(), ProjectResponse.class);

		System.out.println("Updated project name is  " + projectres.getData().getProject().getName());

	}

	@Test(dependsOnMethods = "CreateProject")
	public static void deleteProject() {	
		
		System.out.println(projectres.getData().getProjectId());

		Response response = endpoints.deleteProject(projectres.getData().getProjectId());

		System.out.println("******** project details delete sucessfully **");

		System.out.println(response.asPrettyString());

	}

	@DataProvider(name = "projectData")
	public String[][] provider() throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\testData\\projectData.xlsx";
		String sheetName = "Sheet1";
		return DataUtils.dataContainer(path, sheetName);

	}

	@DataProvider(name = "updatedata")
	public String[][] updatedata() throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\testData\\updateProject.xlsx";
		String sheetName = "Sheet1";
		return DataUtils.dataContainer(path, sheetName);

	}

}