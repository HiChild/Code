package com.soe.leecode.offer;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {


        Deque<Integer> stack = new LinkedList<>();
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) count++;
        int[] res = new int[count];
        for (int i = 0; !stack.isEmpty(); i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
