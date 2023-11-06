package BrandDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Brand {
	 private int brandId;
	    private int brand_category_mapping_id;
	    private String categoryImage;
	    private boolean enableCommonCategory;
	    private String logoImage;
	    private int quantity;
		public int getBrandId() {
			return brandId;
		}
		public void setBrandId(int brandId) {
			this.brandId = brandId;
		}
		public int getBrand_category_mapping_id() {
			return brand_category_mapping_id;
		}
		public void setBrand_category_mapping_id(int brand_category_mapping_id) {
			this.brand_category_mapping_id = brand_category_mapping_id;
		}
		public String getCategoryImage() {
			return categoryImage;
		}
		public void setCategoryImage(String categoryImage) {
			this.categoryImage = categoryImage;
		}
		public boolean isEnableCommonCategory() {
			return enableCommonCategory;
		}
		public void setEnableCommonCategory(boolean enableCommonCategory) {
			this.enableCommonCategory = enableCommonCategory;
		}
		public String getLogoImage() {
			return logoImage;
		}
		public void setLogoImage(String logoImage) {
			this.logoImage = logoImage;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

}
