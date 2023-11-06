package AsiPriceData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Asi_615Price {
	private Integer id;
	private String doorOpeningWidth;
	private String doorOpeningHeight;
	private Integer price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDoorOpeningWidth() {
		return doorOpeningWidth;
	}
	public void setDoorOpeningWidth(String doorOpeningWidth) {
		this.doorOpeningWidth = doorOpeningWidth;
	}
	public String getDoorOpeningHeight() {
		return doorOpeningHeight;
	}
	public void setDoorOpeningHeight(String doorOpeningHeight) {
		this.doorOpeningHeight = doorOpeningHeight;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
