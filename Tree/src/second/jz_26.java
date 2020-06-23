/**
 * @program: Deli-AlgorithmEx
 * @description: 树的子结构
 * @author: Shaobo.Qian
 * @create: 2020-05-30 16:14
 **/

package second;

public class jz_26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归+ 先序遍历
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode node, TreeNode B) {
        //1.terminator
        if (B == null)
            return true;
        //2.current level(先序遍历)
        if (node == null || node.val != B.val)
            return false;
        //3.drill down
        return recur(node.left, B.left) && recur(node.right, B.right);
    }
}
