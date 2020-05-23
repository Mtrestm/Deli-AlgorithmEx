/**
 * @program: Deli-AlgorithmEx
 * @description: 和为K的子数组
 * @author: Shaobo.Qian
 * @create: 2020-05-15 07:14
 **/

package 前缀和;

import java.util.HashMap;
import java.util.Map;

public class lc_560 {
    public static void main(String[] args) {
        lc_560 solution = new lc_560();
//        int[] nums = {1, 1, 1};
        int[] nums = {-1, -1, 1};
//        int[] nums = {1};
        int k = 0;
//        int k = 2;
        int cnt = solution.subarraySum2(nums, k);
        System.out.println("cnt = " + cnt);
    }

    /**
     * //已入anki
     *
     * @link: https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
     * @question: 1.为什么滑动窗口不适用?
     * 因为数据并不是递增，例如-1，3，-1，k=1，【-1，3，-1】就会被遗漏
     * 例如当我们得到一个「窗口」的和恰好等于 k 的时候，右边界向右边继续扩张，只要扩张的区间和为 0，依然可以得到一个和为 k 的更长的「窗口」，这种情况不能被排除掉。例如：k = 3，[0, 0, 1, 1, 1, -1, 1, -1, 1]。
     * 2.暴力解法是怎样的?
     * 3.如何优化暴力解法,使用的算法思路(叫什么)---想想如何计算数组的区间值?
     * 4.如何优化单纯的前缀和解法?
     * @author Shaobo.Qian
     * @date 2020/5/15
     */
    //纯前缀和
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                //计算区间和 [left..right]的值，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k)
                    count++;
            }
        }
        return count;
    }

    //前缀和+HashMap
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        //对于下标为 0 的元素，前缀和为 0，个数为 1 <===为什么要加这个,比如 nums 数组第一个元素即为 k,这样即能正常得到preSumFreq.get(k-k)为1
        preSumFreq.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            // 先获得前缀和为 (preSum - k) 的个数，加到计数变量里 <====(比如 k= 6, 遍历当前 num 后,当前的preSum = 8,只要得到 preSum = 2 个数设为 n,即到当前遍历的num为止能组成领取区间和为 k 的个数之前的count+n
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }


    /**
     * 原解:滑动窗口(思路错误)
     *
     * @author Shaobo.Qian
     * @date 2020/5/15
     */
    public int subarraySum1(int[] nums, int k) {
        //l,r子数组的左右两边
        //r:{0,len-1} ; l<=r
        //dp:nums[l,r]即和为 k的连续子数组
        if (nums.length == 0) return 0;

        int l = 0, r = 0, len = nums.length - 1, count = 0, sum = 0;

        while (r <= len) {
            //滑动r直到刚刚大于 k停止
            while (r <= len && sum <= k) {
                sum += nums[r++];
                if (sum == k)
                    count++;
            }
            //滑动 l直到刚刚小于 k 停止
            while (l < r) {
                sum -= nums[l++];
                if (sum == k)
                    count++;
                else if (sum < k)
                    break;
            }
        }
        while (l < r) {
            sum -= nums[l++];
            if (sum == k)
                count++;
        }
        return count;
    }

}
