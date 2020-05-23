/**
 * @program: Deli-AlgorithmEx
 * @description: 重建二叉树
 * @author: Shaobo.Qian
 * @create: 2020-03-05 12:05
 **/

package first;

import java.util.HashMap;
import java.util.Map;

public class jz_07 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /**
     * todo:分治+递归
     * @question 1:前序遍历和中序遍历的数组分别确定了树的什么2.构建二叉树元素和索引分别在哪个数组中取3.二叉树左右子树对应的前序遍历数组和中序遍历数组的索引边界如何确定
     * @author Shaobo.Qian
     * @date 2020/3/5
     * @link:https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/er-cha-shu-de-qian-xu-bian-li-fen-zhi-si-xiang-by-/
     */

    private int[] preorder;
    private Map<Integer, Integer> reverses;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen!=inLen) return null;

        this.preorder = preorder;
        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        reverses = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            reverses.put(inorder[i], i);//存入中序遍历的数组中元素和索引对
        }

        return buildTree(0, preLen-1, 0, inLen-1);
    }

    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
        //1.terminator
        if (preL > preR || inL > inR) {
            return null;
        }
        //2.处理当前层逻辑
        //2.1构建根节点,构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素(构建二叉树的元素从前序遍历的数组中取)
        //前序遍历的数组最左边对应的是根节点
        TreeNode root = new TreeNode(preorder[preL]);
        //2.2取出根节点在中序遍历中对应的索引,根节点对应的索引把中序遍历数组划成左右两个数组分别对应左子树和右子树,通过pivotIndex - inL来确定左子树的长度,从而确定左右子树在前序遍历数组和中序遍历数组中的索引边界
        Integer pivotIndex = reverses.get(preorder[preL]);
        //2.2分治,左子树(drill down);下面对应的是左子树在
        root.left = buildTree(preL + 1, preL + (pivotIndex-inL), inL, pivotIndex - 1);
        root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);

        return root;
    }
}
