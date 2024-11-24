package hello.core.discount;

import hello.core.Order.OrderService;
import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int percentRate = 10;

    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){
            return price * percentRate/100;
        }else{
            return 0;
        }
    }
}
