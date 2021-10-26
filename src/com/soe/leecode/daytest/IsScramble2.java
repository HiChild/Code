package com.soe.leecode.daytest;

public class IsScramble2 {
    String s1, s2;
    int[][][] cache;
    int N = -1, Y = 1, EMPTY = 0;
    public boolean isScramble(String _s1, String _s2) {
        //递归 + 记忆化搜索 定义cache[i][j][k] 为s1从i开始，后面的k位和s2从j开始后面的k位字符串是否形成扰乱字符串
        //所以需要定义s1和s2为全局变量
        this.s1 = _s1;
        this.s2 = _s2;
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        //默认为EMPTY
        cache = new int[n][n][n + 1]; //前两位都是下标，后一位是长度，所以需要开辟n+1的空间
        return dsf(0,0,n);
    }

    private boolean dsf(int i, int j, int len) {
        if(cache[i][j][len] != EMPTY) return cache[i][j][len] == Y;
        //根据定义，取出为s1从i开始，后面的len位和s2从j开始后面的len位
        String a = s1.substring(i,i + len), b = s2.substring(j, j + len);
        if (a.equals(b)) {
            cache[i][j][len] = Y;
            return true;
        }
        if (!check(a,b)) {
            cache[i][j][len] = N;
            return false;
        }
        //a 和 b 值不相等 且 出现的字符的频率相同，则需要进行判断
        //从s1和s2往后 1位开始比较到 length - 1位 所以k初始值位1
        for (int k = 1; k < len; k++) {
            //没有反转的情况下，i,j同序; 相当于s1[0,i)要匹配s2的[0,i) && s1[i,n)要匹配s2的[i,n);
            //那么需要比较s1从当前位置i往后k位，和s2从当前位置j往后k位 形成的是否为扰乱字符串
            //以及，从s1剩下的len - k 位，和s2剩下的len - k 位 形成的是否为扰乱字符串
            //以上两个条件必须同时满足
            if (dsf(i, j, k) && dsf(i + k,j + k, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
            //发生了反转的情况下， 相当于s1[0,i)要匹配s2的[n - i,n) && s1[i,n)要匹配s2的[0,n - i);
            //那么需要比较s1从当前位置i,往后k位,和s2从当前位置len - k + j (s2这里是从后面开始 反转后 后面的和前面的匹配，前面的和后面的匹配)
            //len - k + j 这个位置不好理解，同学们可以试着画图一看便知
            //以及 s1剩下的len - k位，和s2剩下的len - k位 (s2这里是从前面开始，也就是当前位置为 j)
            //以上两个条件必须同时满足
            if (dsf(i, len - k + j, k)  && dsf(i + k, j, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
        }
        //以上两种情况验证过了以后还不成立
        cache[i][j][len] = N;
        return false;
    }

    private static boolean check(String s1, String s2) {
        int[] cnt = new int[26];
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        for (int i : cnt) {
            if (i != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
    }
}
