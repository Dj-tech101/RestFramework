package testCases;

import java.io.IOException;

import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ASIdata.AsiMain;
import AsiPriceData.Asi_615Price;
import BrandDetails.Category;
import BrandDetails.Root;
import ProjectApi.endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import modeRc300_Price.rc300Price;
import utils.DataUtils;
import utils.DeserializationUtils;
import utils.EncoderUtils;

public class AsiPriceTest {

	public static Root root;

	public static AsiMain asi;

	public static String projectid;

	@Test(dependsOnMethods = "testCases.Project_CrudTest.CreateProject")
	public static void getBrandDetails() {
		
		
		projectid = Project_CrudTest.projectres.getData().getProjectId();

		List<String> brandIds = Project_CrudTest.projectres.getData().getProject().getBrand_ids();

		String encodeString = EncoderUtils.encodeString(brandIds);

		// System.out.println("encoded string is " + encodeString);
		Response response = endpoints.GetbrandDetails(Project_CrudTest.projectres.getData().getProjectId(),
				encodeString);

		root = DeserializationUtils.deserializeJsonResponse(response.asString(), Root.class);

		System.out.println("Get brand details " + root.getStatus_code());

	}

	@Test(dependsOnMethods = "getBrandDetails")
	public static void getAsidetails() {

		String model = "FABRIC DOOR";

		getBrandDetails();
		int brandCatId = 0;

		List<Category> listcat = root.getData().getCategories();

		for (Category cat : listcat) {

			if (cat.getCategoryName().equals(model)) {

				brandCatId = cat.getBrand().get(0).getBrand_category_mapping_id();
			}
		}
		Response response = endpoints.GetRaynorDetails(brandCatId);

		// System.out.println(response.asPrettyString());
		asi = DeserializationUtils.deserializeJsonResponse(response.asString(), AsiMain.class);

		// System.out.println(asi.getMessage());
	}

	@Test(dataProvider = "asiData", dependsOnMethods = "getAsidetails")
	public void getmodelList200(String brand, String modelName, String opeHeight, String opeWidth,
			String expectedPrice) {
		int seriesId = 0;
		List<ASIdata.Model> modellist = asi.getData().getListOfModels();

		for (ASIdata.Model model : modellist) {

			if (model.getModelName().equals(modelName)) {
				
				seriesId = model.getSeriesId();
			}	
		}
		Response response = endpoints.getModelList(seriesId);
		JsonPath path = response.jsonPath();
		List<Asi_615Price> asi615 = path.getList("data.listOfModelDetails.DOOR_OPENING_WIDTH_HEIGHT_PRICE",
				Asi_615Price.class);

		for (Asi_615Price price : asi615) {

			if (price.getDoorOpeningHeight().equals(opeHeight) && price.getDoorOpeningWidth().equals(opeWidth)) {
				int actualPrice = price.getPrice();
				int exPrice = Integer.parseInt(expectedPrice);

				System.out.println("actual price is " + actualPrice);
				System.out.println("exoected Prcie " + exPrice);

				Assert.assertEquals(actualPrice, exPrice);	
			}
		}
	}

	@AfterTest
	public void deleteProject() {
		Response response = endpoints.deleteProject(projectid);
		System.out.println(response.asPrettyString());
	}

	@DataProvider(name = "asiData")
	public String[][] rc300hd() throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "\\testData\\AsiData_615L.xlsx";
		String sheetName = "Sheet1";
		return DataUtils.dataContainer(path, sheetName);

	}

}
