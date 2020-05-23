/**
 * @program: Deli-AlgorithmEx
 * @description: 数组中出现次数超过一半的数字
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:32
 **/

package first;

import java.util.HashMap;
import java.util.Map;

public class jz_39 {

    /**
     * @question:
     * 1.如果要求不申请新的空间,原地统计,有什么方法可以统计出众数?原理是?
     * 2.画图解释这种原理?
     * 投票法
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public int majorityElement(int[] nums) {

        //假设 x 为众数,当 votes=0,重新假设一个众数,范围不断缩小(前面的数字抵消,不影响最终的结果)
        int x = 0, votes = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) x = nums[i];
            votes += nums[i] == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for (int num : nums) {
            if (x == num) count++;
        }

        return count > nums.length / 2 ? x : 0;
    }

    /**
     * 计数法
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public int majorityElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
                Integer count = map.getOrDefault(nums[i], 0);
                if (count+1 >= (len+1) / 2) {
                return nums[i];
            }
            map.put(nums[i], count + 1);
        }
        return 0;
    }
}
