package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given : 이런 환경이 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);
        //join 해야되는데 MemberService 없으므로 MemberService 만듬
        
        //when : 이렇게 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then : 이렇게 된다(검증)
        Assertions.assertThat(member).isEqualTo(findMember); //assertj.core의 Assertions
    }
}
