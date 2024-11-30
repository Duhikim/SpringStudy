package com.mycompany.mvcproject.controller;

import com.mycompany.mvcproject.service.EmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Component나 @Controller 등의 annotation으로 등록하면 Bean으로 인식됨. Bean XML 직접 등록 안해도 됨.
@RequestMapping("/email")
public class EmailController {

    // 필드 주입
    // @Autowired
    // private EmailServiceClient emailServiceClient;

    private final EmailServiceClient emailServiceClient;

    // 세터 주입
    //@Autowired
    //public void setEmailServiceClient(EmailServiceClient emailServiceClient) {
    //    this.emailServiceClient = emailServiceClient;
    //}

    //생성자 주입 (권장)
    @Autowired
    public EmailController(EmailServiceClient emailServiceClient) {
        this.emailServiceClient = emailServiceClient;
    }

    // http://localhost:8080/email/sendEmail
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail() {
        // EmailServiceClientceClient emailServiceClient = new EmailServiceClient(); // 이런 방법은 Spring에서 원하는바가 아님.

        SendEmailRequest sendEmailRequest = generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);

        return "Seccess";
    }

    public SendEmailRequest generateEmailRequest() {
        // 간단한 이메일 요청 객체 생성
        SendEmailRequest request = new SendEmailRequest;
        request.setToAddress("test@exmaple.com");
        request.setSubject("test subject");
        request.setBody("This is a test email");
    }
}
