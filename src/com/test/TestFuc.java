package com.test;

public class TestFuc {
    public static void main(String[] args) {
        Person person = new Person("Jerry", "111");
        TestFuc testFuc = new TestFuc();
        System.out.println("Before: " + person.toString());
        testFuc.A(person);
        System.out.println("Before: " + person.toString());
        System.out.println(person);
    }

    public void A(Person person) {
        B(person);
    }

    public void B(Person person) {
        person.setName("change");
        person.setSex("000");
    }
}
