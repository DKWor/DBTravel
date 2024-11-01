package step_definitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseclass.Baseclass;

// emailreport class is responsible for sending automated test reports via email
public class EmailReport extends Baseclass {

    // Logger instance to log information and errors
    private static final Logger logger = LogManager.getLogger(EmailReport.class);
    
    // Constant for sender email address to avoid duplication
    private static final String SENDER_EMAIL = "digambar.karande@vernost.com";

    // Method to configure and send an email with the test report
    public void mail() throws EmailException {
        try {
            // Set up date format for email subject to include the current timestamp
            SimpleDateFormat formatDate = new SimpleDateFormat("ddMMMyyyy HH:mm:ss");
            Date date = new Date();
            String datesystem = formatDate.format(date);

            // Set the mail system property to use TLS v1.2 protocol for secure email communication
            System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

            // Create MultiPartEmail instance to handle the email with attachments
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.googlemail.com"); // Gmail's SMTP server
            email.setSmtpPort(587); // Port for TLS-enabled SMTP

            // Set the email authentication credentials for the sender's email account
            email.setAuthenticator(new DefaultAuthenticator(SENDER_EMAIL, "zgyc ubcy fmnq wxxf"));
            email.setStartTLSEnabled(true); // Enable TLS for email security

            // Set sender email address and email subject, including the current timestamp
            email.setFrom(SENDER_EMAIL);
            email.setSubject("DBTrave_All: Automation Testing Report " + datesystem + "( Flight & Hotel)");

            // Set the email message body
            email.setMsg("This is a test mail ... :-)");

            // Add recipient email addresses for report distribution
            email.addTo(SENDER_EMAIL);
            email.addTo("ansari.wasi@vernost.com");
            email.addTo("devendra.patil@vernost.com");
            email.addTo("puja.gupta@vernost.com");
            email.addTo("kuldeep.ruletiya@vernost.com");
            email.addTo("sanket.dhamale@vernost.com");

            // Attach HTML report file to the email
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(System.getProperty("user.dir") + "\\test-output\\SparkReport\\Index.html"); // Path to HTML report
            attachment.setDisposition(EmailAttachment.ATTACHMENT); // Mark as attachment

            // Attach PDF report file to the email
            EmailAttachment attachment1 = new EmailAttachment();
            attachment1.setPath(System.getProperty("user.dir") + "\\test output\\PdfReport\\ExtentPdf.pdf"); // Path to PDF report
            attachment1.setDisposition(EmailAttachment.ATTACHMENT); // Mark as attachment

            // Attach both HTML and PDF reports to the email
            email.attach(attachment);
            email.attach(attachment1);

            // Send the email and log the success
            email.send();
            logger.info("Email sent successfully.");

        } catch (EmailException e) {
            // Log error and throw custom EmailSendingException in case of email sending failure
            logger.error("Failed to send email with the test report.", e);
            throw new EmailException("Failed to send email with the test report.", e);
        }
    }
}
