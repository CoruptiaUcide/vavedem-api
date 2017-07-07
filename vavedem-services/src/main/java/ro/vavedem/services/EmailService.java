package ro.vavedem.services;

import com.sendgrid.*;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ro.vavedem.exceptions.VaVedemEmailException;
import ro.vavedem.interfaces.MailService;
import ro.vavedem.models.EmailModel;
import ro.vavedem.persistence.repository.EmailRepository;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * @author CoruptiaUcide
 */
@org.springframework.stereotype.Service
public class EmailService implements MailService<EmailModel> {

    private static final Logger logger = Logger.getLogger(EmailService.class);

    /**
     * TODO save email metadata in db
     */
    @Autowired
    private EmailRepository repository;

    @Value("${spring.mail.apikey}")
    private String sendGridApiKey;

    @Value("${spring.mail.formularedir}")
    private String formulareDir;

    public void send(EmailModel model) throws VaVedemEmailException {

        Email from = new Email(model.getFrom());
        String subject = model.getSubject();
        Email to = new Email(model.getTo());
        Content content = new Content("text/plain", model.getContent());
        Mail mail = new Mail(from, subject, to, content);

        Map<String, String> fileNames = listFormulare(formulareDir);
        final String formular = model.getFormular();
        final String fileName = fileNames.get(formular);

        if(StringUtils.isBlank(fileName) && StringUtils.isNotBlank(formular)){
            logger.error("[VaVedem] :  formularul : " + formular + " nu a fost gasit pe disk. ");
            throw new VaVedemEmailException("Eroare la trimiterea emailului.");
        }

        String base64 = null;
        try {
            base64 = DatatypeConverter.printBase64Binary(Files.readAllBytes(
                    Paths.get(fileName)));
        } catch (IOException e) {
            logger.error("[VaVedem] Eroare la conversia in base64 a fisierului: " + fileName);
            throw new VaVedemEmailException("Eroare la trimiterea emailului.");
        }

        Attachments ats = new Attachments();
        ats.setContent(base64);
        ats.setFilename(formular);

        mail.addAttachments(ats);

        SendGrid sg = new SendGrid(sendGridApiKey);
        System.out.println("LOG [VaVedem] :  send grid api-key: " + sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new VaVedemEmailException("Eroare la trimiterea emailului.");
        }
    }


    private static Map<String, String> listFormulare(String directory) {
        Map<String, String> files = new HashMap<String, String>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {

                files.put(path.getFileName().toString(), path.toAbsolutePath().toString());
                System.out.println(path.toAbsolutePath().toString());
            }
        } catch (IOException ex) {}
        return files;
    }

}
