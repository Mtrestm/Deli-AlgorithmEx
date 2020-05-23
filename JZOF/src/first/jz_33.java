/**
 * @program: Deli-AlgorithmEx
 * @description: 二叉搜索树的后序遍历序列
 * @author: Shaobo.Qian
 * @create: 2020-05-02 06:38
 **/

package first;

public class jz_33 {

    /**
     * @link https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     * @question:
     * 1.二叉树的后续遍历的关键是怎么划分左右子树?
     * 2.针对左右子树区间,如何判断是否满足二叉搜索树?
     * 3.如何利用分治的思想求解该题?
     * 分治(递归)
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    public boolean verifyPostorder(int[] postorder) {


        return recur(postorder, 0, postorder.length-1);
    }

    private boolean recur(int[] postorder, int l, int r) {
        //1.terminator
        if (l>=r) return true;
        //2.current level(找出左右子数的分界点)
        int p = l;
        while (postorder[p] < postorder[r]) p++;
        int m = p;
        while (postorder[p]>postorder[r]) p++;
        //3.merge subproblems
        return p == r && recur(postorder, 0, m - 1) && recur(postorder, m, r - 1);
    }
}
