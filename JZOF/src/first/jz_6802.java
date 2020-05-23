/**
 * @program: Deli-AlgorithmEx
 * @description: II. 二叉树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-07 18:41
 **/

package first;

public class jz_6802 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * anki
     * @link:https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
     * 二叉树,后序遍历
     * @question:
     * 0.祖先的定义?最近公共祖先的定义?
     * 1.按二叉树的?序遍历来找最近公共祖先?
     * 2.递归遍历时会出现哪四种情况?分别说明?
     * 3.如何画出整个递归过程?
     * @author Shaobo.Qian
     * @date 2020/5/8
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.terminator
        if (root == null || root == p || root == q)
            return root;
        //2.current level(开始后序遍历)
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //3.返回
        if (left == null && right == null) return null;//left,right 同时为空,说明 root 的的左 / 右子树中都不包含 p,q
        if (left == null) return right;//left 为空,说明p,q都不在当前层 root 的左子树中
        if (right == null) return left;//right 为空,说明p,q都不在当前层 root 的右子树中
        return root;//都不为空,返回
    }

}
