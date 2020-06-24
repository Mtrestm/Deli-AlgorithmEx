/**
 * @program: Deli-AlgorithmEx
 * @description: I. 二叉搜索树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-06-04 17:24
 **/

package third;

public class jz_68_01 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * dfs
     *
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null || root == p || root == q)
            return root;
        //2.current level
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    /**
     * 迭代
     *
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                break;
        }
        return root;
    }
}
