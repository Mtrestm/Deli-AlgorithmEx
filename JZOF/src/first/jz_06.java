/**
 * @program: Deli-AlgorithmEx
 * @description: 从尾到头打印链表
 * @author: Shaobo.Qian
 * @create: 2020-03-05 11:57
 **/

package first;

import java.util.Stack;

public class jz_06 {
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用栈
     * @author Shaobo.Qian
     * @date 2020/3/5
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //从头到尾加入栈
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
