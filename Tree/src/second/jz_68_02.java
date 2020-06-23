/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-28 15:19
 **/

package second;

public class jz_68_02 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator(搜索到p或者q就返回)
        if (root == null || root == p || root == q)
            return root;
        //2.分治,在左右子树中分别搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //3.针对结果所有情况处理
        if (left == null && right == null)
            return null;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;
    }
}
