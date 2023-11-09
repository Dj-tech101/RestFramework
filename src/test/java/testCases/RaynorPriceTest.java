package testCases;

import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BrandDetails.Brand;
import BrandDetails.Category;
import BrandDetails.Root;
import ModelListResponse.json22222.DOOROPENINGWIDTHHEIGHTPRICE;
import ProjectApi.endpoints;
import RaynorFabricDoorResponse.Model;
import RaynorFabricDoorResponse.Raynor;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import modeRc300_Price.rc300Price;
import utils.DataUtils;
import utils.DeserializationUtils;
import utils.EncoderUtils;

public class RaynorPriceTest {

	public static Root root;
	public static Raynor raynordata;

	public rc300Price rc300;
	public static String projectid;

	public ModelListResponse.json22222.Root model;

	@Test(dependsOnMethods = "testCases.Project_CrudTest.CreateProject")
	public static void getBrandDetails() {

		List<String> brandIds = Project_CrudTest.projectres.getData().getProject().getBrand_ids();

		String encodeString = EncoderUtils.encodeString(brandIds);

		// System.out.println("encoded string is " + encodeString);
		Response response = endpoints.GetbrandDetails(Project_CrudTest.projectres.getData().getProjectId(),
				encodeString);

		root = DeserializationUtils.deserializeJsonResponse(response.asString(), Root.class);

		System.out.println("Get brand details " + root.getStatus_code());

	}

	@Test(dependsOnMethods = "getBrandDetails")
	public static void getRaynordetails() {

		String model = "FABRIC DOOR";

		getBrandDetails();
		int brandCatId = 0;

		List<Category> listcat = root.getData().getCategories();

		for (Category cat : listcat) {

			if (cat.getCategoryName().equals(model)) {

				brandCatId = cat.getBrand().get(1).getBrand_category_mapping_id();
			}
		}
		Response response = endpoints.GetRaynorDetails(brandCatId);

		System.out.println(response.asPrettyString());
		raynordata = DeserializationUtils.deserializeJsonResponse(response.asString(), Raynor.class);
	}

	@Test(dataProvider = "rc200Price", dependsOnMethods = "getRaynordetails")
	public void getmodelList200(String brand, String modelName, String opeHeight, String opeWidth,
			String expectedPrice) {

		// getRaynordetails(brand);

		// String modelName = "RC200";

		int seriesId = 0;

		List<Model> modellist = raynordata.getData().getListOfModels();

		for (Model model : modellist) {

			if (model.getModelName().equals(modelName)) {

				seriesId = model.getSeriesId();

			}
		}

		Response response = endpoints.getModelList(seriesId);

		model = DeserializationUtils.deserializeJsonResponse(response.asString(),
				ModelListResponse.json22222.Root.class);

		ArrayList<DOOROPENINGWIDTHHEIGHTPRICE> price = model.getData()
				.getListOfModelDetails().dOOR_OPENING_WIDTH_HEIGHT_PRICE;

		for (DOOROPENINGWIDTHHEIGHTPRICE dooropeningwidthheightprice : price) {

			// System.out.println(dooropeningwidthheightprice.getDoorOpeningHeight());

			if (dooropeningwidthheightprice.getDoorOpeningHeight().equals(opeHeight)
					&& dooropeningwidthheightprice.getDoorOpeningWidth().equals(opeWidth)) {

				int expectedString = Integer.parseInt(expectedPrice);

				System.out.println("Actual Price is  " + dooropeningwidthheightprice.getPrice());
				System.out.println("Expected Price is  " + expectedPrice);
				Assert.assertEquals(dooropeningwidthheightprice.getPrice(), expectedString);
			}
		}

	}

