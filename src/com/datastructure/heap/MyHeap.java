package com.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 大顶堆
 * 优先队列常常用堆（heap）来实现。堆是一个完全二叉树，其每个节点的值总是大于等于子
 * 节点的值。实际实现堆时，我们通常用一个数组而不是用指针建立一个树。这是因为堆是完全二
 * 叉树，所以用数组表示时，位置 i 的节点的父节点位置一定为 i/2，而它的两个子节点的位置又一
 * 定分别为 2i 和 2i+1。
 *
 * 以下是堆的实现方法，其中最核心的两个操作是上浮和下沉：如果一个节点比父节点大，那
 * 么需要交换这个两个节点；交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操
 * 作，我们称之为上浮；类似地，如果一个节点比父节小，也需要不断地向下进行比较和交换操作，
 * 我们称之为下沉。如果一个节点有两个子节点，我们总是交换最大的子节点。
 */
public class MyHeap {

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.push(1);
        myHeap.push(6);
        myHeap.push(3);
        myHeap.push(21);
        System.out.println(myHeap.top());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
        System.out.println(myHeap.pop());
    }

    List<Integer> heap = new ArrayList<>();

    //获得最大值，大顶堆
    public int top() {
        return heap.get(0);
    }

    //插入任意值，将新数字放在最后一位，然后开始上浮
    public void push(int k ) {
        heap.add(k);
        swim(heap.size() - 1);
    }

    //删除最大值：把最后一个数字挪到开头然后下沉
    public int pop() {
        int temp = top();
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1); //移除最后一个元素
        sink(0);
        return temp;
    }



    //上浮
    private void swim(int pos) {
        while ( heap.get(pos / 2) < heap.get(pos)) {
            swap(heap, pos/2, pos);
            pos /= 2;
        }
    }

    //下沉
    private void sink(int pos) {
        int n = heap.size();
        while(2 * pos < n - 1) {
            int i = 2 * pos; //左子节点
            if( heap.get(i) < heap.get(i + 1)) ++i; //另i为左右两个节点中最大的节点
            if (heap.get(pos) >= heap.get(i)) break;
            swap(heap,pos, i);
            pos = i;
        }
    }

    private void swap (List<Integer> heap, int pos1, int pos2) {
        int temp = heap.get(pos1);
        heap.set(pos1, heap.get(pos2));
        heap.set(pos2, temp);
    }

}
