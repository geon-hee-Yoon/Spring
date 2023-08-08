package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) { //psvm 치면 자동으로 main메소드 생성
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //스프링 생성:스프링은 모든게 이거로 시작 => 이게 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //파라미터ㅏ AppConfig.class 이므로 AppConfig 안의 메서드(@Bean)을 다 스프링 컨테이너에 객체 생성하널 다 넣어서 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//줄여서 ac로도 가능. 이름은 AppConfig의 메소드와 이름이 같아야하므로 memberService. (이름,타입)

        Member member = new Member(1L, "memberA", Grade.VIP); //id가 Long타입이어서 1뒤에 L붙임
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName()); //soutv
        System.out.println("findMember = " + findMember.getName());


    }
}
