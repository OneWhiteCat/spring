package cn.tedu.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Component
public class ExampleBean implements Serializable {
    @Override
    public String toString() {
        return "ExampleBean";
    }
}
