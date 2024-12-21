package com.hello.hello_spring;

import com.hello.hello_spring.repository.*;
//import com.hello.hello_spring.repository.JdbcTemplateMemberRepository;
import com.hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

	private EntityManager em;

	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}

	//	private DataSource dataSource;
//
//	@Autowired
//	public SpringConfig(DataSource dataSource){
//		this.dataSource = dataSource;
//	}

	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository(){

		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(em);
	}
}
