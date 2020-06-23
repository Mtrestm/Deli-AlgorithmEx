/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:55
 **/

package first;

public class jz_52 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    /**
     * anki
     * 双指针
     * @link: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/liang-ge-lian-biao-zhong-de-di-yi-ge-gong-gong-jie/
     * @link: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
     * 1.双指针的解题思路是怎样的?
     * 2.怎样画图模拟整个过程?
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 自解(未解出,理论上可以,没发现错误)
     *
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //1.将两个链表倒置
        ListNode reverseA = getReverseListNode(headA);
        System.out.println("reverseA.val = " + reverseA.val);
        ListNode reverseB = getReverseListNode(headB);
        System.out.println("reverseB.val = " + reverseB.val);
        //2.遍历两个倒置后的链表获取最后一个相交的节点
        ListNode currA = reverseA;
        ListNode currB = reverseB;
        ListNode dummy = new ListNode(-1);
        if (currA.val != currB.val) return null;
        while (currA != null && currB != null && currA.val == currB.val) {
            dummy.next = currA;
            currA = currA.next;
            currB = currB.next;
        }

        int val = dummy.next.val;
        System.out.println("val = " + val);

        while (headA != null && headA.val != val) {
            headA = headA.next;
        }
        return headA;
    }

    /**
     * 双指针(倒置链表)
     *
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    private ListNode getReverseListNode(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        System.out.println("prev.val = " + prev.val);
        return prev;
    }

}
