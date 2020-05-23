/**
 * @program: Deli-AlgorithmEx
 * @description: 盛最多水的容器
 * @author: Shaobo.Qian
 * @create: 2020-04-18 07:19
 **/

package first;

public class lc_11 {
    /**
     * @question:如何移动双指针(移动指针的规则是怎样的),如何证明这样移动不会丢失最大值?
     * 双指针
     * @author Shaobo.Qian
     * @date 2020/4/18
     */
    public int maxArea(int[] height) {
        //1.定义左右指针和结果
        int i = 0, j = height.length - 1, res = 0;
        //2.左右指针,将指针对应值小的柱子向中间收拢
        while (i < j) {
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
