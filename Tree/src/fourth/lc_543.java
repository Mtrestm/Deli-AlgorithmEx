/**
 * @program: DeliAlgorithmEx
 * @description: 二叉树的直径
 * @author: Shaobo.Qian
 * @create: 2020-06-05 16:15
 **/

package fourth;

public class lc_543 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 后序遍历 + 分治
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    int nodeNums;
    public int diameterOfBinaryTree(TreeNode root) {
        nodeNums = 1;
        depth(root);
        return nodeNums - 1;
    }

    private int depth(TreeNode node) {
        //1.terminator
        if (node == null)
            return 0;
        //2.current level (后序+分治)
        int lDepth =  depth(node.left);
        int rDepth = depth(node.right);
        nodeNums = Math.max(nodeNums, lDepth + rDepth + 1);
        return Math.max(lDepth, rDepth) + 1;
    }
}
