package googoo.core;

import googoo.core.discount.DiscountPolicy;
import googoo.core.discount.FixDiscountPolicy;
import googoo.core.discount.RateDiscountPolicy;
import googoo.core.member.MemberRepository;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;
import googoo.core.member.MemoryMemberRepository;
import googoo.core.order.OrderService;
import googoo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
