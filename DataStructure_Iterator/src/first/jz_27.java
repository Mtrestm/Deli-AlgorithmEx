/**
 * @program: Deli-AlgorithmEx
 * @description: 翻转二叉树/二叉树镜像
 * @author: Shaobo.Qian
 * @create: 2020-05-28 18:51
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class jz_27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解法二:Queue
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left!=null)
                queue.add(curr.left);
            if (curr.right!=null)
                queue.add(curr.right);
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }
    /**
     * 使用辅助栈进行迭代的过程?请画图说明
     * 解法一:stack
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left !=null)
                stack.add(curr.left);
            if (curr.right !=null)
                stack.add(curr.right);
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }
    /**
     * 自解:未解出
     * 迭代+辅助栈
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public TreeNode mirrorTree0(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {

            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null)
                continue;
            else if (t1 == null) {
                t1 = t2;
                t2 = null;

            } else if (t2 == null) {
                t1 = t2;
                t2 = null;

            } else {

            }

            TreeNode temp = t1;
            t1 = t2;
            t2 = temp;
            if (t1 != null) {
                queue.add(t1.left);
                queue.add(t1.right);
            }
            if (t2 != null) {
                queue.add(t2.left);
                queue.add(t2.right);
            }
        }
        return root;
    }
}
