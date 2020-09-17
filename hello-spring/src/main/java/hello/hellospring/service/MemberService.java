package hello.hellospring.service;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {  //(클래스명 범위 잡고) 컨트롤 + 시프트 + t  -> 테스트 케이스 만들기
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())  //findByName은 이미 Optional의 멤버이 므로 바로 ifPresent로 반환
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {

        return memberRepository.findById(memberId);
    }
}