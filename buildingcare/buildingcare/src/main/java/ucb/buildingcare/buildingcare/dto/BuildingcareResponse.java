package ucb.buildingcare.buildingcare.dto;

public class BuildingcareResponse {
    //Esta clase es la que se encarga de enviar la respuesta al front end
    
    private String responseCode;
    private Object data;
    private String errorMessage;

    public BuildingcareResponse() {
    }

    public BuildingcareResponse(Object data) {
        this.data = data;
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
