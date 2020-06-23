/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的镜像
 * @author: Shaobo.Qian
 * @create: 2020-06-04 18:02
 **/

package third;

public class jz_27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * dfs+后序遍历+分治
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public TreeNode mirrorTree(TreeNode root) {
        //1.terminator
        if (root == null)
            return null;
        //2.分治
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
    /**
     * 递归(自解:错误<===节点之间无法关联)
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public TreeNode mirrorTree0(TreeNode root) {
        if (root == null)
            return root;
        recur(root.left, root.right);
        return root;
    }

    private void recur(TreeNode left, TreeNode right) {
        //1.terminator
        if (left == null && right == null)
            return;
        //2.current level
        TreeNode temp = left;
        left = right;
        right = temp;
        if (left == null || right == null)
            return;
        //3.drill down
        recur(left.left, right.right);
        recur(left.right, right.left);
    }
}
