package ucb.buildingcare.buildingcare.bl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;

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

    private void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        FileSystemResource file = new FileSystemResource("src/main/resources/static/images/bcareNegro.png");
        helper.addInline("logo.png", file);

        javaMailSender.send(message);
        LOG.info("Email enviado a: " + to);
    }

    public void sendResetPasswordEmail(String to, String username) throws MessagingException {
        String subject = "Recuperar contraseña";
        String text = "<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap' rel='stylesheet'>"
            + "<body style='margin: 0; padding: 0; font-family: 'Poppins', sans-serif;'>"
            + "<div style='text-align: center; background-color: #F2F1E4; padding: 0px; padding-bottom: 20px;'>"
            + "<div style='background-color: #498C79; color: white; padding: 10px;'>"
            + "<h1 style='margin: 0;'>Recuperar contraseña</h1>"
            + "</div>"
            + "<p style='margin-top: 20px; font-size = 16px;'>Hola " + username + ",</p>"
            + "<p style='font-size = 16px;'>Para recuperar tu contraseña, haz clic en el siguiente enlace:</p>"
            + "<a href='" + referralUrl + "/resetPassword/reset/" + username + "' style='"
            + "background-color: #498C79; color: white; text-decoration: none; padding: 10px 20px; "
            + "border-radius: 5px; display: inline-block; margin-top: 20px;'>Recuperar contraseña</a>"
            + "<p style='margin-top: 20px; font-size = 16px;'>Si no solicitaste recuperar tu contraseña, ignora este mensaje.</p>"
            + "<p style='font-size = 16px;'>Saludos, el equipo de BuildingCare.</p>"
            + "<img src='cid:logo.png' style='display: block; margin: auto; margin-top: 20px;' width='20%'>"
            + "</div>"
            + "</body>";


        sendEmail(to, subject, text);
    }
}
