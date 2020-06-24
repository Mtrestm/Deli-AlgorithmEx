/**
 * @program: Deli-AlgorithmEx
 * @description: 从上到下打印二叉树 III
 * @author: Shaobo.Qian
 * @create: 2020-05-02 06:37
 **/

package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class jz_32_3 {

    public static void main(String[] args) {
        System.out.println("args = " + 2 % 2);
    }

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
     * anki
     * @question:
     * 1.利用什么性质来实现层序遍历时交错打印?
     * 2.实现层序遍历时交错打印的思路?
     * @link: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i <size; i++) {
                TreeNode curr = queue.poll();
                if (res.size() % 2 == 0) {
                    temp.addLast(curr.val);
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

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int rSize = res.size();
            List<Integer> currLevelList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = queue.poll();
                currLevelList.add(curr.val);
                if (rSize % 2 == 0) {
                    System.out.println("rSize = " + rSize);
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                }
            }
            res.add(currLevelList);
        }
        return res;
    }
}
