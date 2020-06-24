/**
 * @program: Deli-AlgorithmEx
 * @description: 对称的二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-01 17:16
 **/

package first;

public class jz_28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * @question:
     * 1.对于树中 任意两个对称节点L和R ，一定有满足哪三个条件?
     * 2.递归终止条件是?
     * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null)
            return true;
        if (L == null || R == null || L.val != R.val)
            return false;

        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    /**
     * dfs (未解出)
     *
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public boolean isSymmetric1(TreeNode root) {
        //1.terminator
        if (root.left == null && root.right == null)
            return true;
        if ((root.left != null && root.left.left != root.right.right) || (root.right != null && root.left.right != root.right.left)) {
            return false;
        }
        //2.current level
        return isSymmetric1(root.left) && isSymmetric1(root.right);//3.drill down
    }
}
