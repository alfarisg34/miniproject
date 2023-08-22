package RegistrationLogin.response;

// import org.hibernate.mapping.Map;

public class Response {
    String message;
	Boolean status;
	// java.util.Map<String, String> data;
	
	public Response(String message, Boolean status) {
		this.message = message;
		this.status = status;
		// this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// return "Response [message=" + message + ", status=" + status + ", data=" + data + "]";
		return "Response [message=" + message + ", status=" + status + "]";
	}
}
