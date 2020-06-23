/**
 * @program: Deli-AlgorithmEx
 * @description: 对称的二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-26 11:55
 **/

package second;

public class jz_28 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        //1.terminator
        if (L ==null && R==null)
            return true;
        //2.current level
        if (L==null || R==null || L.val!=R.val)
            return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
   /* public boolean isSymmetric(TreeNode root) {
        //1.terminator
        if (root == null ||(root.left == null && root.right == null))
            return true;
        //2.current level
        if (root.right == null || root.left != root.right)
            return false;
        //3.drill down
        return isSymmetric(root.left) && isSymmetric(root.right);
    }*/
}
