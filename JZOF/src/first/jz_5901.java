/**
 * @program: Deli-AlgorithmEx
 * @description: I. 滑动窗口的最大值
 * @author: Shaobo.Qian
 * @create: 2020-05-07 06:52
 **/

package first;

import java.util.Arrays;

public class jz_5901 {
    //todo:如何利用单调队列解题
    //@link: https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {9,11};
//        int[] nums = {1};
        jz_5901 solution = new jz_5901();
        int[] res = solution.maxSlidingWindow(nums, 3);
        Arrays.stream(res).forEach(p -> System.out.println("p = " + p));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || len < k) return new int[0];
        int[] res = new int[len - k + 1];

        //1.找到前 k-1个数的最大值
        int max = getMax(nums, 0, k );
        res[0] = max;

        //2.从第 k 个数开始,每次向右滑动1个举例,记录滑动窗口最大值
        int i = 1, j = k - 1;
        while (++j < len) {
            if (nums[i - 1] == max && nums[j] < max) {
                max = getMax(nums, i, k);
            } else {
                max = Math.max(max, nums[j]);
            }
            res[i++] = max;
        }
        return res;
    }

    private int getMax(int[] nums, int begin, int k) {
        int max = nums[begin];
        for (int i = begin+1; i < begin + k; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }


}