	@Test(dependsOnMethods = "getRaynordetails", dataProvider = "rc300Price")
	public void getmodelList300(String brand, String modelName, String opeHeight, String opeWidth,
			String expectedPrice) {
		// String modelName = "RC300";

		// getRaynordetails(brand);
		int seriesId = 0;

		List<Model> modellist = raynordata.getData().getListOfModels();

		for (Model model : modellist) {
			if (model.getModelName().equals(modelName)) {
				seriesId = model.getSeriesId();
			}
		}

		Response response = endpoints.getModelList(seriesId);

		JsonPath path = response.jsonPath();

		List<rc300Price> rc300price = path.getList("data.listOfModelDetails.DOOR_OPENING_WIDTH_HEIGHT_PRICE",
				rc300Price.class);

		for (rc300Price model : rc300price) {

			if (model.getDoorOpeningHeight().equals(opeHeight) && model.getDoorOpeningWidth().equals(opeWidth)) {
				int actualPrice = model.getPrice();
				int exprice = Integer.parseInt(expectedPrice);
				System.out.println("Actual Price is  " + actualPrice);
				System.out.println("Expected Price is  " + exprice);

				Assert.assertEquals(actualPrice, exprice);

			}
		}
	}

	@Test(dependsOnMethods = "getRaynordetails", dataProvider = "rc300hdPrice")
	public void getmodelList300hd(String brand, String modelName, String opeHeight, String opeWidth,
			String expectedPrice) {

		int seriesId = 0;

		List<Model> modellist = raynordata.getData().getListOfModels();

		for (Model model : modellist) {
			if (model.getModelName().equals(modelName)) {
			
				seriesId = model.getSeriesId();
		
			}
		}
		Response response = endpoints.getModelList(seriesId);
		JsonPath path = response.jsonPath();
		List<rc300Price> rc300price = path.getList("data.listOfModelDetails.DOOR_OPENING_WIDTH_HEIGHT_PRICE",
				rc300Price.class);
		for (rc300Price model : rc300price) {
			if (model.getDoorOpeningHeight().equals(opeHeight) && model.getDoorOpeningWidth().equals(opeWidth)) {
				int actualPrice = model.getPrice();
				int exprice = Integer.parseInt(expectedPrice);
				System.out.println("Actual Price is  " + actualPrice);
				System.out.println("Expected Price is  " + exprice);
				Assert.assertEquals(actualPrice, exprice);
			}
		}

//		model = DeserializationUtils.deserializeJsonResponse(response.asString(),
//				ModelListResponse.json22222.Root.class);
//
//		ArrayList<DOOROPENINGWIDTHHEIGHTPRICE> price = model.getData()
//				.getListOfModelDetails().dOOR_OPENING_WIDTH_HEIGHT_PRICE;
//
//		System.out.println(price.size());
//		for (DOOROPENINGWIDTHHEIGHTPRICE dooropeningwidthheightprice : price) {
//
//			// System.out.println(dooropeningwidthheightprice.getDoorOpeningHeight());
//
//			if (dooropeningwidthheightprice.getDoorOpeningHeight().equals(opeHeight)
//					&& dooropeningwidthheightprice.getDoorOpeningWidth().equals(opeWidth)) {
//
//				int expectedString = Integer.parseInt(expectedPrice);
//
//				System.out.println("Actual Price is  " + dooropeningwidthheightprice.getPrice());
//				System.out.println("Expected Price is  " + expectedPrice);
//
//				Assert.assertEquals(dooropeningwidthheightprice.getPrice(), expectedString);
//			}
//		}

	}
	@AfterTest
	public void deleteProject() {

		Response response = endpoints.deleteProject(projectid);
		System.out.println(response.asPrettyString());
	}


	@DataProvider(name = "rc200Price")
	public String[][] updatedata() throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\testData\\RC200_PriceTest.xlsx";
		String sheetName = "Sheet1";
		return DataUtils.dataContainer(path, sheetName);
	}

	@DataProvider(name = "rc300Price")
	public String[][] rc300() throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\testData\\RC300_PriceTest.xlsx";
		String sheetName = "Sheet1";
		return DataUtils.dataContainer(path, sheetName);
	}

	@DataProvider(name = "rc300hdPrice")
	public String[][] rc300hd() throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\testData\\RC300hd_PriceTest.xlsx";
		String sheetName = "Sheet1";
		return DataUtils.dataContainer(path, sheetName);

	}
}
