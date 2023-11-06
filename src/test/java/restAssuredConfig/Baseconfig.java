package restAssuredConfig;

import java.util.Map;

//


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Baseconfig {

	public static String baseUri = "https://test.dockproductsordercenter.com";
	public static String bearerToken = "654237c5297e743dbb458bef";
	public static String contentType = "application/json";
	public static Map<String, String> header;
	public static RequestSpecification  specifier;
	
//	@BeforeMethod
//	public static RequestSpecification restConfig() {
//
//		specifier = RestAssured.given();
//
//		header = baseHeader.getHeaderInfo(bearerToken, contentType);
//
//		specifier.baseUri(baseUri).headers(header);
//
//		return specifier;
//
//	}

}
