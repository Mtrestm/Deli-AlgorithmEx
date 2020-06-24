/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的深度
 * @author: Shaobo.Qian
 * @create: 2020-06-04 16:48
 **/

package third;

public class jz_55_01 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * DFS+分治
     *
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public int maxDepth(TreeNode root) {
        //1.terminator
        if (root == null)
            return 0;
        //2.current level(分治)
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;
    }
}
