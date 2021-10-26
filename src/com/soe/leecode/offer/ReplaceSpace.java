package com.soe.leecode.offer;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return new String(sb);
    }
}
