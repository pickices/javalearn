package com.liuxinchi.springboot02config.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "people")
@Validated
public class People {
    private String name;
    private int age;
    private boolean happy;
    private List<String> hobby;
    private Map<String, String> map;
    private Date date;

    private Dog dog;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", hobby=" + hobby +
                ", map=" + map +
                ", date=" + date +
                ", dog=" + dog +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHappy(boolean happy) {
        this.happy = happy;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public People() {
    }

    public People(String name, int age, boolean happy, List<String> hobby, Map<String, String> map, Date date, Dog dog) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.hobby = hobby;
        this.map = map;
        this.date = date;
        this.dog = dog;
    }
}
