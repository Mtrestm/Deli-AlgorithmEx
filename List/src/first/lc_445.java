/**
 * @program: Deli-AlgorithmEx
 * @description: 两数相加 II
 * @author: Shaobo.Qian
 * @create: 2020-04-14 05:49
 **/

package first;

import java.util.Stack;

public class lc_445 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * @question: 1.如何将新建的单链表节点加到单链表头部?
     * @author Shaobo.Qian
     * @date 2020/4/14
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 ==null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            //将新建的单链表节点加到单链表头部
            ListNode curr = new ListNode(sum % 10);
            curr.next = head;
            head = curr;
            carry = sum / 10;
        }
        return head;
    }

        /**
         * 自解
         * @author Shaobo.Qian
         * @date 2020/4/14
         */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //1.先将链表反转(栈)
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int preLocNum = 0;
        while (stack1.size() > 0 && stack2.size() > 0) {
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int currNum = 0;
            if ((num1 + num2 + preLocNum) >= 10) {
                currNum = (num1 + num2 + preLocNum) - 10;
                preLocNum = 1;
            } else {
                currNum = (num1 + num2 + preLocNum);
                preLocNum = 0;
            }
            tail.next = new ListNode(currNum);
            tail = tail.next;
        }
        while (stack1.size() > 0) {
            int currNum = 0;
            int num = stack1.pop();
            if (preLocNum + num >= 10) {
                currNum =  preLocNum + num - 10;
                preLocNum = 1;
            } else {
                currNum = preLocNum + num;
                preLocNum = 0;
            }
            tail.next = new ListNode(currNum);
            tail = tail.next;
        }
        while (stack2.size() > 0) {
            int currNum = 0;
            int num = stack2.pop();
            if (preLocNum + num >= 10) {
                currNum = preLocNum + num - 10;
                preLocNum = 1;
            } else {
                currNum = preLocNum + num;
                preLocNum = 0;
            }
            tail.next = new ListNode(currNum);
            tail = tail.next;
        }
        //3.反转,建链表
        ListNode reverseRes = dummy.next;
        while (reverseRes != null) {
            stack1.push(reverseRes.val);
            reverseRes = reverseRes.next;
        }
        if (preLocNum > 0) {
            stack1.push(preLocNum);
        }
        ListNode lastTail = dummy;
        while (stack1.size() > 0) {
            lastTail.next = new ListNode(stack1.pop());
            lastTail = lastTail.next;
        }

        return dummy.next;
    }
}
