/**
 * @program: Deli-AlgorithmEx
 * @description: 排序数组
 * @author: Shaobo.Qian
 * @create: 2020-03-31 07:51
 **/

package first;

import java.util.Arrays;

public class lc_912 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] res = sortArray(nums);
//        Arrays.stream(res).forEach(p-> System.out.print("p = " + p));
        Arrays.stream(res).forEach(p->{
            System.out.print("p = " + p);
            System.out.println();
        });
    }


    /**
     * 计数法:(核心思想:将数值按散列函数:(这里用的是num - min来散列)从小到大散列都计数数组中)
     * @author Shaobo.Qian
     * @date 2020/3/31
     */
    public static int[] sortArray(int[] nums) {
        int max = -50001, min = 50001;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] numCntArr = new int[max - min + 1];

        for (int num : nums) {
            numCntArr[num - min]++;
        }
        int idx = 0;
        for (int num = min; num <= max; num++) {
            int cnt = numCntArr[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
        return nums;
    }
    /**
     * 快速排序
     * @author Shaobo.Qian
     * @date 2020/3/31
     */
    public int[] sortArray2(int[] nums) {
        int lo = 0;
        int hi = nums.length;

        conquer(lo, hi, nums);


        return null;
    }

    private void conquer(int lo, int hi, int[] nums) {

        int index = partition(lo, hi, nums);
    }

    private int partition(int lo, int hi, int[] nums) {
        int medium = lo + (hi - lo) >>> 1;
        int axis = nums[lo];
        int i = lo;
        int j = hi;
        while (i < j) {

        }
        return 0;
    }


    /**
     * 调用 api
     * @author Shaobo.Qian
     * @date 2020/3/31
     */
    public static int[] sortArray1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }



}
