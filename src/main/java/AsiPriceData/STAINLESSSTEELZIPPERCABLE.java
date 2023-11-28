package AsiPriceData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class STAINLESSSTEELZIPPERCABLE{
    public int id;
    public int seriesId;
    public String value;
    public int optionId;
    public boolean is_consult_factory;
    public String slug;
    public int conditionalId;
    public boolean controlPanelTbd;
    public double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public boolean isIs_consult_factory() {
		return is_consult_factory;
	}
	public void setIs_consult_factory(boolean is_consult_factory) {
		this.is_consult_factory = is_consult_factory;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public int getConditionalId() {
		return conditionalId;
	}
	public void setConditionalId(int conditionalId) {
		this.conditionalId = conditionalId;
	}
	public boolean isControlPanelTbd() {
		return controlPanelTbd;
	}
	public void setControlPanelTbd(boolean controlPanelTbd) {
		this.controlPanelTbd = controlPanelTbd;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
    
}
