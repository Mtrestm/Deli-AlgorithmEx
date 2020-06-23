/**
 * @program: Deli-AlgorithmEx
 * @description: 将二叉搜索树转化为排序的双向链表
 * @author: Shaobo.Qian
 * @create: 2020-03-04 09:01
 **/

package first;

import java.util.Stack;

public class lc_426 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 用栈实现中序遍历(栈+迭代)
     *
     * @author Shaobo.Qian
     * @date 2020/3/3
     * @link https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-2/
     */
    public Node treeToDoublyList1(Node root) {
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node tail = new Node(0);
        Node dummy = tail;//此时dummy和tail是两个指针指向链表外的同一个虚拟节点
        while (!stack.isEmpty() || curr != null) {
            //递归的将根节点的左子节点放入栈
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            //取出栈中的节点继续操作,每取出一个节点都可以看作根节点
            curr = stack.pop();

            //将当前节点链接到链表的尾部,和当前尾节点进行双向连接
            tail.right = curr;
            curr.left = tail;
            tail = tail.right; //链接完当前节点后,尾节点前进一位

            curr = curr.right;//按二叉树中序遍历的顺序,最后处理当前节点(根节点)的右节点
        }

        //最后将首尾节点相连
        Node head = dummy.right;//得到链表中的头节点(如果不理解,把这行注释掉,会打印出0)
        tail.right = head;
        head.left = tail;
        return head;
    }

    /**
     * 递归 + (将二叉搜索树转化为排序的双向链表)
     * @question: //1.递归的方式二叉树的标准中序遍历怎么写?
     * @author Shaobo.Qian
     * @date 2020/3/4
     * @link:https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/jiang-er-cha-sou-suo-shu-zhuan-hua-wei-pai-xu-de-s/
     */
    // the smallest (first) and the largest (last) nodes
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        //调用标准递归
        helper(root);
        //首尾相连
        last.right = first;
        first.left = last;
        return first;
    }

    public void helper(Node curr) {
        if (curr != null) {//递归出口
            //left(向下一层)
            helper(curr.left);
            // curr(处理当前层逻辑)
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = curr;
                curr.left = last;
            } else {//这里的逻辑只会走一次
                // keep the smallest node
                // to close DLL later on
                first = curr;
            }
            last = curr;
            //right(向下一层)
            helper(curr.right);
        }
    }
}
