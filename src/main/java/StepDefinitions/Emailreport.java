package StepDefinitions;

import java.text.SimpleDateFormat; // Used for formatting date and time
import java.util.Date; // Used to get the current system date and time
import org.apache.commons.mail.DefaultAuthenticator; // Authenticates email server credentials
import org.apache.commons.mail.EmailAttachment; // Used to attach files to an email
import org.apache.commons.mail.EmailException; // Handles exceptions during email sending
import org.apache.commons.mail.MultiPartEmail; // Used to create and send an email with attachments

import Baseclass.Baseclass; // Imports Baseclass for shared resources

// Emailreport class extends Baseclass to access WebDriver and shared properties
public class Emailreport extends Baseclass {

	// Method to configure and send an email with the test report
	public void mail() throws Exception {

		try {
			// Set the date and time format for the email subject
			SimpleDateFormat formateDate = new SimpleDateFormat("ddMMMyyyy HH:mm:ss");
			Date date = new Date(); // Get the current system date and time
			String datesystem = formateDate.format(date); // Convert date to the specified format

			// Set mail system properties to use TLSv1.2
			System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

			// MultiPartEmail allows sending an email with attachments
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.googlemail.com"); // SMTP server for sending emails via Gmail
			email.setSmtpPort(587); // Port for secure SMTP communication

			// Set the email authenticator with sender's credentials
			email.setAuthenticator(new DefaultAuthenticator("digambar.karande@vernost.com", "zgyc ubcy fmnq wxxf"));

			// Enable TLS for secure email sending
			email.setStartTLSEnabled(true);

			// Set the email's sender address
			email.setFrom("digambar.karande@vernost.com");

			// Set the subject of the email, appending the current date and time
			email.setSubject("DBTrave_All: Automation Testing Report " + datesystem + "( Flight & Hotel)");

			// Set the body message of the email
			email.setMsg("This is a test mail ... :-)");

			// Add recipients to the email (multiple people will receive it)
			email.addTo("digambar.karande@vernost.com");
			email.addTo("ansari.wasi@vernost.com");
			email.addTo("devendra.patil@vernost.com");
			email.addTo("puja.gupta@vernost.com");
			email.addTo("kuldeep.ruletiya@vernost.com");
			email.addTo("sanket.dhamale@vernost.com");

			// Create the first attachment (HTML report) for the email
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(System.getProperty("user.dir") + "\\test-output\\SparkReport\\Index.html"); // Path to HTML report
			attachment.setDisposition(EmailAttachment.ATTACHMENT); // Indicates that it's an attachment

			// Create the second attachment (PDF report) for the email
			EmailAttachment attachment1 = new EmailAttachment();
			attachment1.setPath(System.getProperty("user.dir") + "\\test output\\PdfReport\\ExtentPdf.pdf"); // Path to PDF report
			attachment1.setDisposition(EmailAttachment.ATTACHMENT); // Indicates that it's an attachment

			// Attach both files (HTML and PDF reports) to the email
			email.attach(attachment);
			email.attach(attachment1);

			// Send the email
			email.send();

			// Confirmation message when email is successfully sent
			System.out.println("Email sent successfully.");

		} catch (EmailException e) {
			// Print the stack trace in case of an email sending failure
			e.printStackTrace();
		}
	}
}
