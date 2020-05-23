/**
 * @program: Deli-AlgorithmEx
 * @description: 删除链表的节点
 * @author: Shaobo.Qian
 * @create: 2020-03-19 22:10
 **/

package first;

import java.math.BigDecimal;

public class jz_18 {
    public static void main(String[] args) {
        System.out.println(10.22 *100);
        System.out.println(new BigDecimal(10.22).multiply(BigDecimal.valueOf(100)).intValue());
    }
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * dummy/curr 都看作指针就好理解了
     * @author Shaobo.Qian
     * @date 2020/3/19
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null ) return null;
        //1.新建 dummy 节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}
