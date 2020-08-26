package com.littlebuddha.community.lambda.data;

public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("Person类的无参构造被调用");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person类的有参构造被调用");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
