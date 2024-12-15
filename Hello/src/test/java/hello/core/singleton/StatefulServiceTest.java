package hello.core.singleton;

import hello.core.beanfind.ApplicationContextExtendsFindTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationContextExtendsFindTest.TestConfig.class);

        StatefulService service1 = ac.getBean(StatefulService.class);
        StatefulService service2 = ac.getBean(StatefulService.class);

        service1.order(10000);
        service2.order(20000);

        int price = service1.getPrice();
        System.out.println(price);

        //assertThat(service1.getPrice()).isEqulalTo(20000);
        assertThat(service1.getPrice()).isEqualTo(service2.getPrice());
    }

    @Configuration
    static class TestConfig_{
        @Bean
        puiblic StatefulService statefulService(){
            return new StatefulService();
        }
    }

}