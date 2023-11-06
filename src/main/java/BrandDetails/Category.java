package BrandDetails;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Category {

	 private List<Brand> brand;
	    private String categoryName;
	    public List<Brand> getBrand() {
			return brand;
		}
		public void setBrand(List<Brand> brand) {
			this.brand = brand;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public int getCategory_id() {
			return category_id;
		}
		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
		private int category_id;

}
