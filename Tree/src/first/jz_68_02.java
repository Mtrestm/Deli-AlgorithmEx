/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-27 15:31
 **/

package first;

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
     * 后序遍历(分治)
     * @author Shaobo.Qian
     * @date 2020/5/27
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null || root == p || root == q)
            return root;
        //2.current level
        //2.1在左子树中找
        TreeNode left = lowestCommonAncestor(root.left, p, q);//后序遍历:左
        //2.2在右子树中找
        TreeNode right = lowestCommonAncestor(root.right, p, q);//后序遍历:右
        if (left == null && right == null)
            return null;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;//后序遍历:根
    }
}
