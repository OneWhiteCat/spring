package cn.tedu.test;

import cn.tedu.config.Config;
import cn.tedu.spring.DemoBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * test: 测试
 * case:案例
 * 测试案例类必须是共有类!!!
 */
public class TestCase {
    private AnnotationConfigApplicationContext acac;
    /**
     * 在xx之前,JUnit提供的@Before标注的方法在测试案例之前执行
     */
    @Before
    public void init(){
        acac=new AnnotationConfigApplicationContext(Config.class);
    }
    /**
     * 被测试的方法要标注@Test
     * 测试方法必须是公有 无返回值 无参数
     */
    @Test
    public void hello(){
        System.out.println("Hello World");
    }
    /**
     * 测试一下，如果Spring中相同类型的对象有一个以上时,
     */
    @Test
    public void testGetBean(){
        DemoBean demoBean=acac.getBean(DemoBean.class);
        System.out.println(demoBean);
    }
    /**
     * 单独测试，按照ID
     */
    @Test
    public void testGetBeanID(){
        DemoBean demoBean=acac.getBean("demoBean",DemoBean.class);
        System.out.println(demoBean);
    }
    @Test
    public void testBeanId(){
        String[]  names=acac.getBeanNamesForType(DemoBean.class);//按类型获取所有BeanID
        for(String name:names){
            System.out.println(name);
        }
    }

}
