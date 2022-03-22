package third_homework;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {

    @Bean
    @Profile("test")
    public IProfile getTestBean() {
        return new TestBean();
    }

    @Bean
    @Profile("dev")
    public IProfile getDevBean() {
        return new DevBean();
    }

    @Bean
    @Profile("prod")
    @ConditionalOnProperty(
            value = "prod.spring.env",
            havingValue = "default",
            matchIfMissing = true
    )
    public IProfile getProdBean() {
        return new ProdBean();
    }

    @Bean
    @ConditionalOnBean(TestBean.class)
    public DependsBean getDependsBean() {
        return new DependsBean();
    }
}
