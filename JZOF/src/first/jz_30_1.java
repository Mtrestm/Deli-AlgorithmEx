/**
 * @program: Deli-AlgorithmEx
 * @description: 包含min函数的栈
 * @author: Shaobo.Qian
 * @create: 2020-05-02 06:22
 **/

package first;

import java.util.Stack;

//todo:
/**
 * @question:
 * 1.如何维护最小栈(辅助栈)
 * 2.最小栈中存储的元素的特点?
 * @author Shaobo.Qian
 * @date 2020/5/2
 * @link https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
public class jz_30_1 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() ||x <= min()) {
                minStack.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if (min() == pop) {
                minStack.pop();
            }
        }

        public int top() {

            return stack.peek();
        }

        public int min() {

            return minStack.peek();
        }
    }
}
