/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的直径
 * @author: Shaobo.Qian
 * @create: 2020-05-30 16:32
 **/

package second;

public class lc_543 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分治,后序遍历
     * @author Shaobo.Qian
     * @date 2020/5/30
     */

    int nodeNums;

    public int diameterOfBinaryTree(TreeNode root) {
        nodeNums = 1;
        depth(root);
        return nodeNums - 1;
    }

    private int depth(TreeNode root) {
        //1.terminator
        if (root == null)
            return 0;
        //2.current level(分治)
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
//        nodeNums = lDepth + rDepth - 1;
        nodeNums = Math.max(nodeNums, lDepth + rDepth + 1);//取同一层中最大的 nodeNums
        //3.合并结果
        return Math.max(lDepth, rDepth) + 1;
    }

}
