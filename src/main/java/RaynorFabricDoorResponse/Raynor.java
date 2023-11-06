package RaynorFabricDoorResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Raynor {
	  private Data data;
	    private String type;
	    private String message;
	    private String status_msg;
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
