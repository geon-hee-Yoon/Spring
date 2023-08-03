package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp { 
    public static void main(String[] args) { //main메소드로 하는것보다 테스트로 하는게 낫다
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService =appConfig.orderService();
            //MemberService memberService = new MemberServiceImpl();
            //OrderService orderService = new OrderServiceImpl();
        
        //멤버 먼저 저장
        Long memberId=1L;
        Member member=new Member(memberId, "memberA", Grade.VIP);//VIP회원 하나 만듬
        memberService.join(member); //멤버 서비스를 통해 메모리 객체에 넣어놓음. 그래야 주문해서 찾아쓸수있음

        Order order=orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice()); //9000

    }
}
