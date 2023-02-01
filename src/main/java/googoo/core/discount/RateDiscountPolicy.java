package googoo.core.discount;

import googoo.core.member.Grade;
import googoo.core.member.Member;
import googoo.core.order.OrderService;
import googoo.core.order.OrderServiceImpl;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * 10 / 100;
        }
        return 0;
    }
}
