/**
 * @program: Deli-AlgorithmEx
 * @description: 深度优先搜索
 * @author: Shaobo.Qian
 * @create: 2020-03-10 21:48
 **/

package first;

/**
 * dfs
 * @question: 二叉树的直径的问题是如何转换成 dfs 的问题的?思路是?(求路径长度就是求什么?)子树的深度如何求?直径上的所有节点数如何求?
 * @author Shaobo.Qian
 * @date 2020/3/10
 * @link https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
 */
public class lc_543 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        int nodeNums;
        public int diameterOfBinaryTree(TreeNode root) {
            nodeNums = 1;//这里写1,下面nodeNums - 1 是为了表达清楚路径=经过的节点数-1这种关系
            depth(root);
            return nodeNums - 1;
        }

        private int depth(TreeNode node) {
            //1.terminator
            if(node == null) return 0;
            //3.drill down
            int lDepth = depth(node.left);// 左儿子为根的子树的深度
            int rDepth = depth(node.right);// 右儿子为根的子树的深度
            //2.current level
            nodeNums = Math.max(nodeNums, lDepth + rDepth + 1); // 计算d_node即L+R+1 并更新ans  <===为什么这里要比较(存储当前节点与之前遍历节点的最长路径,即递归到的有些节点并不影响路径长度,比如图中6号节点并不影响5号父节点的最大深度,因为8号节点真正影响了深度)
            return Math.max(lDepth, rDepth) + 1;// 返回该节点为根的子树的深度
        }
    }
}
