/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的直径
 * @author: Shaobo.Qian
 * @create: 2020-05-26 07:35
 **/

package first;

public class lc_543 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int nodeNums;
    public int diameterOfBinaryTree(TreeNode root) {
        nodeNums = 1;
        //二叉树的直径相当于求
        depth(root);
        return nodeNums - 1;
    }

    private int depth(TreeNode root) {
        //1.terminator
        if(root == null)
            return 0;
        //2.current level
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        nodeNums = Math.max(nodeNums, lDepth + rDepth + 1);
//        return lDepth + rDepth + 1;
        return Math.max(lDepth, rDepth) + 1;
    }
}
