package cn.tedu.config;

import cn.tedu.spring.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration Spring提供的注解,用于标注在Spring配置类上
 * 表示当前类作为Spring的配置文件，其中可以声明Spring中创建的对象
 */
@Configuration
public class Config {
    /**
     * @Bean Spring提供的注解,标注在创建对象的方法上
     * Spring启动时，会自动寻找 配置类中标注了@Bean注解的方法
     * 找到以后会执行方法创建对象，
     * 方法必须创建一个新对象，公用方法，方法名随意
     * @return
     */
    @Bean
    public DemoBean demoBean(){
        return new DemoBean();
    }
    //常见对象的方法名，就是对象分配的唯一 BeanID
    @Bean
    public DemoBean demoBean1(){
        return new DemoBean();
    }

}
