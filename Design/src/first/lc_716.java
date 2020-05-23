/**
 * @program: Deli-AlgorithmEx
 * @description: 最大栈
 * @author: Shaobo.Qian
 * @create: 2020-03-07 21:08
 **/

package first;

import java.util.Stack;

public class lc_716 {
    class MaxStack {
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            this.stack = new Stack<>();
            this.maxStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }
        }

        public int pop() {
            int res = stack.isEmpty() ? -1 : stack.pop();
            if (!maxStack.isEmpty() && res == maxStack.peek()) {
                maxStack.pop();
            }
            return res;
        }

        public int top() {

            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int peekMax() {

            return maxStack.isEmpty() ? -1 : maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> temp = new Stack<>();
            while (top() != max) {
                temp.push(pop());
            }
            pop();
            while (!temp.isEmpty()) push(temp.pop());
            return max;
        }
    }
}
