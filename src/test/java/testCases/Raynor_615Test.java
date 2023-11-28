package testCases;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xddf.usermodel.chart.XDDFArea3DChartData.Series;
import org.testng.annotations.Test;

import ASIdata.AsiMain;
import ASIdata.Model;
import AsiPriceData.Root;
import ProjectApi.endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.DeserializationUtils;

public class Raynor_615Test {
	public static AsiMain asi;
	public static Root root;
	

	public static int modelseriesId = 0;

	@Test(dependsOnMethods = "testCases.AsiPriceTest.getAsidetails")
	public void getModelList() throws FileNotFoundException {

		String modelName = null;

		List<ASIdata.Model> modelList = AsiPriceTest.asi.getData().getListOfModels();

		for (Model modelGroup : modelList) {

			modelName = modelGroup.getModelName();

			if (modelName.equals("615")) {
				modelseriesId = modelGroup.getSeriesId();
				break;
			}
		}
		Response response = endpoints.getModelList(modelseriesId);
		
		String responseString=response.asString();
		
		 root=DeserializationUtils.deserializeJsonResponse(responseString, Root.class);
		
		
	}
}
