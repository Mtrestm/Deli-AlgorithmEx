/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的镜像
 * @author: Shaobo.Qian
 * @create: 2020-05-26 11:19
 **/

package second;

public class jz_27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
