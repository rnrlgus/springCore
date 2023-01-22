package googoo.core.order;

import googoo.core.discount.DiscountPolicy;
import googoo.core.discount.FixDiscountPolicy;
import googoo.core.member.Member;
import googoo.core.member.MemberRepository;
import googoo.core.member.MemoryMemberRepositoryImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepositoryImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
