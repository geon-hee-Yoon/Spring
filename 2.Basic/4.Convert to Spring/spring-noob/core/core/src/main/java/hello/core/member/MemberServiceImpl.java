package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //배우가 직접 담당 배우 섭외하는것과 같다 (new MemoryMemberRepository()는 MemberServiceImpl이 해준것)
    private final MemberRepository memberRepository; //= new MemoryMemberRepository();//인터페이스형에 할당 안해주면(구현체없이) NullPointerException 발생/ 실제 할당 부분이 구현체 의존 즉, 추상화 구체화 둘다에 의존(DIP위반)

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //MemberRepository의 구현체가 뭘 들어갈지를 생성자를 통해 결정 -> AppConfig에서 new MemorymemberRepository 하려고 바꿈)
    //so, 구체적인것(어떤 구현 객체가 올 지) 전혀 모름->추상화에만 의존
    
    @Override
    public void join(Member member) {
        memberRepository.save(member); //다형성에 의해  MemoryMemberRepository에 있는 save(Override한거)가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
