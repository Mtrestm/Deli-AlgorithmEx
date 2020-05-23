/**
 * @program: Deli-AlgorithmEx
 * @description: 树的子结构
 * @author: Shaobo.Qian
 * @create: 2020-05-01 09:55
 **/

package first;

public class jz_26 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @question:
     * 1.判断树B 是否是树A 的子结构，需完成哪两步工作?
     * 2.如何判断 A中以某个节点作为根节点的子树是否包含 树B?
     * 3.判断 A中以某个节点作为根节点的子树是否包含 树B是的终止条件是哪三个终止条件?
     * 递归
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    private boolean recur(TreeNode A, TreeNode B) {
        //1.terminator
        if (B==null)
            return true;
        if (A==null || A.val!=B.val)
            return false;

        //3.drill down
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}
