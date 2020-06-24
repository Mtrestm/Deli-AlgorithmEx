/**
 * @program: Deli-AlgorithmEx
 * @description: 序列化二叉树
 * @author: Shaobo.Qian
 * @create: 2020-05-31 11:36
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;

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

            StringBuilder res = new StringBuilder();
            res.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    res.append("null,");
                } else {
                    res.append(curr.val+",");
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            res.deleteCharAt(res.length() - 1);
            return res.append("]").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data))
                return null;
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int idx = 1;//下一个要处理的元素的索引
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
