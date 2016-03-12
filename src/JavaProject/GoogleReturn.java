package JavaProject;

import org.codehaus.jackson.annotate.JsonIgnore;

public class GoogleReturn {
	private Result[] results ;
	private String status ;
	@JsonIgnore
	private String error_message;

	public Result[] getResults() {
		return results;
	}
	
	public void setResults(Result[] results) {
		this.results = results;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
