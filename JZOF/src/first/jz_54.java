/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:56
 **/

package first;

public  class jz_54 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @link: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
     * 1.实际上考察的是二叉树的?序遍历====从大到小即什么顺序?
     * 2.递归的方式代码怎么写?
     * 3.请画图整个过程说明?
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);

        return res;
    }


    private void dfs(TreeNode root) {
        //按中序遍历的倒序-->遍历:即右中左
        if (root == null)
            return;
        dfs(root.right);
        if (k == 0) return;
        if(--k == 0) res = root.val;//每经历一个一个节点将k-1
        dfs(root.left);

    }
}


