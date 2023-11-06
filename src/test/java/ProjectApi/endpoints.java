package ProjectApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.testng.annotations.Test;

import Environment.Configure;
import Payloads.projectPayload;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.HeaderUtil;
import utils.jsonUtils;

public class endpoints {
	public static PrintStream log;

	public static final String Baseuri = "https://test.dockproductsordercenter.com";

	public static Map<String, Object> json = jsonUtils
			.getJsonDataAsMap(System.getProperty("user.dir") + "\\src\\main\\java\\Environment\\QA.json");

	public static RequestSpecification baseSetUp() {

		File filepath = new File(System.getProperty("user.dir") + "\\response.txt");

		try {

			FileOutputStream filout = new FileOutputStream(filepath);
			log = new PrintStream(filout);

		}

		catch (Exception e) {
			// TODO: handle exception
		}

		Map<String, String> header = HeaderUtil.getHeaders();

		return RestAssured.given().filter(ResponseLoggingFilter.logResponseTo(log)).baseUri(Baseuri).headers(header);

	}

	public static Response createProject(String projectName) {

		String endpoint = (String) json.get("createProject");
		String payload = projectPayload.postProject(projectName);

		return baseSetUp().body(payload).post(endpoint);

	}

	public static Response getProject(String projectId) {

		String endpoint = (String) json.get("getProject");

		return baseSetUp().queryParam("id", projectId).get(endpoint);

	}

	public static Response deleteProject(String Projectid) {
		String endpoint = (String) json.get("deleteProject");
		String payload = projectPayload.deleteProject(Projectid);

		return baseSetUp().body(payload).delete(endpoint);

	}

	public static Response updateProject(String projectName, String projectId) {
		String endpoint = (String) json.get("updateProject");
		String payload = projectPayload.updateProject(projectName, projectId);

		return baseSetUp().body(payload).put(endpoint);
	}

	public static Response GetbrandDetails(String projectId, String brandid) {
		String endpoint = (String) json.get("getbrandDetails");

		return baseSetUp().queryParam("orderId", projectId).queryParam("brandId", brandid).get(endpoint);
	}

	public static Response GetRaynorDetails(int brandCatId) {
		String endpoint = (String) json.get("getRaynorDetails");

		return baseSetUp().queryParam("brand_category_mapping_id", brandCatId).get(endpoint);
	}

	public static Response getModelList(int seriesId) {
		String endpoint = (String) json.get("getModelList200");

		return baseSetUp().queryParam("seriesId", seriesId).get(endpoint);
	}
}
