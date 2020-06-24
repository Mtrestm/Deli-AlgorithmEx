/**
 * @program: Deli-AlgorithmEx
 * @description: 对称的二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-31 13:46
 **/

package third;

import java.util.LinkedList;
import java.util.Queue;

public class lc_101 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public boolean isSymmetric(TreeNode root) {

        return root == null || recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        //1.terminator
        if (L == null && R== null)
            return true;
        if (L == null || R==null || L.val!=R.val)
            return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    /**
     * 迭代
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null || t1.val!=t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
