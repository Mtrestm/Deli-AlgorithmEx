/**
 * @program: Deli-AlgorithmEx
 * @description: 括号生成
 * @author: Shaobo.Qian
 * @create: 2020-04-10 05:01
 **/

package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * question:1.为什么搜索几乎都是用深度优先遍历（回溯算法）,而不用广度优先搜索  2.使用广度优先搜索的模板分为哪三步和对应本题的思路
 */
public class lc_22_1 {
    class Node {
        int left; //剩余左括号数量
        int right;//剩余右括号数量
        private String currStr;//当前得到的字符串

        public Node(int left, int right, String currStr) {
            this.left = left;
            this.right = right;
            this.currStr = currStr;
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;
        //1.创建容器
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, n, ""));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            //2.循环当前容器中所有的元素,判断是否找到目标
            if (currNode.left == 0 && currNode.right == 0) {
                result.add(currNode.currStr);
            }
            //3.找到新节点,并放入队列
            if (currNode.left > 0) {
                queue.offer(new Node(currNode.left - 1, currNode.right, currNode.currStr + "("));

            }
            if (currNode.right > 0 && currNode.right > currNode.left) {
                queue.offer(new Node(currNode.left, currNode.right - 1, currNode.currStr + ")"));
            }
        }
        return result;
    }

}
