/**
 * @program: Deli-AlgorithmEx
 * @description: 寻找重复数
 * @author: Shaobo.Qian
 * @create: 2020-05-26 04:58
 **/

package first;

public class lc_287 {
    /**
     * anki
     * 二分查找
     * @question:
     * 1.什么是抽屉原理?
     * 2.本题为什么可以用二分搜索?本质是?
     * 3.举例说明本题中二分搜索的过程?
     * @author Shaobo.Qian
     * @date 2020/5/26
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }

        return left;
    }
}
