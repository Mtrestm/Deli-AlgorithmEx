/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的深度
 * @author: Shaobo.Qian
 * @create: 2020-05-28 17:04
 **/

package second;

import java.util.LinkedList;
import java.util.Queue;

public class jz_55_01 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * dfs(后序遍历+分治)
     *
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public int maxDepth(TreeNode root) {
        //1.terminator
        if (root == null)
            return 0;
        //2.current level(后序+分治)
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        //3.处理子问题的结果
        return Math.max(lDepth, rDepth) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            depth++;
        }
        return depth;
    }
}
