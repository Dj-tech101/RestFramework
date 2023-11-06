package ModelListResponse.json22222;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DOOROPENINGWIDTHHEIGHTPRICE{
    public int id;
    public String doorOpeningWidth;
    public String doorOpeningHeight;
    public int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
    
}
