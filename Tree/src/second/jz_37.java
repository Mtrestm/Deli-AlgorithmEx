/**
 * @program: Deli-AlgorithmEx
 * @description: 序列化二叉树
 * @author: Shaobo.Qian
 * @create: 2020-06-04 16:03
 **/

package second;

import java.util.LinkedList;
import java.util.Queue;

public class jz_37 {
    public class Codec {
        class TreeNode {
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
            StringBuilder res = new StringBuilder();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            res.append("[");
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
            return res.append("]").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data))
                return null;
            String[] buffer = data.substring(1, data.length()-1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(buffer[0]));
            //使用队列作为辅助数据结构
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int idx = 1;//buffer中下一个要被处理的元素对应的索引
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
//                if (!"null".equals(curr.val)) {
                if (!"null".equals(buffer[idx])) {
                    curr.left = new TreeNode(Integer.parseInt(buffer[idx]));
                    queue.add(curr.left);
                }
                idx++;
                if (!"null".equals(buffer[idx])) {
                    curr.right = new TreeNode(Integer.parseInt(buffer[idx]));
                    queue.add(curr.right);
                }
                idx++;
            }
            return root;
        }

    }
}
