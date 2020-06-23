/**
 * @program: Deli-AlgorithmEx
 * @description: 栈的压入、弹出序列
 * @author: Shaobo.Qian
 * @create: 2020-05-01 17:26
 **/

package first;

import java.util.Stack;

public class jz_31 {


    /**
     * anki
     * @question:
     * 1.如何按照出栈序列数组模拟 压入 / 弹出操作的排列,需要借助什么?
     * 2.什么条件成立,元素出栈?
     * 3.如何判断弹出序列合法?
     * 辅助栈(模拟poped 数组元素入栈出栈的过程)
     * @link: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int i = 0;//popped数组索引
        for (int num : pushed) {
            stack.push(num);
            //判断 “栈顶元素= 弹出序列的当前元素” 是否成立,符合弹出序列顺序的栈顶元素全部弹出。
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
