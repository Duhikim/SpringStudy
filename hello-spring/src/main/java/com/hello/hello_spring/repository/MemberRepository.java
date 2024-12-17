package com.hello.hello_spring.repository;

import com.hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id); // Optional이란? null 나올 수 있는 경우 쓰는 Java 8 기능
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
