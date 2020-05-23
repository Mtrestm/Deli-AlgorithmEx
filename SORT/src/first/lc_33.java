package first;

/**
 * @program: Deli-AlgorithmEx
 * @description: 搜索旋转排序数组
 * @author: Shaobo.Qian
 * @create: 2020-04-27 06:38
 **/

public class lc_33 {

    /**
     *
     * @question: 1.普通二分搜索的步骤(核心要做一件什么事) ? 2.旋转数组的旋转点如何找到,旋转数组的特点? 3.旋转数组的搜索比普通的二分搜索多了哪一步? 4.判断升序区域和哪个值比较? 5.缩小范围要怎么比较?
     * 二分搜索
     * @author Shaobo.Qian
     * @date 2020/4/27
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            //和nums[left]比较,判断升序区域
            if (nums[mid] >= nums[left]) {//左边升序(即left->mid区域升序)
                //和target,收缩查找区间
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1; //缩小范围,仍在左边区域查找
                } else {
                    left = mid + 1; //缩小范围,在右边区域查找
                }
            } else {//右边升序(即mid->right区域升序)
                if (nums[right] >= target && nums[mid] <= target) {
                    left = mid + 1;//缩小范围,仍在右边区域查找
                } else {
                    right = mid - 1;//缩小范围,在左边区域查找
                }
            }
        }

        return -1;
    }
}
