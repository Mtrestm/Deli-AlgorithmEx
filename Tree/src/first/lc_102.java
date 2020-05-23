/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的层序遍历
 * @author: Shaobo.Qian
 * @create: 2020-05-13 18:18
 **/

package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc_102 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevelRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                currLevelRes.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right !=null)
                    queue.add(curr.right);
            }
            res.add(currLevelRes);
        }
        return res;
    }
}
