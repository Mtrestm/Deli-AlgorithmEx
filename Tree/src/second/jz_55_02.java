/**
 * @program: Deli-AlgorithmEx
 * @description: 平衡二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-30 17:48
 **/

package second;

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
     * 后序遍历+剪枝
     *
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public boolean isBalanced(TreeNode root) {

        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        //1.terminator
        if (node == null)
            return 0;
        //2.current level(后序遍历)
        int lDepth = depth(node.left);
        if (lDepth == -1)//剪枝
            return -1;
        int rDepth = depth(node.right);
        if (rDepth == -1)
            return -1;
        if (Math.abs(lDepth - rDepth) > 1)
            return -1;
        return Math.max(lDepth, rDepth) + 1;
    }
}
