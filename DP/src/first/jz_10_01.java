/**
 * @program: Deli-AlgorithmEx
 * @description: 斐波那契数列
 * @author: Shaobo.Qian
 * @create: 2020-06-02 12:01
 **/

package first;

import java.util.HashMap;
import java.util.Map;

public class jz_10_01 {
    public static void main(String[] args) {
        System.out.println("res = " + (1000000007 > Integer.MAX_VALUE ? 1 : 0));
        jz_10_01 solution = new jz_10_01();
        int res = solution.fib(10);
        System.out.println("res = " + res);
    }

    /**
     * 递归(超时) -->改进(记忆化递归)
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */

    Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {
        //1.terminator
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 1)
            return n;

        int res=  (fib(n - 1) + fib(n - 2)) % 1000000007;
        map.put(n, res);
        return res;
    }


    /**
     * 降维 dp(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int fib1(int n) {
        //base case
        if (n <= 0)
            return 0;
        int i_0 = 0;
        int i_1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = (i_0 + i_1) % 1000000007;
            i_0 = i_1;
            i_1 = curr;
        }
        return i_1;
    }

    /**
     * 一维 dp(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int fib0(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
