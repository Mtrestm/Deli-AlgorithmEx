/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉树的右视图
 * @author: Shaobo.Qian
 * @create: 2020-05-28 16:43
 **/

package second;

import java.util.ArrayList;
import java.util.List;

public class lc_199 {
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

    int usedLevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root,0,res);
        return res;
    }

    private void dfs(TreeNode node, int currLevel, List<Integer> res) {
        //1.terminator
        if (node == null)
            return;
        //2.current level(按根右左的顺序先序遍历,先处理根节点)
        if (currLevel > usedLevel) {
            usedLevel = currLevel;
            res.add(node.val);
        }
        //3.drill down
        dfs(node.right, currLevel + 1, res);
        dfs(node.left, currLevel + 1, res);
    }


}
