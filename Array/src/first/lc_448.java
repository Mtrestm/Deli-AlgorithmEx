/**
 * @program: Deli-AlgorithmEx
 * @description: 找到所有数组中消失的数字
 * @author: Shaobo.Qian
 * @create: 2020-03-01 18:04
 **/

package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc_448 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        disappearedNumbers.stream().forEach(p -> System.out.println("p = " + p));
    }

    /**
     * 将数组视为哈希表
     * @author Shaobo.Qian
     * @date 2020/3/1
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        //1.将各个元素放在正确的位置
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1])
                    break;

                swap(nums, i, nums[i] - 1);
            }
        }
        Arrays.stream(nums).forEach(p-> System.out.print(" " + p));
        System.out.println();
        //2.再循环一次将不符合哈希函数 f(n) = n+1 的元素找出来,即消失的元素
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                result.add(i + 1);
        }
        return result;
    }

    private static void swap(int[] nums, int currIdx, int targetIdx) {
        int temp = nums[currIdx];
        nums[currIdx] = nums[targetIdx];
        nums[targetIdx] = temp;
    }
}
