/**
 * @program: Deli-AlgorithmEx
 * @description: 字符串解码
 * @author: Shaobo.Qian
 * @create: 2020-05-28 10:16
 **/

package first;

import java.util.LinkedList;

public class lc_394 {
    /**
     * anki
     * @question
     * 1.借助栈来解题的思路?需要哪两个栈,分别保存什么数据?
     * 2.除了两个栈,还需要哪两个临时变量,分别保存什么数据?
     * 3.遍历字符串会遇到哪四种情况,分别如何处理?
     * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public String decodeString(String s) {
        //3[a2[c]] ==> acc ==> accaccacc
        //1.需要借助的数组结构
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        //2.遍历字符串中的字符处理
        for (Character c : s.toCharArray()) {
            //2.1 '['代表开启一段循环,压栈
            if (c == '[') {
                //开启一段新循环时,将上一阶段临时变量中保存的值入栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                //开启一段循环时,恢复临时变量的状态
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //将栈中的数据出栈
                StringBuilder temp = new StringBuilder();
                Integer cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {//cur_multi = 2
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + temp);// "a"+"cc"
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
