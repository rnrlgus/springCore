package googoo.core;

import googoo.core.discount.FixDiscountPolicy;
import googoo.core.discount.RateDiscountPolicy;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;
import googoo.core.member.MemoryMemberRepository;
import googoo.core.order.OrderService;
import googoo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
