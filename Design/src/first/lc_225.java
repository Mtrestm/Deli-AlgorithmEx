/**
 * @program: Deli-AlgorithmEx
 * @description: 用队列实现栈
 * @author: Shaobo.Qian
 * @create: 2020-03-01 08:29
 **/

package first;

import java.util.ArrayDeque;

public class lc_225 {
    class MyStack {

        private ArrayDeque<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.push(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            Integer top = -1;
            if (!empty()) {
                top = queue.remove();
            }
            return top;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (!empty())
                return queue.peek();
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
