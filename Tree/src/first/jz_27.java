/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的镜像
 * @author: Shaobo.Qian
 * @create: 2020-05-28 18:14
 **/

package first;

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
     * 递归
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public TreeNode mirrorTree(TreeNode root) {
        //1.terminator
        if (root == null)
            return null;
        TreeNode temp = root.left;//注意,因为下面的 root.left 已经改变了
        //2.current level(分治)
        root.left = mirrorTree(root.right);//3.drill down
        root.right = mirrorTree(temp);
        //3.合并子问题的结果
        return root;
    }

}
