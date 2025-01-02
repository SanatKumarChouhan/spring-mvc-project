package in.co.rays.common;

import java.util.HashMap;
import java.util.Map;

public class ORSResponse {

	private static final String ERROR_INPUT = "inputerrors";
	private static final String MESSAGE = "message";
	private static final String DATA = "data";

	private Map<String, Object> result = new HashMap<String, Object>();

	private boolean success = false;

	public ORSResponse() {

	}

	public ORSResponse(boolean success) {
		
		this.success=success;

	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void addInputError(Object value) {

		result.put(ERROR_INPUT, value);
	}

	public void addMessage(Object value) {

		result.put(MESSAGE, value);
	}

	public void addData(Object value) {

		result.put(DATA, value);
	}

	public void addResult(String key, Object value) {

		result.put(key, value);
	}

}
