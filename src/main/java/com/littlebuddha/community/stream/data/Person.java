package com.littlebuddha.community.stream.data;

public class Person {

    private String name;
    private int age;
    private Double score;
    private String subject;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public Person setScore(Double score) {
        this.score = score;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Person setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Person() {
        System.out.println("无参执行");
    }

    public Person(String name, int age, Double score,String subject) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.subject = subject;
        System.out.println("有参执行");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", subject=" + subject +
                '}';
    }
}
