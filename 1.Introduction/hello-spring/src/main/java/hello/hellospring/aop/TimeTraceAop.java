package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //스프링 빈으로 등록 가능하지만 SpringConfig에서 @Bean으로 하는걸 더 선호
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") //패키지 하위에 다 적용해라
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            Object result = joinPoint.proceed(); //다음 메소드로 진행
            return result; //ctrl alt shift T 로 inline 해줘도 됨
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");

        }
    }
}
