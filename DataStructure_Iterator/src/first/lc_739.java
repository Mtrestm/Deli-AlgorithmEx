package first;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: DeliAlgorithmEx
 * @description: 每日温度
 * @author: Shaobo.Qian
 * @create: 2020-06-11 10:29
 **/

public class lc_739 {

    public static void main(String[] args) {
        lc_739 solution = new lc_739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution.dailyTemperatures(T);
//        System.out.println("res = " + res);
        Arrays.stream(res).forEach(p-> System.out.println("p = " + p));
    }
    /**
     * @question
     * 1.栈里的元素的单调性是怎样的?
     * 2.画图整个入栈出栈过程?
     * @author Shaobo.Qian
     * @date 2020/6/11
     * https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int curIdx = 0; curIdx < len; curIdx++) {
            while (!stack.isEmpty() && T[curIdx] > T[stack.peek()]) {
                int idx = stack.peek();
                stack.pop();
                res[idx] = curIdx - idx;
            }
            stack.push(curIdx);
        }
        return res;
    }
}
