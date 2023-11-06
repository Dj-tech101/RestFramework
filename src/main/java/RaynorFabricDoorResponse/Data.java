package RaynorFabricDoorResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Data {
	private List<Model> listOfModels;

	public List<Model> getListOfModels() {
		return listOfModels;
	}

	public void setListOfModels(List<Model> listOfModels) {
		this.listOfModels = listOfModels;
	}

}
