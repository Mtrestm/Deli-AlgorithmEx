import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: DeliAlgorithmEx
 * @description: 从先序遍历还原二叉树
 * @author: Shaobo.Qian
 * @create: 2020-06-23 14:42
 **/

public class lc_1028 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * @question:
     * 1.根据题意,如何确定当前节点的 level（深度）?
     * 2.根据题意,如何确定各节点在二叉树种的位置?
     * 3.记当前节点为T,上一个节点为S,那么T,S 节点实际上只有哪两种情况?
     * 4.上面说的两种情况里,当前节点的深度和栈中元素个数有什么关系?分别如何处理来构造当前节点?
     * 5.如何画图表述整个过程?
     * @author Shaobo.Qian
     * @date 2020/6/23
     */
    public TreeNode recoverFromPreorder(String S) {
        //1-2--3--4-5--6--7
        //存储当前节点的路径
        Deque<TreeNode> path = new LinkedList<>();
        //存储字符串中的位置
        int pos = 0;
        while (pos < S.length()) {
            //1.获取当前层数
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            //2.获取当前的节点值
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            //3.构造当前节点
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                //如果当前节点的深度==当前路径长度（前一个节点是当前节点的父节点）
                if (!path.isEmpty()) {
                    //如果不是第一个节点，前一个节点的左子节点为当前节点
                    path.peek().left = node;
                }
            } else {
                //如果当前节点的深度！=当前路径长度（前一个节点不是当前节点的父节点）
                while (level != path.size()) {
                    //通过queue弹出其他子节点，找到当前节点的父节点
                    path.pop(); //因为是先序遍历所以弹出元素不会影响结果(当前层以下的层节点都被构造过了)
                }
                // 找到父节点，因为此时左子节点已确定，所以赋值给右子节点
                path.peek().right = node;
            }
            // 构造完当前节点后,放入queue中
            path.push(node);

        }
        //全部弹出,只剩根节点
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }
}
