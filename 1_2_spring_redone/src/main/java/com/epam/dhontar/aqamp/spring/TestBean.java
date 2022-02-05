package com.epam.dhontar.aqamp.spring;

public class TestBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBean(String name) {
        this.name = name;
    }
}
