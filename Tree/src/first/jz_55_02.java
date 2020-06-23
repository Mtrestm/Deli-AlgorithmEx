/**
 * @program: Deli-AlgorithmEx
 * @description: 平衡二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-28 15:35
 **/

package first;

public class jz_55_02 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 后序遍历(由底自定)
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public boolean isBalanced(TreeNode root) {

        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        //1.terminator
        if (root == null)
            return 0;
        //2.current level(按左右根顺序,如果是-1说明不是平衡树,剪枝,直接返回)
        int lDepth = recur(root.left);//3.drill down
        if (lDepth == -1)
            return -1;
        int rDepth = recur(root.right);
        if (rDepth == -1)
            return -1;
        return Math.abs(lDepth - rDepth) < 2 ? Math.max(lDepth, rDepth) + 1 : -1;
    }
    /**
     * dfs(前序遍历)
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public boolean isBalanced1(TreeNode root) {
        //1.terminator
        if (root == null)
            return true;
        //2.current level(先序遍历,先判断根节点的情况)
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if (Math.abs(lDepth - rDepth) > 1)
            return false;
        return isBalanced1(root.left) && isBalanced1(root.right);
    }
    /**
     * 节点的深度
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    int depth(TreeNode node) {
        //1.terminator
        if (node == null)
            return 0;
        //3.drill down
        int lDepth = depth(node.left);
        int rDepth = depth(node.right);
        //2.current level
        return Math.max(lDepth, rDepth) + 1;
    }
}
