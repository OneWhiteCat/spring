package cn.tedu.config;

import cn.tedu.spring.DemoBean;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Configuration Spring提供的注解,用于标注在Spring配置类上
 * 表示当前类作为Spring的配置文件，其中可以声明Spring中创建的对象
 */
@Configuration
/**
 * @ComponentScan("cn.tedu.bean") 开启组件扫描
 * Spring 启动后会自动扫描cn.tedu.bean 包和其子包中类
 * 如果类上标注了@Component 就会在Soring中创建该类型的对象
 */
@ComponentScan("cn.tedu.bean")
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
    @Scope("prototype")//多次调用,按照多个实例管理对象
    public DemoBean demoBean1(){
        return new DemoBean();
    }

    /**
     * 利用Spring管理数据库
     * @return
     */
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
//        dataSource.setDriverClassName();
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

}
