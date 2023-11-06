package RaynorFabricDoorResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {
	private int seriesId;
    private String modelDescription;
    private int conditionalId;
    private Double price; // Use Double for nullable numeric fields
    private String modelName;
	public int getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public int getConditionalId() {
		return conditionalId;
	}
	public void setConditionalId(int conditionalId) {
		this.conditionalId = conditionalId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
    
    
}
