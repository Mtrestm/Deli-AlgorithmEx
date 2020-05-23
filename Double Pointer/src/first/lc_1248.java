/**
 * @program: Deli-AlgorithmEx
 * @description: 统计「优美子数组」
 * @author: Shaobo.Qian
 * @create: 2020-04-21 04:24
 **/

package first;

import java.util.Arrays;

public class lc_1248 {

    /**
     * 1.本题利用滑动窗口思想,实际上要记录的值是什么?2.滑动窗口的左边活动范围,右边活动范围如何确定?
     * 滑动窗口
     * @author Shaobo.Qian
     * @date 2020/4/21
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int feed = 0;
        //arr[i] 代表的nums数组中第i个奇数在nums数组中的索引
        int[] arr = new int[len + 2];
        Arrays.fill(arr, 0);
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                arr[++feed] = i;
            }
        }
        //left border
        arr[0] = -1;
        //right border
        arr[feed + 1] = len;
        //arr[i] - arr[i - 1 ==>左边的活动范围
        //arr[i + k] * arr[i + k - 1] ===>右边的活动范围
        for (int i = 1; i+k < feed+2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }




    /**
     * 滑动窗口(未解出)
     *
     * @author Shaobo.Qian
     * @date 2020/4/21
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        //滑动窗口中有 k 个奇数
        //定义优美子数组的数目,左右指针的起始位置
        int res = 0;
        int num = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                num++;
                if (num == k) {
                    break;
                } else {
                    right++;
                }
            }
        }
        //此时右指针指向第 k 个奇数位置
        for (int left = 0; right < nums.length; ) {
            if ((nums[left] & 1) == 0) {
                //左指针滑动至刚刚不包含 K 个奇数,停止滑动
                left++;
                res++;
            } else if ((nums[left] & 1) == 1) {

            }

            //右指针刚刚包含K个奇数时,左指针滑动
            if ((nums[right++] & 1) == 1) {
                num++;
            }
            if ((nums[right] & 1) == 0) {
                num++;
                right++;
            }
        }
        return res;
    }
}
