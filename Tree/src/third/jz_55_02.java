/**
 * @program: Deli-AlgorithmEx
 * @description: 平衡二叉树
 * @author: Shaobo.Qian
 * @create: 2020-06-04 17:37
 **/

package third;

public class jz_55_02 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * dfs+后序遍历 +剪枝
     *
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public boolean isBalanced0(TreeNode root) {
        if (root == null)
            return true;

        return depth0(root) != -1;
    }

    private int depth0(TreeNode node) {
        //1.terminator
        if (node == null)
            return 0;
        int lDepth = depth0(node.left);
        if (lDepth == -1)
            return -1;
        int rDepth = depth0(node.right);
        if (rDepth == -1)
            return -1;
        return Math.abs(lDepth - rDepth) > 1 ? -1 : Math.max(lDepth, rDepth) + 1;
    }


    /**
     * dfs+ 先序遍历
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        return Math.abs(lDepth - rDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        int lDepth = depth(node.left);
        int rDepth = depth(node.right);
        return Math.max(lDepth, rDepth) + 1;
    }
}
