/**
 * @program: Deli-AlgorithmEx
 * @description: 面试题10- I. 斐波那契数列
 * @author: Shaobo.Qian
 * @create: 2020-03-05 18:02
 **/

package first;

import java.util.HashMap;
import java.util.Map;

public class lc_509 {
    public static void main(String[] args) {
        int n = 5;
        int res = fib1(5);
        System.out.println("res = " + res);
    }

    /**
     * todo:
     * @question: 1.dp的方程,basecase,是怎样的? 2.该题有哪些不同的解法
     * dp(自顶向下+循环)
     *
     * @author Shaobo.Qian
     * @date 2020/3/5
     * @link https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/mian-shi-ti-10-i-fei-bo-na-qi-shu-lie-dong-tai-gui/
     */
    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 动态规划,自顶向下(递归+记忆化)
     * @author Shaobo.Qian
     * @date 2020/3/5
     */
    static Map<Integer, Integer> map = new HashMap<>();
    public static int fib1(int n) {
        //F(0) = 0,   F(1) = 1
        //F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
        //terminator
        if (map.containsKey(n)) return map.get(n);
        if (n <= 1) {
            return n;
        }
        //current cell:处理当前层
        //drill down
        int res = (fib1(n - 1) + fib1(n - 2)) % 1000000007;
        map.put(n, res);
        return res;
    }
}
