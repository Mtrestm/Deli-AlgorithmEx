/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的右视图
 * @author: Shaobo.Qian
 * @create: 2020-04-22 05:41
 **/

package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @question 1:画出广度优先搜索的轨迹图(二叉树层序遍历) 2.如何利用二叉树层序遍历的思想来解该题? 3.将遍历到的元素加入到结果集中的条件?
 * 4.如何扩展队列?
 * BFS
 * @author Shaobo.Qian
 * @date 2020/4/22
 */
public class lc_199 {
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

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        //1.创建容器
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //2.循环当前容器中所有的元素,判断是否找到目标
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                //3.根据题目需求(这里就是按层序遍历的顺序扩张),找到新节点(最右边的元素加入结果集),对元素进行扩张并放入队列
                if (i == size - 1) {
                    res.add(currNode.val);
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        return res;
    }
}
