package ASIdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {
	@JsonProperty("seriesId")
    private int seriesId;

    @JsonProperty("modelDescription")
    private String modelDescription;

    @JsonProperty("conditionalId")
    private int conditionalId;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("modelName")
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
