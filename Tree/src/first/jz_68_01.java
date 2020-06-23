/**
 * @program: Deli-AlgorithmEx
 * @description: I. 二叉搜索树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-27 11:04
 **/

package first;

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
     * 递归写法
     *
     * @author Shaobo.Qian
     * @date 2020/5/27
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null)
            return null;
        //2.current level
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q); //要加 return,不然就会返回第一层 root
        }
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right; //p,q都在右边,沿着右子节点向下搜索最近公共祖先
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                break;
        }
        return root;
    }
}
