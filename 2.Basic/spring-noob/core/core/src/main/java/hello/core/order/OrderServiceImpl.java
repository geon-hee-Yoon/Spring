package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //주문서비스는 2개가 필요
    private final MemberRepository memberRepository=new MemoryMemberRepository(); //회원 저장소에서 회원 찾아야 하므로
    //수업자료 3.스프링 핵심 원리 이해2 참조
    private DiscountPolicy discountPolicy; //final은 반드시 값을 할당해야함. 인터페이스에만 의존->DIP위반 해결처럼 보이나 but NullPointException발생 
    //private final DiscountPolicy discountPolicy=new FixDiscountPolicy(); //DIP 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //+OCP 위반

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //순서대로 2.회원조회 3.할인적용
        Member member=memberRepository.findById(memberId); //회원조회(멤버찾기)
        int discountPrice=discountPolicy.discount(member,itemPrice); //할인 정책에 회원 넘김,itemPrice 넘김ㄴ
        
        //설계 잘됨
        //OrderService 입장에선 할인에 대해 모름. 할인에 대해선 DiscountPolicy 니가 알아서 해줘 결과만던져줘~ = 단일책임원칙 잘지킴
        return new Order(memberId, itemName, itemPrice, discountPrice);//최종생성된 주문 반환
    }

}
