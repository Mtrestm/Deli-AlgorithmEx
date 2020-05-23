/**
 * @program: Deli-AlgorithmEx
 * @description: 只出现一次的数字
 * @author: Shaobo.Qian
 * @create: 2020-05-20 13:28
 **/

package first;

public class lc_136 {
    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
//        int[] nums = {2, 2, 1};
        lc_136 solution = new lc_136();
        int res = solution.singleNumber(nums);
        System.out.println("res = " + res);

    }

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
