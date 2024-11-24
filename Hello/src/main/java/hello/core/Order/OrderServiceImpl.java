package hello.core.Order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    //private MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository ;
    //private DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy; // 구체 클래스가 아닌 추상화에 의존하도록 변경한 코드(주입)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
