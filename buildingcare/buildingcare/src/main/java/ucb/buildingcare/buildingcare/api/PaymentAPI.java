package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.PaymentsBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PaymentRequest;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentAPI {
    
    Logger LOGGER = LoggerFactory.getLogger(PaymentAPI.class);

    @Autowired
    private PaymentsBl paymentBl;

    public PaymentAPI(PaymentsBl paymentBl) {
        this.paymentBl = paymentBl;
    }

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllPayments() {
        LOGGER.info("PaymentAPI - ListAllPayments");
        BuildingcareResponse buildingcareResponse = paymentBl.ListAllPayments();
        buildingcareResponse.setResponseCode("PAYM-0000");
        return buildingcareResponse;
    }

    @GetMapping(path = "/{id}")
    public BuildingcareResponse getPaymentById(@PathVariable Integer id){
        LOGGER.info("getPaymentById: id: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(paymentBl.getPaymentById(id));
            buildingcareResponse.setResponseCode("PAYM-0000");
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("PAYM-6000");
        }
        return buildingcareResponse;
    }

    @PostMapping
    public BuildingcareResponse createPayment(@RequestBody PaymentRequest paymentRequest, @RequestHeader Integer token){
        LOGGER.info("Creando pago");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(paymentBl.createPayment(paymentRequest));
            buildingcareResponse.setResponseCode("PAYM-0001");
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("PAYM-6001");
        }
        return buildingcareResponse;
    }


}
