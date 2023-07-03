package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired //생성자 하나라 생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//@Autowired DataSource dataSource;
        //or
   /* EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/
/*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    /*@Bean
    public MemberRepository memberRepository(){
       // return new JdbcMemberRepository(dataSource);
        //or
        // return new MemoryMemberRepository();

        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }*/
   /* @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/
}
