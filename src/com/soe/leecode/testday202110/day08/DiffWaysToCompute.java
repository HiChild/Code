package com.soe.leecode.testday202110.day08;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        return divideAndCounquer(expression.toCharArray());
    }

    public static List<Integer> divideAndCounquer(char[] expression) {
        List<Integer> res = new ArrayList<>();
        if (isOneNumber(expression)) {
            res.add(Integer.valueOf(new String(expression)));
            return res;
        }

        for (int i = 0; i < expression.length; ++i) {
            if(!Character.isDigit(expression[i])) {
                char[] left = new char[i];
                char[] right = new char[expression.length - i - 1];
                System.arraycopy(expression, 0, left, 0, i);
                System.arraycopy(expression, i + 1, right, 0, expression.length - i - 1);
                List<Integer> listOne = divideAndCounquer(left);
                List<Integer> listTwo = divideAndCounquer(right);
                List<Integer> tempRes = caculate(listOne, listTwo, expression[i]);
                for (Integer num : tempRes) {
                    res.add(num);
                }
            }
        }
        return res;
    }

    public static List<Integer> caculate(List<Integer> listOne, List<Integer> listTwo, char operator) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < listOne.size(); ++i) {
            for (int j = 0; j < listTwo.size(); ++j) {
                res.add(calculateTwoNums(listOne.get(i),listTwo.get(j),operator));
            }
        }
        return res;
    }

    //简单的计算函数
    public static Integer calculateTwoNums(int num1,int num2,char operator){
        switch(operator) {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            default:
                return num1*num2;
        }
    }

    public static boolean isOneNumber(char[] expression){
        for (char ch : expression) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
