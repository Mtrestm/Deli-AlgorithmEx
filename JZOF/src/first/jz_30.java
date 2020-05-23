/**
 * @program: Deli-AlgorithmEx
 * @description: 包含min函数的栈
 * @author: Shaobo.Qian
 * @create: 2020-05-01 17:24
 **/

package first;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class jz_30 {
    /**
     * initialize your data structure here.
     */
    class MinStack {
        Queue<Integer> queue;
        Stack<Integer> stack;

        public MinStack() {
            this.queue = new PriorityQueue<>(Integer::compareTo);
            this.stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            queue.add(x);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {

            return stack.peek();
        }

        public int min() {
            if (queue == null) {
                throw new RuntimeException();
            } else {
                while (!queue.isEmpty()) {
                    int top =  queue.peek();
                    if (stack.contains(top)) {
                        return top;
                    } else {
                        queue.poll();
                    }
                }
                throw new RuntimeException();
            }
        }
    }
}
