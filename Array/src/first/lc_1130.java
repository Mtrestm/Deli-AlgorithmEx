/**
 * @program: Deli-AlgorithmEx
 * @description:分糖果 II
 * @author: Shaobo.Qian
 * @create: 2020-03-05 05:40
 **/

package first;

import java.util.Arrays;

public class lc_1130 {

    public static void main(String[] args) {
//        int candies = 7, num_people = 4;
        int candies = 10, num_people = 3;
        int[] ans = distributeCandies(candies, num_people);
        Arrays.stream(ans).forEach(p -> System.out.println(" " + p));
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/3/5
     */
    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int k = 0;//已完成多少轮循环
        //循环分糖果
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                ans[i] += Math.min(candies, k * num_people + (i + 1));
                candies -= (k * num_people + (i + 1));
                if (candies <=0) break;
            }
            k++;
        }
        return ans;
    }
}

