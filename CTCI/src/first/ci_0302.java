/**
 * @program: Deli-AlgorithmEx
 * @description: 栈的最小值
 * @author: Shaobo.Qian
 * @create: 2020-03-07 20:25
 **/

package first;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 添加一个辅助栈和辅助的双端队列
 * @author Shaobo.Qian
 * @date 2020/3/7
 */
public class ci_0302 {
    class MinStack {
        Stack<Integer> stack;
        Deque<Integer> deque; //辅助队列,保存最小值,单调递减

        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new Stack<>();
            this.deque = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (deque.isEmpty() || x < deque.peekLast()) {
                deque.offer(x);
            }
        }

        public void pop() {
            int target = stack.isEmpty() ? -1 : stack.pop();
            if (!deque.isEmpty() && target == deque.peekLast()) {
                deque.pollLast();
            }
        }

        public int top() {

            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            return deque.isEmpty() ? -1 : deque.peekLast();
        }

    }
}
