package ASIdata;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

	 @JsonProperty("listOfModels")
     private List<Model> listOfModels;

	public List<Model> getListOfModels() {
		return listOfModels;
	}

	public void setListOfModels(List<Model> listOfModels) {
		this.listOfModels = listOfModels;
	}

	
}
