/**
 * @program: Deli-AlgorithmEx
 * @description: 从上到下打印二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-02 06:34
 **/

package first;

import java.util.*;

public class jz_32_1 {
    class TreeNode{
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
     * BFS
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[]{};
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                result.add(curr.val);
                if (curr.left !=null)
                    queue.add(curr.left);
                if (curr.right !=null)
                    queue.add(curr.right);
            }
        }


        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
