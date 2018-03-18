package by.myself.config;

import by.myself.aspects.LoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "by.myself.service")
public class AspectsConfig {

    @Bean
    public LoggerAspect logger (){
        return new LoggerAspect();
    }
}
