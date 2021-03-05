package cn.tedu.spring;

import cn.tedu.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        /**
         * 测试Spring可以创建管理对象(IOC)
         * Annotation  注解
         * Config  配置
         * Application  应用程序
         * Context  上下文
         * 创建AnnotationConfigApplicationContext 对象时
         * 必须提供配置类的类名 Config.class!
         */
        AnnotationConfigApplicationContext acac=
                new AnnotationConfigApplicationContext(Config.class);
        //Spring 提供了getBean方法，参数是类型,返回值是Spring创建的对象
//        DemoBean demoBean= acac.getBean(DemoBean.class);
//        //检查对象,输出对象，自动调用toString()
//        System.out.println(demoBean);

        //当按照类型获取对象有冲突时，就按照ID获取对象
        DemoBean demoBean1= acac.getBean("demoBean1",DemoBean.class);
        System.out.println(demoBean1);

    }
}
