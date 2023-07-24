package hello.core.member;

public interface MemberRepository { //회원 저장소
    void save(Member member);

    Member findById(Long memberId);
}
