package cm.adacorp.thymeleaf.services.impl;

import cm.adacorp.thymeleaf.entity.Person;
import cm.adacorp.thymeleaf.services.interf.EmailServiceInterf;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.IMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailServiceInterf {

    private final JavaMailSender mailSender;

    public void sendActivationEmail(Person person){
        String activationLink = "http://localhost:8080/auth/activate/"+person.getActivationCode();
        SimpleMailMessage activationMailMessage = new SimpleMailMessage();
        activationMailMessage.setTo(person.getEmail());
        activationMailMessage.setSubject("Account Activation");
        activationMailMessage.setText("S'il vous plaît veuillez cliquer sur ce liens pour activer votre compte utilisateur: "+activationLink);
        mailSender.send(activationMailMessage);

    }

    public void sendResetPasswordEmail(Person person){
        String resetLink = "http://localhost:8080/auth/activate/"+person.getResetCode();
        SimpleMailMessage resetMailMessage = new SimpleMailMessage();
        resetMailMessage.setTo(person.getEmail());
        resetMailMessage.setSubject("Password Reset");
        resetMailMessage.setText("Please click here to reset your password : "+ resetLink);

    }
}
