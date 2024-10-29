package StepDefinitions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailreportMainMethod {
	static String exporthtmlEmailPath = null;
	static String exportpdfEmailPath = null;
//	static StringBuilder html = new StringBuilder();

	public static void main(String[] args)  {
		   
		 try {
			 
			 SimpleDateFormat formateDate=new SimpleDateFormat("ddMMMyyyy HH:mm:ss");
			 Date date=new Date();
			 String datesystem = formateDate.format(date);
			 
	            System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	            //SimpleEmail email = new SimpleEmail();
	            MultiPartEmail email = new MultiPartEmail();
	            email.setHostName("smtp.googlemail.com");
	            email.setSmtpPort(587);
	            email.setAuthenticator(new DefaultAuthenticator("digambar.karande@vernost.com", "zgyc ubcy fmnq wxxf"));
	            email.setStartTLSEnabled(true);
	            email.setFrom("digambar.karande@vernost.com");
	            email.setSubject(" DBTravel UAT : Automation Testing Report "+datesystem+"( Flight & Hotel) ");
	            email.setMsg("This is a test mail ... :-)");
	            email.addTo("digambar.karande@vernost.com");
	            email.addTo("ansari.wasi@vernost.com");				
	            email.addTo("devendra.patil@vernost.com");				
	            email.addTo("puja.gupta@vernost.com");
	            email.addTo("kuldeep.ruletiya@vernost.com");
	            email.addTo("sanket.dhamale@vernost.com");
	          			
	            
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(System.getProperty("user.dir")+"\\test-output\\SparkReport\\Index.html");
				attachment.setDisposition(EmailAttachment.ATTACHMENT);

				
				EmailAttachment attachment1 = new EmailAttachment();
				attachment1.setPath(System.getProperty("user.dir")+"\\test output\\PdfReport\\ExtentPdf.pdf");
				attachment1.setDisposition(EmailAttachment.ATTACHMENT);

				//sanket.dhamale@vernost.in
				    
				email.attach(attachment);
				email.attach(attachment1);
	            email.send();

	            System.out.println("Email sent successfully.");

	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	    }

	public static String getHtmlEmailPath() {
		String fileSeparator = FileSystems.getDefault().getSeparator();

		System.out.println(System.getProperty("os.name"));
		switch (System.getProperty("os.name")) {
		case "Linux":
			exporthtmlEmailPath = "/test-output/SparkReport/";
			break;
		case "Windows":
			exporthtmlEmailPath = "\\test-output\\SparkReport\\";
			break;
		case "Mac":
			exporthtmlEmailPath = "/test-output/SparkReport/";
			break;
		}
		return exporthtmlEmailPath;

	}

	public static String getPdfEmailPath() {
		String fileSeparator = FileSystems.getDefault().getSeparator();

		System.out.println(System.getProperty("os.name"));
		switch (System.getProperty("os.name")) {
		case "Linux":
			exportpdfEmailPath = "/test output/PdfReport/";
			break;
		case "Windows":
			exportpdfEmailPath = "\\test output\\PdfReport\\";
			break;
		case "Mac":
			exportpdfEmailPath = "/test output/PdfReport/";
			break;
		}
		return exportpdfEmailPath;

	}

}
