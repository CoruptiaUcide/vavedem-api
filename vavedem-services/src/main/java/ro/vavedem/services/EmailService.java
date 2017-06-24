package ro.vavedem.services;

import com.sendgrid.Email;
import com.sendgrid.Content;

import com.sendgrid.Mail;
import com.sendgrid.SendGrid;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.Method;
import org.springframework.beans.factory.annotation.Value;
import ro.vavedem.exceptions.VaVedemEmailException;
import ro.vavedem.interfaces.MailService;
import ro.vavedem.models.EmailModel;

import java.io.IOException;


/**
 * @author CoruptiaUcide
 */
@org.springframework.stereotype.Service
public class EmailService implements MailService<EmailModel> {

    @Value("${spring.mail.apikey}")
    private String sendGridApiKey;

    public void send(EmailModel model) throws VaVedemEmailException{

        Email from = new Email(model.getFrom());
        String subject = model.getSubject();
        Email to = new Email(model.getTo());
        Content content = new Content("text/plain", model.getContent());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        System.err.println();
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new VaVedemEmailException("Eroare la trimiterea emailului.");
        }
    }

}
