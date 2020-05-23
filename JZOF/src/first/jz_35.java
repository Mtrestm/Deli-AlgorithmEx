/**
 * @program: Deli-AlgorithmEx
 * @description: 复杂链表的复制
 * @author: Shaobo.Qian
 * @create: 2020-05-02 10:29
 **/

package first;

public class jz_35 {

    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * link: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/comments/
     * 原地解法
     * @question
     * 0.什么是链表的深拷贝和浅拷贝?
     * 1.原地解法分为哪三步?
     * 2.如何完成链表节点的复制
     * 3.如何完成链表复制节点的随机指针复制?
     * 4.如何将链表一分为二?
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        //1.完成链表节点的复制
        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;//复制的新节点放在当前节点后面
            cur = cur.next.next;//当前节点指针往前走2步到达下一个要复制的节点
        }

        //2.完成链表复制节点的随机指针复制
        cur = head;//完成节点复制后重置 cur 指针到头部
        while (cur != null) {
            if (cur.random != null) {
                //链表复制节点的随机指针复制
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.将链表一分为二
        Node copyHead = head.next;
        cur = head;//重置 cur 指针到头部
        Node curCopy = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next; //cur 往前指针移动1步,到重建的第一条链表尾部
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;//重建第二条链表
                curCopy = curCopy.next;//curCopy 往前指针移动1步,到重建的第二条链表尾部
            }
        }
        return copyHead;
    }

}
