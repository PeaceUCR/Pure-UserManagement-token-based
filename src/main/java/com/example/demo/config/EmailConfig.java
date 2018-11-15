package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    /*
    //https://www.logicbig.com/tutorials/spring-framework/spring-core/inject-bean-by-name.html
    //auto wire with multiple beans with name and qualifier
    //https://stackoverflow.com/questions/2016190/how-to-configure-spring-javamailsenderimpl-for-gmail
    //https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
    */
    @Bean(name = "serviceMailSender")
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        mailSender.setJavaMailProperties(props);

        mailSender.setUsername("peacetestmsg@gmail.com");
        mailSender.setPassword("heping1991");

        return mailSender;
    }

}
