/**
 * @program: Deli-AlgorithmEx
 * @description: 调整数组顺序使奇数位于偶数前面
 * @author: Shaobo.Qian
 * @create: 2020-05-01 09:47
 **/

package first;

import java.util.Arrays;

public class jz_21 {

    public static void main(String[] args) {
        jz_21 solution = new jz_21();
//        int[] nums = {1, 2, 5, 4, 3, 4};
//        int[] nums = {1, 3, 5};
        int[] nums = {1, 2,3, 4};
        int[] res = solution.exchange(nums);
        Arrays.stream(res).forEach(p -> System.out.println("p = " + p));
    }

    /**
     * 双指针
     *
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public int[] exchange(int[] nums) {

        int len = nums.length;
        if (len<=1)
            return nums;
        int i = 0, j = nums.length - 1;
        //1.一个指针从前往后读读到偶数记录;一个指针从后往前读,读到奇数记录==> 做一次交换

        while (i < j) {
            while (nums[i] % 2 != 0 && i < len-1) {
                i++;
            }
            while (nums[j] % 2 == 0 && j > 0) {
                j--;
            }
            if (i < j) {
                exchangeNum(nums, i, j);
            }
        }
        return nums;
    }

    private void exchangeNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
