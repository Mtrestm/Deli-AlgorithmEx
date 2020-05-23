/**
 * @program: Deli-AlgorithmEx
 * @description: 括号生成
 * @author: Shaobo.Qian
 * @create: 2020-04-10 07:37
 **/

package first;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc_22_2 {
    class Node{
        int left;
        int right;
        String currStr;

        public Node(int left, int right, String currStr) {
            this.left = left;
            this.right = right;
            this.currStr = currStr;
        }
    }
    /**
     * @question 模拟栈调用
     * @author Shaobo.Qian
     * @date 2020/4/10
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(new Node(n, n, ""));
        //模拟递归栈
        while (!stack.isEmpty()) {
            //取出栈的最底部元素
            Node currNode = stack.removeLast();
            if (currNode.left == 0 && currNode.right == 0) {
                result.add(currNode.currStr);
            }
            if (currNode.left > 0) {
                //加到栈的底部
                stack.addLast(new Node(currNode.left - 1, currNode.right, currNode.currStr + "("));
            }
            if (currNode.right > 0 && currNode.right > currNode.left) {
                //加到栈的底部
                stack.addLast(new Node(currNode.left, currNode.right - 1, currNode.currStr + ")"));
            }
        }


        return  result;
    }
}
