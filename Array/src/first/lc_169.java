/**
 * @program: Deli-AlgorithmEx
 * @description: 多数元素
 * @author: Shaobo.Qian
 * @create: 2020-03-13 08:31
 **/

package first;

import java.util.HashMap;
import java.util.Map;

public class lc_169 {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 3};
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement(nums);
        System.out.println("i = " + i);
    }
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count = map.getOrDefault(nums[i], 0)+1;
            if (count > len / 2)
                return nums[i];
            else
                map.put(nums[i], count);
        }
        return -1;
    }
}
