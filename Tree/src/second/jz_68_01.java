/**
 * @program: Deli-AlgorithmEx
 * @description: I. 二叉搜索树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-28 17:52
 **/

package second;

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
     * 递归
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null)
            return null;
        //2.current level
        if (root.val < p.val && root.val < q.val) {
            //3.1drill down(p,q值大,去右子树搜索)
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            //3.2drill down(p,q值骁,去左子树搜索)
            return lowestCommonAncestor(root.left, p, q);
        }
        //p,q 在 root 两侧,返回 root(最近公共祖先)
        return root;
    }

    /**
     * 迭代
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
        //没有找到
        return null;
    }
}
