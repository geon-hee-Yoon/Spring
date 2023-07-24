package hello.core.member;

public interface MemberService { //회원서비스

    void join(Member member); //회원가입

    Member findMember(Long memberId); //회원조회
    //요구사항 만족
}
