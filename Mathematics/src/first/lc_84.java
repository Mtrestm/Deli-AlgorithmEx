/**
 * @program: Deli-AlgorithmEx
 * @description: 柱状图中最大的矩形
 * @author: Shaobo.Qian
 * @create: 2020-05-30 06:54
 **/

package first;

public class lc_84 {


    /**
     * anki
     * 暴力解法(数学)
     * @question 1.数学思维的思路
     * (因为柱状体的高度只可能为所有高度中的一种,所以分别以每个柱状体为高,求最大面积;再比较选出其中最大的面积)
     * @author Shaobo.Qian
     * @date 2020/5/30
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     */
    public int largestRectangleArea0(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int currHeight = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= currHeight) {
                left--;
            }
            int right = i;
            while (right < len - 1 && heights[right + 1] >= currHeight) {
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, width * currHeight);

        }
        return res;
    }
}
