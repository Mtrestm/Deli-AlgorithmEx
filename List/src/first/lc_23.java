/**
 * @program: Deli-AlgorithmEx
 * @description: 合并K个排序链表
 * @author: Shaobo.Qian
 * @create: 2020-04-18 09:19
 **/

package first;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_23 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(Integer[] nums) {
            ListNode currNode = this;
            currNode.val = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currNode.next = new ListNode(nums[i]);
                currNode = currNode.next;
            }
        }

        @Override
        public String toString() {
            ListNode currNode = this;
            StringBuilder s = new StringBuilder();
            while (currNode != null) {
                s.append(currNode.val);
                s.append(" -> ");
                currNode = currNode.next;
            }
            // 最后添加一个 NULL 标志表示添加到末尾了
            s.append("NULL");
            return s.toString();
        }
    }


    /**
     * @question: 1.贪心算法的思想是? 2.本题需要什么数据结构来帮助实现贪心算法 3.如何测试+打印链表
     * 贪心算法(算法思想:局部最优-->整体最优)+优先队列(数据结构)
     * @author Shaobo.Qian
     * @date 2020/4/18
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
        for (ListNode node : lists) {
            if (node != null)
                priorityQueue.add(node);
        }
        ListNode dummyNode = new ListNode(-1);//创建dummyNode
        ListNode currNode = dummyNode; //指向dummyNode的指针

        // 优先队列非空才能出队
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            currNode.next = node;//将出队的节点链在尾部
            currNode = currNode.next;//currNode指针向前走一位,指向链表末尾
            if (currNode.next != null) {
                // 只有非空节点才能加入到优先队列中
                priorityQueue.add(currNode.next);
            }

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;

        lc_23 solution = new lc_23();


        ListNode mergeKLists = solution.mergeKLists(lists);
        System.out.println("mergeKLists = " + mergeKLists);


    }


}
