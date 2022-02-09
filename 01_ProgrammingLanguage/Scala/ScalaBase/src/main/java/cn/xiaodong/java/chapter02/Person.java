package cn.xiaodong.java.chapter02;

/**
 * 一个Po对象
 * 人类
 *
 * @author: xiaodong
 * @create: 2022-02-08 17:18
 **/
public class Person {

    String name = "";

    int age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
