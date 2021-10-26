package com.datastructure.linkedlist;

import com.soe.leecode.offer.ListNode;

public class ReverseList {

    /**
     递归写法，利用系统栈
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }

    /**
     迭代写法
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }


}
