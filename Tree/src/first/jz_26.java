/**
 * @program: Deli-AlgorithmEx
 * @description: 树的子结构
 * @author: Shaobo.Qian
 * @create: 2020-05-26 10:14
 **/

package first;

public class jz_26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode node, TreeNode b) {
        if (b == null)
            return true;
        if (node == null || node.val !=b.val)
            return false;
        return recur(node.left, b.left) && recur(node.right, b.right);
    }

    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        //1.terminator
        if (A == null || B == null)
            return false;
        //2.current level
        //判断A 中节点值是否包含 B 中的根节点值
        if (containTree(A, B)) {
            return true;
        }
        //3.drill down
        return isSubStructure1(A.left, B) || isSubStructure1(A.right, B);
    }
    /**
     * 按相同顺序遍历A 中的子树和 B树是否完全一致
     */
    private boolean containTree(TreeNode node, TreeNode b) {
        //1.terminator
        if (b == null)
            return true;
        if (node == null || node.val != b.val)
            return false;
        //2.current level
        //3.drill down
        return containTree(node.left, b.left) && containTree(node.right, b.right);
    }
}
