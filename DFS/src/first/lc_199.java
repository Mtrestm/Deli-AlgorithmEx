/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的右视图
 * @author: Shaobo.Qian
 * @create: 2020-04-22 05:21
 **/

package first;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @question 1:画出深度优先搜索的轨迹图 2.如何利用二叉树先序遍历的思想来解该题? 3.将遍历到的元素加入到结果集中的条件?
 * DFS
 * @author Shaobo.Qian
 * @date 2020/4/22
 */
public class lc_199 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int usedLevel = -1;//标记当前已存储二叉树右边的元素的最大层
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();//存储结果
        dfs(root, 0, res);

        return res;
    }

    private void dfs(TreeNode node, int currLevel, List<Integer> res) {
        //terminator
        if (node == null)
            return;
        //current level
        if (currLevel > usedLevel) {
            usedLevel = currLevel;
            res.add(node.val);
        }
        //drill down
        dfs(node.right, currLevel + 1, res);
        dfs(node.left, currLevel + 1, res);
    }
}
