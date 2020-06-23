/**
 * @program: Deli-AlgorithmEx
 * @description: 拥有最多糖果的孩子
 * @author: Shaobo.Qian
 * @create: 2020-06-01 06:28
 **/

package undefined;

import java.util.ArrayList;
import java.util.List;

public class lc_1431 {
    public static void main(String[] args) {

    }
    /**
     * 两次遍历
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int len = candies.length;
        if (len == 0)
            return res;

        int max = candies[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < len; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}
