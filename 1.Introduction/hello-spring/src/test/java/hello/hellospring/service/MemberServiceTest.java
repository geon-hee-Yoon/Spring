package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() { //테스트는 한글로 써도됨
        //정상 플로우
        //given
        Member member=new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    //예외 플로우
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1=new Member();
        member1.setName("spring");

        Member member2=new Member();
        member2.setName("spring");

        //when
        /*
        memberService.join(member1);    //이름:spring
        memberService.join(member2);    //이름:spring 똑같으므로 본클래스의 join안에 중복회원검증 기능에 걸려서 예외터짐
        */
        memberService.join(member1);
        IllegalStateException e= assertThrows(IllegalStateException.class, () -> memberService.join(member2));  // 어떤 로직()을 태울때 ->로 감, 예외터짐
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*예외처리 방법1(애매함)                     ()->... 부를 실행할건데 좌측 IllegalStateException이 터져야함, 널포인터 예외 등 테스터 실패하기도 함
        try{
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");

        }catch(IllegalStateException e){    //exception이 터지면 catch부로 오기때문에 딱히 뭘 안해도 됨
            org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}