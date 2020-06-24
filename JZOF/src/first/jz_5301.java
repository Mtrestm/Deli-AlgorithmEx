/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:54
 **/

package first;

public  class jz_5301 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        jz_5301 solution = new jz_5301();
        int cnt = solution.search1(nums, 2);
        System.out.println("cnt = " + cnt);
    }
    /**
     * anki
     * @link https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
     * @question
     * 1.如何使用二次二分的方法解题?
     * 2.本题的问题可以转换为什么问题?
     * @author Shaobo.Qian
     * @date 2020/5/5
     */
    public int search(int[] nums, int target) {
        return 0;
    }
    //二分查找
    public int search1(int[] nums, int target) {
        //1.二分查找,找到 target 对应的索引
        int len = nums.length;
        if (len == 0) return 0;
        int l = 0, r = len - 1, mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target)
                break;
            else if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
        }
        //如果没找到
        if (nums[mid] != target)
            return 0;
        int prev = 0;
        //找到刚刚比 target 小的数,开始统计
        while (mid > 0) {
            if (nums[mid--] < target)
                break;
        }

        int count = 0;
        for (int i = mid; i < len; i++) {
            if (nums[i] == target) count++;
        }
        return count;

    }
}


