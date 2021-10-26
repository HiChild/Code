package com.soe.leecode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinNumber {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) return "";
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((a,b) -> (a + b).compareTo(b + a));
        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
