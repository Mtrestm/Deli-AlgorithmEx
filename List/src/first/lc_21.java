/**
 * @program: Deli-AlgorithmEx
 * @description: 合并两个有序链表
 * @author: Shaobo.Qian
 * @create: 2020-05-01 04:47
 **/

package first;

public class lc_21 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * @question: 1.有哪四种情况得terminator 2.递归解法利用了哪两个条件?3.递归解法得思路时怎样得?
     * 递归:(1.利用了链表本身数据结构递归的特点 2.利用了java隐式栈)
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.terminator
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        //2.current level
        if (l1.val <= l2.val) {
            //返回到当前层 ,当前节点为l1 ,l1.next 已经在更底层得栈里按顺序递增拼接好了
            l1.next = mergeTwoLists(l1.next, l2);//3.drill down
            return l1;
        } else {
            //返回到当前层 ,当前节点为l1 ,l1.next 已经在更底层得栈里按顺序递增拼接好了
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     * 我解
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode n1 = new ListNode(-1);
        n1.next = l1;
        ListNode n2 = new ListNode(-1);
        n2.next = l2;
        ListNode curr = dummy;
        while (n1.next != null && n2.next != null) {
            if (n1.next.val <= n2.next.val) {
                curr.next = new ListNode(n1.next.val);
                n1 = n1.next;
            } else {
                curr.next = new ListNode(n2.next.val);
                n2 = n2.next;
            }
            curr = curr.next;
        }
        while (n1.next != null) {
            curr.next = new ListNode(n1.next.val);
            n1 = n1.next;
            curr = curr.next;
        }
        while (n2.next != null) {
            curr.next = new ListNode(n2.next.val);
            n2 = n2.next;
            curr = curr.next;
        }
        return dummy.next;
    }

}
