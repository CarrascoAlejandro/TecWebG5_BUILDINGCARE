package ucb.buildingcare.buildingcare.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.referral_url}")
    private String referralUrl;
    
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
        LOG.info("Email enviado a: " + to);
    }

    public void sendResetPasswordEmail(String to, int token) {
        String subject = "Recuperar contraseña";
        String text = "Para recuperar tu contraseña, haz click en el siguiente enlace: http://" + referralUrl + "/reset-password?userId=" + token;
        sendEmail(to, subject, text);
    }
}
