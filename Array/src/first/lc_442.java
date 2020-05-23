/**
 * @program: Deli-AlgorithmEx
 * @description:数组中重复的数据
 * @author: Shaobo.Qian
 * @create: 2020-03-01 19:37
 **/

package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_442 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        duplicates.forEach(p -> System.out.println("p = " + p));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return res;
        for (int i = 0; i < len; i++) {
            //元素是不在它所在的位置,则开始交换
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i && !res.contains(nums[i]))
                res.add(nums[i]);
        }
        Arrays.stream(nums).forEach(p -> System.out.print(p));
        return res;
    }

    private static void swap(int[] nums, int currIdx, int targetIdx) {
        int temp = nums[currIdx];
        nums[currIdx] = nums[targetIdx];
        nums[targetIdx] = temp;
    }
}
