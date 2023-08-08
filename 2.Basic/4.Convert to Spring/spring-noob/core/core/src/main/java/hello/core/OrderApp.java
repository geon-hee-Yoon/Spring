package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp { 
    public static void main(String[] args) { //main메소드로 하는것보다 테스트로 하는게 낫다
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        //OrderService orderService =appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);//getBean = @Bean 가져와! -> memberService라는 이름의 MemberService 타입이라고 알려줘서 가져옴
        OrderService orderService=applicationContext.getBean("orderService", OrderService.class); //AppConfig의 orderService 메소드(new OrderServiceImpl) 나옴

        //멤버 먼저 저장
        Long memberId=1L;
        Member member=new Member(memberId, "memberA", Grade.VIP);//VIP회원 하나 만듬
        memberService.join(member); //멤버 서비스를 통해 메모리 객체에 넣어놓음. 그래야 주문해서 찾아쓸수있음

        Order order=orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice()); //9000

    }
}
