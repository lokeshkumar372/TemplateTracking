package com;

import java.io.IOException;
import java.util.Properties;
import java.util.function.Supplier;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bean.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value="/Create",loadOnStartup=1)
public class CreateUser extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		boolean ans = false;
		String email = req.getParameter("user_email");
		
		String Username = email.substring(0,email.indexOf("@"));
		
		Users u = new Users();
		Supplier<Integer> s = ()-> ((int)Math.random());
		u.setPassword(Username+s.get());
		u.setuser_email(email);
		u.setUser_name(Username);
		String role = req.getParameter("role");
		u.setRole(role);
		
		DataOperations r = new DataOperations();
		try {
		 r.createUser(u);
		 sendEmail(u);
		 res.sendRedirect("jsp/success.jsp");
		}catch(Exception e) {
			
			req.setAttribute("error", Error.returnEmailAlreadyExists());
			rd = req.getRequestDispatcher("jsp/createUser.jsp?role="+role);
			rd.include(req, res);
		}
	}
	
	public static void sendEmail(Users u) {
		String to = u.getuser_email();
        // Sender's email ID needs to be mentioned
        String from = "templatetracking@gmail.com";
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("templatetracking@gmail.com", "wrisyunpmlljxuih");
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Your login credentials");
            // Now set the actual message
            message.setText("Log in with this password : " + u.getPassword() + "\n" + "And Username is your email id");
//            System.out.println("sending...");
            // Send message
            Transport.send(message);
//            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}

}
