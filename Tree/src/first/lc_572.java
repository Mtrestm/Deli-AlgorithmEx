/**
 * @program: Deli-AlgorithmEx
 * @description: 另一个树的子树
 * @author: Shaobo.Qian
 * @create: 2020-05-20 13:34
 **/

package first;

public class lc_572 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //1.terminator
        if (s == null || t == null)
            return false;

        //2.current level
        if (s.val == t.val && isSameTree(s, t))
            return true;
        //3.drill down
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode root, TreeNode t) {
        //1.terminator
        if (root == null && t == null)
            return true;
        //2.current level
        if (root == null || t == null || root.val != t.val)
            return false;
        //3.drill down
        return isSameTree(root.left, t.left) && isSameTree(root.right, t.right);
    }
}
