/**
 * @program: Deli-AlgorithmEx
 * @description: 二分查找
 * @author: Shaobo.Qian
 * @create: 2020-03-14 21:49
 **/

package first;

public class lc_704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int index = search(nums, 13);
//        int index = search(nums, 9);
        System.out.println("index = " + index);
    }

    /**
     * 二分查找
     *
     * @author Shaobo.Qian
     * @date 2020/3/14
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        //[3,4]  3
        while (left <= right && left <len) {
            int mid = left + ((right - left) >>> 1);
            if (target == nums[mid]) return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
