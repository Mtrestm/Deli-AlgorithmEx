/**
 * @program: Deli-AlgorithmEx
 * @description: 序列化二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-02 10:30
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @question:
 * 0.如何利用层序遍历来实现序列化和反序列化
 * 1.反序列化的步骤?
 * 2.如何画图描述反序列化的过程?
 * 3.序列化的步骤?
 * 4.如何画图描述序列化的过程?
 * @link https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/mian-shi-ti-37-xu-lie-hua-er-cha-shu-ceng-xu-bian-/
 * @author Shaobo.Qian
 * @date 2020/5/3
 */
public class jz_37 {
    public class Codec {
        class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "[]";
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    res.append(curr.val + ",");
                    queue.add(curr.left);
                    queue.add(curr.right);
                } else {
                    res.append("null,");
                }
            }
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();
        }



        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) return null;
            //反序列话过程/目的:要将数组中的元素全部处理完构建成二叉树
            String[] vals = data.substring(1, data.length() - 1).split(",");
            //构建根节点
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            //记录待处理的节点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int idx = 1;//vals数组中下一个要被处理 的元素索引
            //2.将待处理的节点和它的子节点关联
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (!"null".equals(vals[idx])) {
                    curr.left = new TreeNode(Integer.parseInt(vals[idx]));
                    queue.add(curr.left);
                }
                idx++;
                if (!"null".equals(vals[idx])) {
                    curr.right = new TreeNode(Integer.parseInt(vals[idx]));
                    queue.add(curr.right);
                }
                idx++;
            }
            return root;
        }
    }
}
