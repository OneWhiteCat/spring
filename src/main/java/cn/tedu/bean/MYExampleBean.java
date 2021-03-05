package cn.tedu.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MYExampleBean implements Serializable {
    @Override
    public String toString() {
        return "ExampleBean";
    }
}
