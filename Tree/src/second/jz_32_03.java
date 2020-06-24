/**
 * @program: Deli-AlgorithmEx
 * @description: III. 从上到下打印二叉树 III
 * @author: Shaobo.Qian
 * @create: 2020-06-04 15:44
 **/

package second;

import java.util.*;

public class jz_32_03 {
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
     *
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> currRes = new LinkedList<>();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (res.size() % 2 == 0) { //偶数行
                    currRes.addLast(curr.val);
                } else {//奇数行
                    currRes.addFirst(curr.val);
                }
                if (curr.left!=null)
                    queue.add(curr.left);
                if (curr.right!=null)
                    queue.add(curr.right);
            }
            res.add(currRes);
        }

        return res;
    }
}
