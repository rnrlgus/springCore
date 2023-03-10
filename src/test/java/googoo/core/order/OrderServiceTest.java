package googoo.core.order;

import googoo.core.AppConfig;
import googoo.core.member.Grade;
import googoo.core.member.Member;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

//        Order order2 = orderService.createOrder(memberId, "itemB", 20000);
//        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(2000);
    }
}
