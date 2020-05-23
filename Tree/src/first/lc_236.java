/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-10 16:05
 **/

package first;

public class lc_236 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null || root== p || root==q)
            return root;
        //3.drill down
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //2.current level
        if (left == null && right == null)
            return null;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;
    }

}
