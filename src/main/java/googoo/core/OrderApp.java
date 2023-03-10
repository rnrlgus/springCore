package googoo.core;

import googoo.core.member.Grade;
import googoo.core.member.Member;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;
import googoo.core.order.Order;
import googoo.core.order.OrderService;
import googoo.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "구기현", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatedPrice() = " + order.calculatedPrice());
    }
}
