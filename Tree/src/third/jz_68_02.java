/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-31 14:51
 **/

package third;

public class jz_68_02 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     *
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null || root == p || root == q)
            return root;
        //2.current level(分治+后序遍历)
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //3.合并结果
        if (left == null && right == null)
            return null;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;
    }

}
