package ucb.buildingcare.buildingcare.dto;

public class BuildingcareResponse {
    
    private String responseCode;
    private Object data;
    private String errorMessage;

    public BuildingcareResponse() {
    }

    public BuildingcareResponse(String responseCode, Object data, String errorMessage) {
        this.responseCode = responseCode;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
