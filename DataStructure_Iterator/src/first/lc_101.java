/**
 * @program: Deli-AlgorithmEx
 * @description: 对称的二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-28 14:56
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;

public class lc_101 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 迭代
     * @question
     * 1.利用什么数据结构进行迭代?
     * 2.本题思路和 BFS 的异同(扩充元素方式的异同)?
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public boolean isSymmetric(TreeNode root) {
        //1.申请队列作为辅助数据结构并初始化
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        //2.迭代+扩充元素+条件判断
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2==null || t1.val!=t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
