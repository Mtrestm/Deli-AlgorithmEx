/**
 * @program: Deli-AlgorithmEx
 * @description: 从上到下打印二叉树 II
 * @author: Shaobo.Qian
 * @create: 2020-05-02 06:36
 **/

package first;

import java.util.*;

public class jz_32_2 {
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
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        //1.创建容器
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevelList = new ArrayList<>();
            //2.处理当前层元素,收集结果
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                currLevelList.add(curr.val);
                //3.元素扩容
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }
            res.add(currLevelList);
        }

        return res;
    }
}
