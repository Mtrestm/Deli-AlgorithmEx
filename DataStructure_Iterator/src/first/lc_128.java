package first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: DeliAlgorithmEx
 * @description: 最长连续序列
 * @author: Shaobo.Qian
 * @create: 2020-06-06 10:40
 **/

public class lc_128 {
    public static void main(String[] args) {
        int[] nums = {0, -1};
        lc_128 solution = new lc_128();
        int res = solution.longestConsecutive(nums);
        System.out.println("res = " + res);
    }

    /**
     * 借助辅助数据结构: Hash(set)
     * @question:
     * 1.如何借助辅助数据结构
     * @author Shaobo.Qian
     * @date 2020/6/6
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums)
            set.add(num);
        int max = 0;
        for (Integer num : nums) {
            if (!set.contains(num - 1)) {//存在 num-1,即在这段递增序列中存在更小的起始值,当前的直接跳过
                int currNum = num;
                int currCnt = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currCnt++;
                }
                max = Math.max(max, currCnt);
            }
        }
        return max;
    }

    /**
     * sort + compare
     *
     * @author Shaobo.Qian
     * @date 2020/6/6
     */
    public int longestConsecutive0(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0)
            return 0;
        Arrays.sort(nums);
        int max = 1, curr = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] - nums[i - 1] == 1) {
                    curr++;
                } else {
                    max = Math.max(max, curr);
                    curr = 1;
                }

            }
        }
        return Math.max(max, curr);
    }
}
