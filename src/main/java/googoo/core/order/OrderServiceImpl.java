package googoo.core.order;

import googoo.core.discount.DiscountPolicy;
import googoo.core.member.Member;
import googoo.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // final이 붙으면 생성자를 통해 초기화를 하던가 명시적으로 초기화를 해줘야 함.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
