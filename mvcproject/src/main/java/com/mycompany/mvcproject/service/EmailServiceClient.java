package com.mycompany.mvcproject.service;

import com.mycompany.mvcproject.domain.SendEmailRequest;
import org.springframework.stereotype.Service;

@Service  // 스프링이 관리하는 서비스 Bean으로 등록.
public class EmailServiceClient {



    public void sendEmail(SendEmailRequest request){
        // 실제 이메일 발송 로직은 여기서 작성한다고 가정.

        System.out.println("Sending email to : " + request.getToAddress());
        System.out.println("Subject : " + request.getSubject());
        System.out.println("Body : " + request.getBody());
        // 이메일 발송 성공 시 추가적인 로직도 작성 가능.
    }
}
