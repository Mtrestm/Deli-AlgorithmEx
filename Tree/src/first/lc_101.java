/**
 * @program: Deli-AlgorithmEx
 * @description: 对称二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-31 06:00
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;

public class lc_101 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归(分治)
     *
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public boolean isSymmetric(TreeNode root) {

        return root == null || (recur(root.left, root.right));
    }

    private boolean recur(TreeNode L, TreeNode R) {
        //1.terminator
        if (L == null && R == null)
            return true;
        //2.current level
        if (L == null || R == null || L.val != R.val)
            return false;
        //3.drill down
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    /**
     * 迭代
     *
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public boolean isSymmetric1(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2==null)
                continue;
            if (t1 == null || t2 ==null || t1.val !=t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
       /* while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            if (r1 == null || r2 == null || r1.val != r2.val)
                return false;
            if (r1.left != null && r1.right == null)
                return false;
            if (r1.right != null && r2.left == null)
                return false;
            if (r1.left != null) {
                queue.add(r1.left);
                queue.add(r2.right);
            }
            if (r1.right != null) {
                queue.add(r1.right);
                queue.add(r2.left);
            }
        }*/

        return true;
    }
}
