// 순환 의존성 테스트

package com.mycompany.mvcproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    
    @Autowired
    private ServiceB serviceB; // 필드 주입
    
    @Autowired
    public ServiceA(ServiceB serviceB) { // 생성자 주입
        this.serviceB = serviceB;
    }
    
    @Autowired
    public void setServiceB(ServiceB serviceB) { // 세터 주입
        this.serviceB = serviceB;
    }

    public void methodA(){
        System.out.println("method in ServiceA");
        serviceB.methodB();
    }
}

// 순환 의존성을 피하기 위해서는 한 클래스를 필드 주입하면 된다.
// 필드주입하면 생성자 주입보다 늦게 적용이 되기 때문에 순환 의존성을 피할 수 있다.
// (하지만 일반적으로는 생성자 주입)

// 혹은 @Lazy라는 annotation을 생성자의 인수에 넣으면 지연 초기화 되어 순환 의존성을 피할 수 있다.

// 물론 이런 구조를 안짜는게 가장 이상적이다. 프로그램이 커지다가 이런 일이 생길 경우에 사용하는 방법.