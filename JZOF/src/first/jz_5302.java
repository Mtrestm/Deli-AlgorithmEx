/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:53
 **/

package first;

public  class jz_5302 {
    public static void main(String[] args) {
        //        int[] nums = {0, 1, 3};
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        jz_5302 solution = new jz_5302();
        int num = solution.missingNumber1(nums);
        System.out.println("num = " + num);
    }

    /**
     * anki
     * 二分法
     * @link: https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
     * @question:
     * 1.排序数组中的搜索问题，首先想到什么方法解决?
     * 2.画图二分搜索的过程?
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == m) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

    /**
     * 递归
     *
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public int missingNumber1(int[] nums) {
        if (nums.length < 2) return 1;
        //[0,1,3] -->[0,1] ,[1,3]
        //[0,1,2,3,4,5,6,7,9] -->[0,4],[4,9]

        return recur(nums, 0, nums.length - 1);
    }

    private int recur(int[] nums, int l, int r) {
        //1.terminator
        if (r - l == 1)
            return nums[r] - 1;
        //2.current level
        //0+ (2-0)/2 ==>1
        int mid = l + (r - l) / 2;
        if (nums[mid] - nums[l] != mid - l) {
            return recur(nums, l, mid);
        } else {
            if ((r - l + 1) % 2 == 0) {
                return recur(nums, mid + 1, r);

            } else {
                return recur(nums, mid, r);
            }
        }
        //        if ((r - l + 1) % 2 == 0) {
        //            if (nums[mid] - nums[l] != mid - l) {
        //                recur(nums, l, mid);
        //            } else {
        //                recur(nums, mid + 1, r);
        //            }
        //        } else {
        //            if (nums[mid] - nums[l] != mid - l) {
        //                recur(nums, l, mid);
        //            } else {
        //                recur(nums, mid, r);
        //            }
        //        }

    }
}


