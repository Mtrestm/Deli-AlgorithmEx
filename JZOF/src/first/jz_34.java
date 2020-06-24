/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树中和为某一值的路径
 * @author: Shaobo.Qian
 * @create: 2020-05-02 10:28
 **/

package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class jz_34 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * anki
     * dfs(回溯)
     * 1.本题利用什么进行回溯?如何清楚数据?
     * 2.整个回溯过程是怎样的,如何画图?
     * @link https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int tar) {
        //1.terminator
        if (root == null)
            return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, tar);
        dfs(root.right, tar);
        path.removeLast();//移除当前层元素
    }


}
