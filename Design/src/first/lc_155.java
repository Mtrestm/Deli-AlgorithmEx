/**
 * @program: Deli-AlgorithmEx
 * @description: 最小栈
 * @author: Shaobo.Qian
 * @create: 2020-05-12 17:02
 **/

package first;

import java.util.Stack;

public class lc_155 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> helper;//维护一个单调递增的辅助栈

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack();
            helper = new Stack();
        }

        public void push(int x) {
            stack.push(x);
            if (helper.isEmpty()) {
                helper.push(x);
            } else if (getMin() >= x) {
                helper.push(x);
            }
        }

        public void pop() {
            Integer popNum = stack.pop();
            if (getMin() == popNum) {
                helper.pop();
            }
        }

        public int top() {

            return stack.peek();
        }
        public int getMin() {

            return helper.peek();
        }
    }
}
