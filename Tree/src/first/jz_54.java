/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉搜索树的第k大节点
 * @author: Shaobo.Qian
 * @create: 2020-05-30 16:51
 **/

package first;

public class jz_54 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    /**
     * 中序遍历的倒序
     *
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
//    List<Integer> res = new ArrayList<>();
    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
//        return res.get(k - 1);
        return res;
    }

    private void dfs(TreeNode root) {
        //1.terminator
        if (root == null)
            return;
        //2.current level
        dfs(root.right);
        if (k == 0) {//剪枝
            return;
        }
        if (--k == 0) {
            res = root.val;//每经历一个节点将 k-1}
        }
//        res.add(root.val);
//        if (res.size() == k)
//            return;
        dfs(root.left);

    }
}
