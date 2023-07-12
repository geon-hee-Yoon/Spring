package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();//인터페이스형에 할당 안해주면(구현체없이) NullPointerException 발생

    @Override
    public void join(Member member) {
        memberRepository.save(member); //다형성에 의해  MemoryMemberRepository에 있는 save(Override한거)가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
