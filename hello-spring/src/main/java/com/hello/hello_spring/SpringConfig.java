package com.hello.hello_spring;

import com.hello.hello_spring.repository.JdbcMemberRepository;
//import com.hello.hello_spring.repository.JdbcTemplateMemberRepository;
import com.hello.hello_spring.repository.MemberRepository;
import com.hello.hello_spring.repository.MemoryMemberRepository;
import com.hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class SpringConfig {
	private DataSource dataSource;

	@Autowired
	public SpringConfig(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository(){

		//return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
	}
}
