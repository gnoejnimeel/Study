package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberMemoryRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정정보, 구성정보
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        //생성자를 통해서 주입
        return new MemberServiceImpl(memoryRepository());
        //스프링 컨테이너에 등록되며 등록된 객체를 스프링빈이라고 한다.
    }

    //중복 Ctrl + Alt + M
    @Bean
    public static MemberMemoryRepository memoryRepository() {
        return new MemberMemoryRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
