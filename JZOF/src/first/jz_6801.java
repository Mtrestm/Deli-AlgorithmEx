/**
 * @program: Deli-AlgorithmEx
 * @description: I. 二叉搜索树的最近公共祖先
 * @author: Shaobo.Qian
 * @create: 2020-05-07 18:40
 **/

package first;

public class jz_6801 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * anki
     * @link: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
     * @question:
     * 1.最近公共祖先的定义?
     * 2.root 是 p,q 的最近公共祖先,则可能存在哪三种情况?
     * 3.二叉树中,p,q 与root 子树之间的关系存在哪三种情况?
     * 4.画图说明,如何通过迭代法或者递归法找到p,q 的最近公共祖先?
     * 5.为什么递归写法时每一个 if语句里都要 return?
     * 二叉树 迭代法
     * @author Shaobo.Qian
     * @date 2020/5/7
     */
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)//1.terminator
            return null;
        //2.每一层要么向左,或者向右下一层
        if (root.val < p.val && root.val < q.val)
//            lowestCommonAncestor(root.right, p, q);
            return lowestCommonAncestor(root.right, p, q); //这里要加 return, 每个判断都不加 return(不提前返回),就会返回第一层的节点(root) 了(第一个公共祖先)<====可以去掉测试
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        //3.但无法去向下层时,返回当前层节点
        return root;
    }

    //迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            if (root.val > p.val && root.val > q.val)// p,q 都在 root 的左子树中
                root = root.left;// 遍历至左子节点
            else if (root.val < p.val && root.val < q.val)// p,q 都在 root 的右子树中
                root = root.right;// 遍历至右子节点
            else break;
        }
        return root;
    }
}
