/**
 * @program: Deli-AlgorithmEx
 * @description: 反转链表
 * @author: Shaobo.Qian
 * @create: 2020-05-01 09:49
 **/

package first;

import java.util.Stack;

public class jz_24 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            // curr 和 prev 都向前异步
            prev = curr;
            curr = temp;

        }
        return prev;
    }
    /**
     * 借助 stack
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public ListNode reverseList1(ListNode head) {

        ListNode curr = head;
        Stack<Integer> stack = new Stack<>();

        while (curr != null) {
            stack.add(curr.val);
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode newCurr = dummy;
        while (!stack.isEmpty()) {
            newCurr.next = new ListNode(stack.pop());
            newCurr = newCurr.next;
        }
        return dummy.next;
    }
}
