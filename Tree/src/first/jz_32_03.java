/**
 * @program: Deli-AlgorithmEx
 * @description: 从上到下打印二叉树Ⅲ
 * @author: Shaobo.Qian
 * @create: 2020-05-31 13:59
 **/

package first;

import java.util.*;

public class jz_32_03 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();//借助链表结构
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (res.size() % 2 == 0) {
                    temp.addLast(curr.val);
                    System.out.println("curr = " + curr.val);
                } else {
                    temp.addFirst(curr.val);
                }

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            res.add(temp);
        }
        return res;
    }
}
