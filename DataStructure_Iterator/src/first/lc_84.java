/**
 * @program: Deli-AlgorithmEx
 * @description: 柱状图中最大的矩形
 * @author: Shaobo.Qian
 * @create: 2020-05-30 08:54
 **/

package first;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc_84 {

    /**
     * anki
     * 单调栈+使用哨兵优化
     *
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return heights[0];

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        int res = 0;
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;//i:出栈角标的右边界 stack.peekLast():出栈角标的左边界
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

    /**
     * @quesiton: 1.本题借用辅助栈, 栈中保存元素的单调性?
     * 2.栈中保存的是什么元素?为什么?
     * 3.满足什么条件出栈?
     * 4.出栈元素对应的矩形宽度的左右边界如何确定?分哪两种情况?
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public int largestRectangleArea0(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return heights[0];

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                //将队列中保存的最后一个数组角标出栈,计算对应角标高度的矩形面积
                int curHeight = heights[stack.pollLast()];
                //同一高度的角标计算一次即可,并且必须出栈不能影响左边界
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i; //当前角标之前的全部长度
                } else {
                    curWidth = i - stack.peekLast() - 1; //i:出栈角标的右边界 stack.peekLast():出栈角标的左边界
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        //一次遍历后,剩下的栈中元素(这些栈中的角标对应的高度,没找到自己右边比自己还矮的高度)
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            //同一高度的角标计算一次即可,并且必须出栈不能影响左边界
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);

        }
        return res;
    }
}
