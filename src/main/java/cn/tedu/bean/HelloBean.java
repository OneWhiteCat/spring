package cn.tedu.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component("test")
public class HelloBean implements Serializable {
    @Override
    public String toString() {
        return "HelloBean";
    }
}
