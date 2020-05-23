/**
 * @program: Deli-AlgorithmEx
 * @description: 41. 缺失的第一个正数
 * @author: Shaobo.Qian
 * @create: 2020-03-01 10:37
 **/

package first;

import java.util.Arrays;

public class lc_41 {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int missingPositive = firstMissingPositive(nums);
        System.out.println("missingPositive = " + missingPositive);
    }
    /**
     * todo:将数组视为哈希表，哈希函数为：f(nums[i]) = nums[i] - 1
     * @author Shaobo.Qian
     * @date 2020/3/1
     * @link: https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     */
    public static int firstMissingPositive(int[] nums) {
        //缺失的正数在[1,N+1]这个范围内,如果数组缺失的是 N+1这个数,则数组为[1,2,3...N-1,N]这样
        int len = nums.length;
        //1.假定数组[1,2,3...N-1,N]是这样,一个萝卜一个坑,将元素交换的正确的位置
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        Arrays.stream(nums).forEach(p -> System.out.println("p = " + p));
        //2.遍历数组找到缺失的最小正数
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }

    private static void swap(int[] nums, int currIdx, int targetIdx) {
        int temp = nums[currIdx];
        nums[currIdx] = nums[targetIdx];
        nums[targetIdx] = temp;
    }
}
