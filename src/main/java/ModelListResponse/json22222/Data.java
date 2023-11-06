package ModelListResponse.json22222;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data{
    public ListOfModelDetails listOfModelDetails;
    public int discount;
    public int materialSurcharge;
	public ListOfModelDetails getListOfModelDetails() {
		return listOfModelDetails;
	}
	public void setListOfModelDetails(ListOfModelDetails listOfModelDetails) {
		this.listOfModelDetails = listOfModelDetails;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getMaterialSurcharge() {
		return materialSurcharge;
	}
	public void setMaterialSurcharge(int materialSurcharge) {
		this.materialSurcharge = materialSurcharge;
	}
    
}
