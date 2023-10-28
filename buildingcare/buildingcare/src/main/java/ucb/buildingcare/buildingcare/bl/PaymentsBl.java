package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PaymentRequest;
import ucb.buildingcare.buildingcare.dto.PaymentResponse;
import ucb.buildingcare.buildingcare.entity.Payment;
import ucb.buildingcare.buildingcare.repository.PaymentRepository;
import ucb.buildingcare.buildingcare.repository.TypeUserRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@Service
public class PaymentsBl {
    //Esta clase es la que se encarga de la logica sobre los pagos
    //Requiere de las tablas:
    //Payment
    //User
    //TypeUser
    
    Logger LOGGER = LoggerFactory.getLogger(PaymentsBl.class);

    @Autowired 
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeUserRepository typeUserRepository;

    public PaymentsBl(PaymentRepository paymentRepository, UserRepository userRepository, TypeUserRepository typeUserRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.typeUserRepository = typeUserRepository;
    }

    public BuildingcareResponse ListAllPayments() {
        LOGGER.info("PaymentsBl - ListAllPayments");
        List<Payment> payments = paymentRepository.findAll();
        LOGGER.info("el tamano de payments List<Payment> es: "+ payments.size());
        List<PaymentResponse> paymentResponses = new ArrayList<>();
        for (Payment payment : payments) {
            LOGGER.info("en el for de List<Payment> payments: "+ payment.toString());
            paymentResponses.add(new PaymentResponse(payment));
        }
        LOGGER.info("retornando new BuildingcareResponse(paymentResponses): "+ new BuildingcareResponse(paymentResponses).toString());
        return new BuildingcareResponse(paymentResponses);
    }

    public PaymentResponse getPaymentById(Integer id) throws BuildingcareException {
        LOGGER.info("PaymentsBl - getPaymentById");
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new BuildingcareException("Payment not found"));
        LOGGER.info("retornando new PaymentResponse(payment): "+ new PaymentResponse(payment).toString());
        return new PaymentResponse(payment);
    }

    public PaymentResponse createPayment(PaymentRequest paymentRequest) throws BuildingcareException {
        LOGGER.info("PaymentsBl - createPayment");
        Payment payment = new Payment();
        payment.setAmount(paymentRequest.getAmount());
        payment.setDate(paymentRequest.getDate());
        payment.setConcept(paymentRequest.getConcept());
        payment.setDetail(paymentRequest.getDetail());
        payment.setIdUserPays(userRepository.findById(paymentRequest.getIdUserPays()).orElseThrow(() -> new BuildingcareException("User not found")));
        payment.setIdUserReceives(userRepository.findById(paymentRequest.getIdUserReceives()).orElseThrow(() -> new BuildingcareException("User not found")));
        paymentRepository.save(payment);
        LOGGER.info("retornando new PaymentResponse(payment): "+ new PaymentResponse(payment).toString());
        return new PaymentResponse(payment);
    }


}
