/**
 * @program: Deli-AlgorithmEx
 * @description: 链表的中间结点
 * @author: Shaobo.Qian
 * @create: 2020-03-23 23:06
 **/

package first;

public class lc_876 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针
     *
     * @author Shaobo.Qian
     * @date 2020/3/24
     */
    public ListNode middleNode(ListNode head) {
        //1--mid=1 ; 2--mid = 2; 3--mid = 2;4--mid=3; 5--mid=3; ==>mid = nodeNum/2+1
        ListNode curr = head;
        ListNode quickPtr = head;
        ListNode slowPtr = head;
        while (quickPtr != null && quickPtr.next != null) {
            quickPtr = quickPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public ListNode middleNode1(ListNode head) {
        //1--mid=1 ; 2--mid = 2; 3--mid = 2;4--mid=3; 5--mid=3; ==>mid = nodeNum/2+1
        ListNode curr = head;
        //1.获取链表的个数
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int middle = count / 2 + 1;
        count = 1;
        while (count != middle) {
            count++;
            head = head.next;
        }
        return head;
    }
}
