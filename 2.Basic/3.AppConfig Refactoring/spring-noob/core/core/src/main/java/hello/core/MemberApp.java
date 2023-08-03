package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) { //psvm 치면 자동으로 main메소드 생성
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
            // MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP); //id가 Long타입이어서 1뒤에 L붙임
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName()); //soutv
        System.out.println("findMember = " + findMember.getName());


    }
}
