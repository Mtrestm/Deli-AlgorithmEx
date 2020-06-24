package first;

import java.util.Arrays;

/**
 * @program: DeliAlgorithmEx
 * @description: 最接近的三数之和
 * @author: Shaobo.Qian
 * @create: 2020-06-24 11:06
 **/

public class lc_16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        lc_16 solution = new lc_16();
        int res = solution.threeSumClosest(nums, 1);
        System.out.println("res = " + res);
    }

    /**
     * @question:
     * 1.如何判断当前和是否和目标值更加接近?
     * 2.如何缩小检查范围(或者遍历整个结果集)?
     * 3.本题目因为要计算三个数,如果靠暴力枚举的话时间复杂度会到O(n3),如何降低时间复杂度?
     * @author Shaobo.Qian
     * @date 2020/6/24
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                //判断当前和是否和目标值更加接近
                if (Math.abs(target - currSum) < Math.abs(target - ans))
                    ans = currSum;
                if (currSum < target)
                    start++;
                else if (currSum > target)
                    end--;
                else
                    return ans;
            }
        }
        return ans;
    }

}


