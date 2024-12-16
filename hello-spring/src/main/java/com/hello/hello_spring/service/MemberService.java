package com.hello.hello_spring.service;

import com.hello.hello_spring.domain.Member;
import com.hello.hello_spring.repository.MemberRepository;
import com.hello.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

	private final MemberRepository memberRepository = new MemoryMemberRepository();

	//회원 가입
	public Long join(Member member){

		validateDuplicateMember(member); // 중복 회원 검증

// 위 코드랑 똑같은 코드
//		Optional<Member> result = memberRepository.findById(member.getId());
//		result.ifPresent(m->{
//			throw new IllegalStateException("이미 존재하는 회원입니다.");
//		});

		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}
	//전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}

}
