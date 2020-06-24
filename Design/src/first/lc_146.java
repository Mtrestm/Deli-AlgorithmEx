/**
 * @program: Deli-AlgorithmEx
 * @description: LRU缓存机制
 * @author: Shaobo.Qian
 * @create: 2020-05-25 06:55
 **/

package first;

import java.util.HashMap;
import java.util.Map;

public class lc_146 {
    /**
     * @author Shaobo.Qian
     * @question:
     * 1.LRU缓存机制的含义?
     * 2.题目要求 O(1)时间复杂度,所以要借助哪两种数据结构,这两种数据结构在本题中的联系?
     * 3.借助两种数据结构:其中Map中的 key,value 分别是什么?其中 ListNode 中保存哪两个元素?
     * 4.如何加速双向链表得访问?需要借助什么?
     * 5.LRUCache构造函数需要如何初始化?
     * 6.添加三个公用方法,其中如何在双链表的头部新增一个结点?具体分为哪三步?
     * 7.添加三个公用方法,其中如何把当前 key 指向的结点移到双向链表的头部?具体分为哪三步?
     * 8.添加三个公用方法,其中如何删除双链表尾部结点?具体分为哪三步?
     * 9.put()方法的逻辑?put方法中如何维护 Map,ListNode 两种数据结构的?
     *10.get()方法的逻辑?get方法中如何维护 Map,ListNode 两种数据结构的?
     * @date 2020/5/25
     */
    class LRUCache {
        //数据结构一
        private Map<Integer, ListNode> map;

        //数据结构二
        private class ListNode {
            private Integer key;
            private Integer value;
            /**
             * 前驱结点 precursor
             */
            private ListNode pre;

            /**
             * 后继结点 successor（写成 next 是照顾单链表的表示习惯）
             */
            private ListNode next;

            public ListNode() {
            }

            public ListNode(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;//容量
        /**
         * 虚拟头结点没有前驱
         */
        private ListNode dummyHead;
        /**
         * 虚拟尾结点没有后继
         */
        private ListNode dummyTail;


        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
            dummyHead = new ListNode(-1, -1);
            dummyTail = new ListNode(-1, -1);

            // 初始化链表为 head <-> tail
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }


        public int get(int key) {
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                int val = node.value;
                // 把当前 node 移动到双向链表的头部
                moveNode2Head(node.key);
                return val;
            }
            return -1;
        }

        public void put(int key, int value) {
            //1.如果有该 key 了
            if (map.containsKey(key)) {
                //1.更新 value
                map.get(key).value = value;
                //2.把当前 node 移动到双向链表的头部
                moveNode2Head(key);
                return;
            }

            //2.如果容量满了
            if (map.size() == capacity) {
                //1.移除双线链表尾部节点
                ListNode oldTail = removeTail();
                //2.在 map 中删除该节点
                map.remove(oldTail.key);
            }
            //3.新增元素
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addNode2Head(newNode);
        }

        /**
         * 删除双链表尾部结点
         * @return
         */
        private ListNode removeTail() {
            //1.获取oldTail,newTail
            ListNode oldTail = dummyTail.pre;
            ListNode newTail = oldTail.pre;
            //2.newTail 和 dummyTail 双向关联
            newTail.next = dummyTail;
            dummyTail.pre = newTail;
            //3.释放oldTail的引用
            oldTail.pre = null;
            oldTail.next = null;
            return oldTail;
        }
        /**
         * 把当前 key 指向的结点移到双向链表的头部
         * @param key
         */
        private void moveNode2Head(int key) {
            //1.从 map 中取出 key 对应得 node
            ListNode node = map.get(key);
            //2.node在双向链表中原来位置取消关联
            node.pre.next = node.next;
            node.next.pre = node.pre;
            //3.将 node 加入双向链表头部
            addNode2Head(node);
        }

        /**
         * 在双链表的头部新增一个结点
         *
         * @param newNode
         */
        public void addNode2Head(ListNode newNode) {
            // 1、获取当前头结点
            ListNode oldHead = dummyHead.next;
            // 2.newNode 和 oldHead 双向关联
            oldHead.pre = newNode;
            newNode.next = oldHead;

            //3. newNode和dummyHead双向关联
            newNode.pre = dummyHead;
            dummyHead.next = newNode;
        }
    }
}
