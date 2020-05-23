/**
 * @program: Deli-AlgorithmEx
 * @description: K 个一组翻转链表
 * @author: Shaobo.Qian
 * @create: 2020-05-17 15:41
 **/

package first;

public class lc_25 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 已入anki
     * @link: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     * @question
     * 1.需要哪些辅助指针完成链表的每 k 个节点一次的翻转
     * 2.如何处理剩余节点不足 k 个的情况?
     * 3.辅助指针每次如何重置?
     * 4.画图展现整个算法思路?
     * @author Shaobo.Qian
     * @date 2020/5/17
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //1.end 指针往前走,当翻转部分长度不足k时,直接返回即可
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            //2.每一段翻转+拼接
            ListNode start = pre.next;
            ListNode nextPhase = end.next;
            end.next = null;//将当前段截取出来
            pre.next = reverse(start);//pre指针一开始指向的是已拼接好的部分的末尾节点,这里就是将当前段翻转后连上上一段
            //3.将拼接翻转好的链表和未翻转处理的链表连接
            start.next = nextPhase;//(注意此时 start 被翻转后已经指向已处理部分的链表末尾了)
            //4.重置指针(pre,end 重置到已处理部分的链表的末尾处)
            pre = start;
            end = pre;
        }

        return dummy.next;

    }

    /**
     * 翻转链表
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
