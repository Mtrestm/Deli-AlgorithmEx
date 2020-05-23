package first;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-02-29 16:44
 **/

public class jz_03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber2(nums);
        System.out.println("repeatNumber = " + repeatNumber);
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //遍历元素存到 map 中去
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            //如果 map 中存在则返回该元素
            if (set.contains(nums[i]))
                return nums[i];
            else
                set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 防解一:遍历数组 时间O(n),空间 O(n)
     *
     * @author Shaobo.Qian
     * @date 2020/2/29
     * @link: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-b-4/
     */
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


    /**
     * todo:解题思想:把数组看出哈希表,空间复杂度O(1)
     * @author Shaobo.Qian
     * @date 2020/2/29
     * @link https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
     */
    public static int findRepeatNumber2(int[] nums) {
        int len = nums.length;
        //假定没有重复元素,当所有交换完成,就是1个萝卜1个坑(idx=0,item=0;idx=1,item=1;idx=2,item=2...)
        for (int i = 0; i < len; i++) {
            //1.当前元素和它现在所在的位置不匹配,开始交换,每次交换如果目标位置没被占,那么都会使一个元素归位(到正确位置上),即 i = nums[i]
            while (nums[i] != i) {
                System.out.println("当前索引 i = " + i + " 存放的元素是 = " + nums[i]);
                //2.检查当前元素要放置的位置是否被占
                if (nums[i] == nums[nums[i]]) {//如果当前元素将要被交换到的坑已经相同的元素被占了,说明重复
                    Arrays.stream(nums).forEach(p -> System.out.println("p = " + p));
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int currIdx, int targetIdx) {
        int temp = nums[currIdx];
        nums[currIdx] = nums[targetIdx];
        nums[targetIdx] = temp;
    }


}
