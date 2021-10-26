package com.test;

public class PhoneFactory {
    public static Phone produce(String brand) {
        if (brand.equals("HuaWei")) {
            return new HuaWei();
        } else if (brand.equals("XiaoMi")) {
            return new XiaoMi();
        } else {
            return new OtherPhone();
        }
    }
}
