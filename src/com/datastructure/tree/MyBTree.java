package com.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyBTree {

}

//定义一个键值对， 实现了Map.Entry接口
class Entry implements Comparable<Entry> {

    final int key;
    String value;

    public Entry(int key,String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String setValue(String newValue) {
        String oldValue = this.value;
        this.value = newValue;
        return oldValue;
    }

    //按照key排序
    @Override
    public int compareTo(Entry o) {
        return Integer.compare(key, o.getKey());
    }
}

class BTree {
    private final int m;
    private final int min;
    private Node root;

    public BTree (int m) {
        this.m = m;
        this.min = (int) Math.ceil(m / 2.0) - 1;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 根据键搜索数据记录
     *
     * @param key
     * @return
     */
    public Entry searchEntry(int key) {
        return searchEntry(root, key);
    }
    /**
     * 根据键搜索数据记录 - 递归
     *
     * @param node
     * @param key
     * @return
     */
    private Entry searchEntry (Node node, int key) {
        if (node == null) return null;
        int index = Collections.binarySearch(node.getEntries(),new Entry(key, null));
        if (index >= 0) {
            return node.getEntries().get(index);
        } else {
            if (node.getChildNodes().size() == 0) {
                return null;
            }
            return searchEntry(node.getChildNodes().get(-index - 1), key);
        }
    }

    /**
     * 根据键搜索记录所在节点 - 递归
     *
     * @param node
     * @param key
     * @return
     */
    private Node searchNode(Node node, int key) {
        if (node == null) {
            return null;
        }
        // 使用二分查找法定位下标
        int index = Collections.binarySearch(node.getEntries(), new Entry(key, null));
        if (index >= 0) {
            return node;
        } else {
            if (node.getChildNodes().size() == 0) {
                return null;
            }
            return searchNode(node.getChildNodes().get(-index - 1), key);
        }
    }

    /**
     * 添加元素
     *
     * @param entry
     */
    public void add(Entry entry) {
        // root为空，直接创建
        if (root == null) {
            Node node = new Node();
            node.add(entry);
            root = node;
            return;
        }
        add(root, entry);
    }

    private void add(Node root, Entry entry) {

    }

    @Override
    public String toString() {
        return "BTree{" +
                "root=" + root +
                '}';
    }
}

/**
 * B树的节点类
 */
class Node implements Comparable<Node> {
    private final List<Entry> entries;
    private final List<Node> childNodes;
    private Node parentNode;

    public Node () {
        entries = new ArrayList<>();
        childNodes = new ArrayList<>();
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node add (Entry entry) {
        entries.add(entry);
        Collections.sort(entries);
        return this;
    }

    public Node addChild (Node node) {
        childNodes.add(node);
        Collections.sort(childNodes);
        return this;
    }

    /**
     * 按照键值中第一个key排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return Integer.compare(entries.get(0).getKey(),o.getEntries().get(0).getKey());
    }

    @Override
    public String toString() {
        return "Node{" +
                "entries=" + entries +
                ", childNodes=" + childNodes +
                '}';
    }
}
