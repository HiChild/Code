package com.soe.leecode.trie;

public class Trie1 {
     private TrieNode root;

     class TrieNode {
          private boolean isEnd;
          TrieNode[] next;
          TrieNode() {
               isEnd = false;
               next = new TrieNode[26];
          }
     }

     public Trie1() {
          root = new TrieNode();
     }

     public void insert(String words) {
          TrieNode node = root;
          for (char c : words.toCharArray()) {
               if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
               }
               node = node.next[c - 'a'];
          }
          node.isEnd = true;
     }

     public boolean search (String words) {
          TrieNode node = root;
          for (char c : words.toCharArray()) {
               node = node.next[c - 'a'];
               if (node == null) {
                    return false;
               }
          }
          return node.isEnd;
     }

     public boolean startWith (String prefix) {
          TrieNode node = root;
          for (char c : prefix.toCharArray()) {
               node = node.next[c - 'a'];
               if (node == null) {
                    return false;
               }
          }
          return true;
     }
}
