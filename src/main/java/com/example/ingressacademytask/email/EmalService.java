package com.example.ingressacademytask.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmalService {
  public static void sendMail(String message, List<String > emailList){
      Email email = new SimpleEmail();
      email.setHostName("smtp.gmail.com");
      email.setSmtpPort(465);
      email.setAuthenticator(new DefaultAuthenticator("ingresstask2@gmail.com","byug srsz renb suvv"));
      email.setSSLOnConnect(true);
      try {
          email.setFrom("ingresstask2@gmail.com");
          for(String emails : emailList){
          email.addTo(emails);
          }

          email.setSubject("New Book Added");

          email.setMsg(message);
          email.send();
      } catch (EmailException e) {
          throw new RuntimeException(e);
      }


  }
}
