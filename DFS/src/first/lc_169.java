/**
 * @program: Deli-AlgorithmEx
 * @description: 多数元素==>分治法
 * @author: Shaobo.Qian
 * @create: 2020-03-13 10:05
 **/

package first;

public class lc_169 {

    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {3, 2, 3};
        int i = majorityElement(nums);
        System.out.println("i = " + i);

    }

    public static int majorityElement(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    /**
     * 分治
     *
     * @author Shaobo.Qian
     * @date 2020/3/13
     */
    private static int divideConquer(int[] nums, int lo, int hi) {
        //terminator
//        if (nums.length == 1) return nums[0];
        if(lo ==hi) return nums[lo];
        //current level
        int mid = lo + (hi - lo) / 2;
        //drill down
        int lMajority = divideConquer(nums, lo, mid);//左边数组返回的众数
        int rMajority = divideConquer(nums, mid + 1, hi);//右边数组返回的众数
        //merge(返回众数)
        if (lMajority == rMajority) {
            return lMajority;
        } else {
            int leftCnt = countMajority(nums, lo, mid, lMajority);
            int rightCnt = countMajority(nums, mid+1, hi, rMajority);
            return leftCnt > rightCnt ? lMajority : rMajority;
        }
    }

    /**
     * 求众数在所在数组中的个数
     *
     * @author Shaobo.Qian
     * @date 2020/3/13
     */
    private static int countMajority(int[] nums, int lo, int hi, int majority) {
        int cnt = 0;
        for (int i = lo; i <= hi; i++) {
            if (majority == nums[i])
                cnt++;
        }
        return cnt;
    }
}
