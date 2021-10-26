package com.test;

public class Main {
    public static void main(String[] args) {

        System.out.println("生产HuaWei phone");
        Phone huaWeiPhone = PhoneFactory.produce("HuaWei");
        System.out.println("生产成功");
        huaWeiPhone.use();
        System.out.println("生产XiaoMi phone");
        Phone xiaoMiPhone = PhoneFactory.produce("XiaoMi");
        System.out.println("生产成功");
        xiaoMiPhone.use();

    }
}
