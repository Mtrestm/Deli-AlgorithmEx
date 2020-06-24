/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉搜索树的第k大节点
 * @author: Shaobo.Qian
 * @create: 2020-06-04 15:16
 **/

package second;

public class jz_54 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * (中序遍历的倒序)
     *
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    int rank, res;

    public int kthLargest(TreeNode root, int k) {

        rank = k; //rank-->this.k

        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        //1.terminator
        if (node == null)
            return;
        //2.current level
        dfs(node.right);
        System.out.println("node = "+ rank +" "+ node.val);
        if (--rank == 0) {
            res = node.val;
//            return;
        }
        dfs(node.left);
    }
}
