/**
 * @program: Deli-AlgorithmEx
 * @description:反转链表
 * @author: Shaobo.Qian
 * @create: 2020-03-02 06:56
 **/

package first;

public class lc_206 {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * anki
     * @question
     * 0.不用外部空间有哪两种解法?
     * 1.双指针的解法来反转链表以及画图?
     * 2.递归的解法来反转链表以及画图?
     * @author Shaobo.Qian
     * @date 2020/3/2
     * @link https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     */
    public ListNode reverseList1(ListNode head) {
        //输入: 1->2->3->4->5->NULL
        //输出: 5->4->3->2->1->NULL
        //1.链表中的元素个数并不会改变
        //2.链表是递归的数据结构
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev; //将当前指针指向 prev
            prev = curr; //prev 节点前进一位
            curr = tempNode;//curr节点前进一位
        }

        return prev;
    }

    private ListNode prev , temp = null;
    /**
     * //递归解法
     * @author Shaobo.Qian
     * @date 2020/3/2
     * @Link https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     */
    public ListNode reverseList(ListNode head) {
        //1.terminer
        if(head == null)
            return prev;
        //2.current level
        temp = head.next;
        head.next = prev;//当前指针翻转
        prev = head; // prev 节点前进一位
        head = temp;//head 节点前进一位
        //drill down
        return reverseList(head);
    }

}
