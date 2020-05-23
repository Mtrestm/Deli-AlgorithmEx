package first;

import java.util.Arrays;

/**
 * @program: Deli-AlgorithmEx
 * @description:设计哈希映射
 * @author: Shaobo.Qian
 * @create: 2020-01-14 08:34
 * @anki: 1.如何解决key冲突,通过哪种数据结构解决 2.要实现哪些关键方法 3.为什么在 put 时候需要设置(-1,-1)这样的dummy前节点
 **/

public class lc_706 {
    /**
     * 解法1:直接开个大数组,保证没有冲突
     * @author Shaobo.Qian
     * @date 2020/1/14
     */
    class MyHashMap1 {
        private int[] table;

        /** Initialize your data structure here. */
        public MyHashMap1() {
            table = new int[1000000];
            Arrays.fill(table, -1);
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            table[key] = value;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            return table[key];
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            table[key] = -1;
        }
    }

    /**
     *   通过链表结构来解决 key 冲突
     * @author Shaobo.Qian
     * @date 2020/1/14
     * @link https://leetcode.com/problems/design-hashmap/discuss/152746/Java-Solution
     */
    class MyHashMap {
        class ListNode{//链表结构
            int key, val;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
        private final ListNode[] nodes = new ListNode[10000];



        /** Initialize your data structure here. */
        public MyHashMap() {

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = idx(key);
            if(nodes[index] == null)
               nodes[index] =  new ListNode(-1, -1);
            ListNode prev = find(nodes[index], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;

        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = idx(key);
            if (nodes[index] == null) return -1;
            ListNode node = find(nodes[index], key);
            return node.next == null ? -1 : node.next.val;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = idx(key);
            if (nodes[index] == null) return;
            ListNode prev = find(nodes[index], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        /**
         * key的hash值
         * @param key
         * @return
         */
        int idx(int key) {
            return Integer.hashCode(key) % nodes.length;
        }

        /**
         * 在链表中查找,从表头开始查找
         * @param bucket 传入表头
         * @param key 目标 key
         * @return 返回目标节点的上一个节点,为什么返回目标节点的上一个节点,作为公共方法更具有适用性
         */
        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
    }
}
