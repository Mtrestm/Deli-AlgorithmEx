/**
 * @program: Deli-AlgorithmEx
 * @description: 对称的二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-28 14:11
 **/

package first;

public class jz_28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left==null && root.right == null))
            return true;
        if (root.left == null || root.right==null)
            return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null && right != null) {
            if (left.val !=right.val)
                return false;
            left = left.left;
            right = right.right;
        }


        return true;
    }

    /**
     * 递归
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public boolean isSymmetric1(TreeNode root) {

        return root == null || recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        //1.terminator
        if (L == null && R == null)
            return true;
        if (L == null || R == null || L.val != R.val)
            return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
