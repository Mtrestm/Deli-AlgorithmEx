/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:52
 **/

package first;

public  class jz_5502 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * anki
     * @link: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
     * @question:
     * 0.本题的两种解法?
     * 1.使用前序遍历+深度判断的问题
     * 2.用二叉树的后序遍历 ,如何剪枝?
     * 3.请画图说明?
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public boolean isBalanced(TreeNode root) {

        return true;
    }
    /**
     * 原解
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }

    /**
     * 求每个节点的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
