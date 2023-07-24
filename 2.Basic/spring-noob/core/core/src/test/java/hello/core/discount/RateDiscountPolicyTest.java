package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.") //한글로 이름 쓸 수 있게(JUnit5)
    void vip_o(){ //성공시(vip일시)
        //given : 임의의 멤버 하나 만듬
        Member member = new Member(1L, "nameVIP", Grade.VIP);
        //when : 10,000원 짜리
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000); //1000원 할인 적용되어야 하므로

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){ //실패시(vip 아닐시)
        //given : 임의의 멤버 하나 만듬
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when : 10,000원 짜리
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0); //할인 적용x여야 하므로 0
    }
    //Assertions위에서 alt + enter로 on demand로 간결하게 해주는게 좋다:assertThat으로만 사용가능

}