package ASIdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AsiMain {

	
	 @JsonProperty("data")
	    private Data data;

	    @JsonProperty("type")
	    private String type;

	    @JsonProperty("message")
	    private String message;

	    @JsonProperty("status_msg")
	    private String status_msg;

	    @JsonProperty("status_code")
	    private String status_code;

		public Data getData() {
			return data;
		}

		public void setData(Data data) {
			this.data = data;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getStatus_msg() {
			return status_msg;
		}

		public void setStatus_msg(String status_msg) {
			this.status_msg = status_msg;
		}

		public String getStatus_code() {
			return status_code;
		}

		public void setStatus_code(String status_code) {
			this.status_code = status_code;
		}
	    
}
