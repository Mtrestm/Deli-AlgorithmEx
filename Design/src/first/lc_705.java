/**
 * @program: Deli-AlgorithmEx
 * @description: 设计哈希集合
 * @author: Shaobo.Qian
 * @create: 2020-01-15 05:07
 **/

package first;

public class lc_705 {
    class MyHashSet {
        class ListNode {
            int key;
            ListNode next;

            public ListNode(int key) {
                this.key = key;
            }
        }

        private final ListNode[] table = new ListNode[10000];

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {

        }

        public void add(int key) {
            int i = idx(key);
            if (table[i] == null) {
                table[i] = new ListNode(-1);
            }
            ListNode prev = find(table[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key);
        }

        public void remove(int key) {
            int i = idx(key);
            if (table[i] == null) return;
            ListNode prev = find(table[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int i = idx(key);
            if (table[i] ==null) return false;
            return find(table[i], key).next != null;
        }

        //哈希函数
        int idx(int key) {
            return Integer.hashCode(key) % table.length;
        }

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
