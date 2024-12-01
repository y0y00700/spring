package hello.core.beanfind;

import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memeberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService: " + memeberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByName(){
        MemberService memeberService = ac.getBean(MemberService.class);
        System.out.println("memberService: " + memeberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // 아래는 동일 클래스 일치하지 않을 때 찾는 코드
//        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
//                () -> ac.getBean("xxxxx",MemberService.class),() -> MemberService.class);
    }
}
