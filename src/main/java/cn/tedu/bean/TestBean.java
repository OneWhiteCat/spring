package cn.tedu.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class TestBean implements Serializable {
    @Override
    public String toString() {
        return "Test Bean";
    }
}
