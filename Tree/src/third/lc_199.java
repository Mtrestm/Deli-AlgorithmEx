/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的右视图
 * @author: Shaobo.Qian
 * @create: 2020-05-31 13:27
 **/

package third;

import java.util.*;

public class lc_199 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


    /**
     * dfs(先序遍历)
     *
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    int usedLevel = -1;

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int currLevel, List<Integer> res) {
        //1.terminator
        if (node == null)
            return;
        //2.current level (先序遍历)
        if (currLevel > usedLevel) {
            usedLevel = currLevel;
            res.add(node.val);
        }
        //3.drill down
        dfs(node.right, currLevel + 1, res);
        dfs(node.left, currLevel + 1, res);
    }

    /**
     * 层序遍历
     *
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    res.add(curr.val);
                }
                if (curr.right != null)
                    queue.add(curr.right);
                if (curr.left != null)
                    queue.add(curr.left);
            }
        }
        return res;
    }
}
