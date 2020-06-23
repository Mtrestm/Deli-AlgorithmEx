/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的右视图
 * @author: Shaobo.Qian
 * @create: 2020-05-27 16:25
 **/

package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_199 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


    /**
     * DFS+(先序遍历)
     *
     * @author Shaobo.Qian
     * @date 2020/5/27
     */

    int usedLevel = -1;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //1.terminator
        if (root == null)
            return res;
        dfs(root, 0, res);
        return res;
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/5/27
     */
    private void dfs(TreeNode node, int currLevel, List<Integer> res) {
        //1.terminator
        if (node == null)
            return;
        //2.current level
        if (currLevel > usedLevel) {
            usedLevel = currLevel;
            res.add(node.val);
        }
        //3.drill down
        dfs(node.right, currLevel + 1, res);
        dfs(node.left, currLevel + 1, res);
    }

    /**
     * BFS(层序遍历)
     *
     * @author Shaobo.Qian
     * @date 2020/5/27
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
