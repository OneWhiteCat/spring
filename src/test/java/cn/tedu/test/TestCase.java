package cn.tedu.test;

import cn.tedu.config.Config;
import cn.tedu.spring.DemoBean;
import org.junit.After;
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
     * 用来初始化
     */
    @Before
    public void init(){
        acac=new AnnotationConfigApplicationContext(Config.class);
    }
    /**
     * 被测试的方法要标注@Test
     * 测试方法必须是公有 无返回值 无参数
     */
    /**
     * After 在xxx之后,JUnit中@After注解的作用是在测试案例之后执行
     * 回收创建的资源
     * destroy:销毁
     */
    @After
    public void destroy(){
        //Spring提供了关闭Spring的方法,释放Spring中的对象
        acac.close();
        System.out.println("释放资源");
    }

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
    @Test
    public void testSingle(){
        /**
         * 测试:Spring默认情况下,javaBean是单例的，多次getBean返回的对象是同一个
         */
        DemoBean demoBean1=acac.getBean("demoBean",DemoBean.class);
        DemoBean demoBean2=acac.getBean("demoBean",DemoBean.class);
        DemoBean demoBean3=acac.getBean("demoBean",DemoBean.class);
        System.out.println(demoBean1==demoBean2);
        System.out.println(demoBean1==demoBean3);
    }
    @Test
    public void testPrototype(){
        /**
         * 在测试文件中添加了@Scope("prototype")就会创建多个实例
         */
        DemoBean demoBean1=acac.getBean("demoBean1",DemoBean.class);
        DemoBean demoBean2=acac.getBean("demoBean1",DemoBean.class);
        DemoBean demoBean3=acac.getBean("demoBean1",DemoBean.class);
        System.out.println(demoBean1==demoBean2);
        System.out.println(demoBean1==demoBean3);
    }


}
