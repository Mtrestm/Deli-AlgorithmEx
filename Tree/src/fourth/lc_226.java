/**
 * @program: DeliAlgorithmEx
 * @description: 二叉树的镜像
 * @author: Shaobo.Qian
 * @create: 2020-06-05 16:30
 **/

package fourth;

import java.util.LinkedList;
import java.util.Queue;

public class lc_226 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 后序+分治
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public TreeNode invertTree(TreeNode root) {
        //1.terminator
        if (root == null)
            return null;
        TreeNode temp = root.left;
        //2.subProblem
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        //3. merge result
        return root;
    }

    /**
     * 迭代(借助队列)
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public TreeNode invertTree0(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return root;
    }

    /*
    public TreeNode invertTree0(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left != null) {
                queue.add(left.left);
                queue.add(left.right);
            }
            if (right != null) {
                queue.add(right.left);
                queue.add(right.right);
            }
            TreeNode temp = left;
            left = right;
            right = left;
        }
        return root;
    }
*/
}
