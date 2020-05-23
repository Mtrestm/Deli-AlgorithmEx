/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的镜像
 * @author: Shaobo.Qian
 * @create: 2020-05-01 09:56
 **/

package first;

public class jz_27 {
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @question:
     * 1.递归的终止条件?
     * 2.为什么需要暂存 root节点的左子节点?
     * 3.本题递归的思路是怎样的?
     * 递归
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public TreeNode mirrorTree(TreeNode root) {
        //1.terminator
        if (root == null) {
            return null;
        }

        //2.current level
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);//3.drill down
        root.right = mirrorTree(temp);

        return root;
    }
}
