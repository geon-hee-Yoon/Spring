package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//공연기획자 - 배우가 상대배역 섭외하는것 방지
public class AppConfig { //애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
    public MemberService memberService(){
        //return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입(new해서 MMR 객체를 생성해서 참조값을 MemberServiceImpl에 넣어줌)
        return new MemberServiceImpl(memberRepository()); //밑에 orderService에서 new MemoryMemberRepository 두번나옴) ctrl alt m으로 리팩토링
    }

    private static MemoryMemberRepository memberRepository() { //나중에 db로 바꾸려면 여기 코드만 바꾸면 됨
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //MemoryMemberRepository,FixDiscountPolicy 객체 들어옴
                                    //생성자 주입(new , new 였을때)
    
    }
    public DiscountPolicy discountPolicy(){ //메서드 보는 순간 역할이 드러남.
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
