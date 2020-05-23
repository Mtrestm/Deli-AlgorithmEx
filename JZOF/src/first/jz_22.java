/**
 * @program: Deli-AlgorithmEx
 * @description: 链表中倒数第k个节点
 * @author: Shaobo.Qian
 * @create: 2020-05-01 09:48
 **/

package first;

import java.util.Stack;

public class jz_22 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int idx = size - k ;
        while (idx-- > 0) {
            head = head.next;
        }
        return head;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {

        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        ListNode res = null;
        while (k > 0) {
            res = stack.pop();
        }
        return res;
    }
}
