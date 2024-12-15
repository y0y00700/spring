package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {
//    public static void main(String[] args) {
//        // 불가능한 호출
//        SingletonService singleton = new SingletonService();
//        SingletonService singleton2 = new SingletonService();
//    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonService(){
        // 불가능한 객체 생성
        // new SingletonService();
        SingletonService ss1 = SingletonService.getInstance();
        SingletonService ss2 = SingletonService.getInstance();

        assertThat(ss1).isSameAs(ss2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//      AppConfig ac = new AppConfig(); -> appConfig 대신, ApplicationContext 를 통한 Spirng Container 사용
        ApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        assertThat(memberService1).isSameAs(memberService2);
    }

}
