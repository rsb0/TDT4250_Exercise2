package tdt4250.unitConverter.api;

public class ConversionResult {
	
	private boolean success;
	private String message;
	private float result;
	
	public ConversionResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
	
	
}
