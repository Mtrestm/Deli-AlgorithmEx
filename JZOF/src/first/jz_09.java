/**
 * @program: Deli-AlgorithmEx
 * @description: 用两个栈实现队列
 * @author: Shaobo.Qian
 * @create: 2020-03-05 16:21
 **/

package first;

import java.util.Stack;

public class jz_09 {
    /*class CQueue {
        //两个栈,一个用来操作,一个用来存储
        Stack<Integer> stack;
        Stack<Integer> tempStack;

        public CQueue() {
            this.stack = new Stack<>();
            this.tempStack = new Stack<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (stack.isEmpty() && tempStack.isEmpty()) return -1;
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
            int res = tempStack.pop();
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return res;
        }
    }*/
    class CQueue {
        //两个栈,一个用来生成元素,一个用来消费元素
        Stack<Integer> produceStack;
        Stack<Integer> consumerStack;

        public CQueue() {
            this.produceStack = new Stack<>();
            this.consumerStack = new Stack<>();
        }

        public void appendTail(int value) {
            produceStack.push(value);
        }

        public int deleteHead() {
            if (produceStack.isEmpty() && consumerStack.isEmpty()) return -1;
            if (consumerStack.isEmpty()) {//消费栈中没有元素了,一次性将生产栈中的元素全取过来
                while (!produceStack.isEmpty()) {
                    consumerStack.push(produceStack.pop());
                }
            }
            return consumerStack.pop();
        }
    }
}
