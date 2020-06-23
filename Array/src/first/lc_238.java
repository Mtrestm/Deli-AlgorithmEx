package first;

/**
 * @program: Deli-AlgorithmEx
 * @description: 除自身以外数组的乘积
 * @author: Shaobo.Qian
 * @create: 2020-06-04 11:57
 **/

public class lc_238 {
    /**
     * @question:
     * 1.不用除法的整体思路?(提示:还是利用到数组的性质)
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        int base = 1;
        //从左到右遍历,保存当前元素左边所有元素的乘积
        for (int i = 0; i < len; i++) {
            res[i] = base;
            base *= nums[i];
        }
        //从右到左遍历,(之前保存当前元素左边所有元素的乘积) * (本次遍历的当前元素右边所有元素乘积)
        base = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= base;
            base *= nums[i];
        }
        return res;
    }
}
