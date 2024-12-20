package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {
    @Test
    void xmlAppContext(){
        ApplicationContext ac = new GenericApplicationContext("appConfig.xml");

        MemberService memberService = (MemberService) ac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
