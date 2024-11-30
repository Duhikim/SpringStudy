package com.mycompany.mvcproject.domain;

import com.mycompany.mvcproject.service.EmailServiceClient;

public class SendEmailRequest {
    private String toAddress;
    private String subject;
    private String body;

    public SendEmailRequest() {}
    public SendEmailRequest(String toAddress, String subject, String body) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.body = body;
    }

    public String getToAddress() {
        return toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
