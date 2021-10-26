package com.datastructure.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class BST<T> {

    Node<T> root;

    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<Integer>(Integer::compareTo);
    }

    /**
     * The comparator used to maintain order in this tree map, or
     * null if it uses the natural ordering of its keys.
     *
     * @serial
     */
    private final Comparator<? super T> comparator;

    /**
     *从TreeMap扒来的
     * @param comparator
     */
    public BST(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T>  right;
    }

    public Node<T> makeEmpty(Node<T> t) {
        if (t == null) return null;
        makeEmpty(t.left);
        makeEmpty(t.right);
        t = null;
        return null;
    }

    public Node<T> insert(Node<T> t, T x) {
        if (t == null) {
            t = new Node<>();
            t.data = x;
            t.left = t.right = null;
        } else {
            int cmp = comparator.compare(x, t.data);
            if (cmp < 0) { //相当于x < t.data
                t.left = insert(t.left, x);
            } else if (cmp > 0) { //相当于 x > t.data
                t.right = insert(t.right, x);
            }
        }
        return t;
    }

    public Node<T> find(Node<T> t, T x) {
        if (t == null) return null;
        int cmp = comparator.compare(x, t.data);
        if (cmp < 0) return find(t.left, x);
        if (cmp > 0) return find(t.right, x);
        return t;
    }

    public Node<T> findMin(Node<T> t) {
        if (t == null || t.left == null) return t;
        return findMin(t.left);
    }

    public Node<T> findMax(Node<T> t) {
        if (t == null || t.right == null ) return t;
        return findMax(t.right);
    }

    public Node<T> remove(Node<T> t, T x) {
        Node<T> temp;
        if (t == null) return null;
        int cmp = comparator.compare(x, t.data);
        if (cmp < 0) t.left = remove(t.left, x);
        else if (cmp > 0) t.right = remove(t.right, x);
        else if (t.left != null && t.right != null) {
            temp = findMin(t.right);
            t.data = temp.data;
            t.right = remove(t.right, t.data);
        } else {
            temp = t;
            if (t.left == null) t = t.right;
            else if (t.right == null) t = t.left;
            temp = null;
        }
        return t;
    }
}
