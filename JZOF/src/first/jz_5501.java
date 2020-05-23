/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:53
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;

public  class jz_5501 {

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
     * @question:
     * 1.dfs+分治思想的更加优雅的写法?
     * 2.请画图说明dfs 的过程?
     * @link: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    int depth = 0;

    public int maxDepth2(TreeNode root) {
        dfs(root, 0);
        return depth;
    }

    /**
     * dfs
     *
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    private void dfs(TreeNode root, int currDepth) {
        //1.terminator
        if (root == null) {
            depth = Math.max(depth, currDepth);
            System.out.println("depth = " + depth);
            return;
        }

        //2.current level
        dfs(root.left, currDepth + 1);
        dfs(root.right, currDepth + 1);
    }

    /**
     * BFS
     *
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }


        return depth;
    }
}

