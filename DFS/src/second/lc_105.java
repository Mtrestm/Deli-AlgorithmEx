/**
 * @program: Deli-AlgorithmEx
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-23 16:11
 **/

package second;

import java.util.HashMap;
import java.util.Map;

public class lc_105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    private int[] preorder;
    private Map<Integer, Integer> reverses;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        // 可以不做判断，因为题目中给出的数据都是有效的
        if (preLen != inLen) {
            return null;
        }
        this.preorder = preorder;

        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        reverses = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            reverses.put(inorder[i], i);
        }


        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
        //1.terminator
        if (preL > preR || inL > inR) {
            return null;
        }
        // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);
        //取出在中序遍历数组中的索引
        int pivotIdx = reverses.get(pivot);
        root.left = buildTree(preL + 1, preL + (pivotIdx - inL), inL, pivotIdx - 1);
        root.right = buildTree(preL + (pivotIdx - inL) + 1, preR, pivotIdx + 1, inR);
        return root;
    }

}
