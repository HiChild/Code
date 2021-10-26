package com.soe.leecode.daytest;

public class LongestBeautifulSubstring {
        boolean[] set = new boolean[5];
        public int longestBeautifulSubstring(String word) {
            word = word + " ";
            int n = word.length();
            if (n < 5) return 0;
            char[] c = word.toCharArray();
            int start = 0, end = start + 1;
            int max = 0;
            add(c[start]);
            while (end < n) {
                int count = 1;
                while (end < n && c[end] - c[end - 1] >= 0) {
                    add(c[end]);
                    end++;
                    count++;
                }

                if (isOK()) {
                    max = Math.max(max, count);
                }
                clean();
                start = end;
                add(c[start]);
                end++;
            }
            return max;
        }

        void add(char c) {
            if (c == 'a') {
                set[0] = true;
            }
            else
            if (c == 'e') {
                set[1] = true;
            }
            else
            if (c == 'i') {
                set[2] = true;
            }
            else
            if (c == 'o') {
                set[3] = true;
            }else
            if (c == 'u') {
                set[4] = true;
            }else{

            }
        }

        void clean() {
            for (int i = 0; i < 5; ++i) {
                set[i] = false;
            }
        }

        boolean isOK() {
            for (int i = 0; i < 5; ++i) {
                if (!set[i]) {
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        LongestBeautifulSubstring longestBeautifulSubstring = new LongestBeautifulSubstring();
        int n = longestBeautifulSubstring.longestBeautifulSubstring("aeeeiiiioooauuuaeiou");
        System.out.println(n);
    }
}
