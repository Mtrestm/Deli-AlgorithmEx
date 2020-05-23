/**
 * @program: Deli-AlgorithmEx
 * @description: 和为s的两个数字
 * @author: Shaobo.Qian
 * @create: 2020-05-05 17:09
 **/

package first;

public class jz_5701 {
    /**
     * 双指针
     * @link https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
     * @question:
     * 1.求解公式如何推导的?如何证明?
     * 2.双指针(对撞指针)求解的思路?
     * @author Shaobo.Qian
     * @date 2020/5/7
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
//        int[] res = new int[2];
        while (i < j) {
            if (target == nums[i] + nums[j]) {
//                res[0] = nums[i];
//                res[1] = nums[j];
//                return res;
                return new int[]{nums[i], nums[j]};
            } else if (target >nums[i]+nums[j])
                i++;
            else j--;
        }

        return new int[0];
    }

}
