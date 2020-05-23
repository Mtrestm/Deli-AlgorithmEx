/**
 * @program: Deli-AlgorithmEx
 * @description: 合并两个排序的链表
 * @author: Shaobo.Qian
 * @create: 2020-05-01 09:50
 **/

package first;

public class jz_25 {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.terminator
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //2.current level
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);//3.drill down
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
