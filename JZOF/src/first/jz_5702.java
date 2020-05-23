/**
 * @program: Deli-AlgorithmEx
 * @description:II. 和为s的连续正数序列
 * @author: Shaobo.Qian
 * @create: 2020-03-04 09:37
 **/

package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jz_5702 {
    public static void main(String[] args) {
//        int target = 9;
        int target = 15;
        int[][] res = findContinuousSequence(target);
        for (int i = 0; i < res.length; i++) {
            Arrays.stream(res[i]).forEach(p -> System.out.print(" " + p));
            System.out.println();
        }
    }

    /**
     * @question 1.满足窗口滑动的条件(left<right)
     * //todo:滑动窗口+双指针
     * @author Shaobo.Qian
     * @date 2020/3/5
     * @link https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int left = 1, right = 2; left < right; ) {
            //计算两个指针之间[low,high]所有连续正数的和
            int sum = (left + right) * (right - left + 1) / 2;
            //如果和目标相等,将这些数字记入子数组
            if (sum == target) {
                int[] sub = new int[right - left + 1];
                int j = left;
                for (int i = 0; i < right - left + 1; i++, j++) {
                    sub[i] = j;
                }
                list.add(sub);
                left++;//左边向右滑动+1,窗口收缩,开始寻找其它的子数组
            } else if (sum < target) right++;//如果小于目标值,右指针向右滑动+1,窗口扩大
            else left++;//如果大于目标值,左指针向右滑动+1,窗口收缩
        }
        int[][] out = new int[list.size()][];
        return list.toArray(out);
    }

}
