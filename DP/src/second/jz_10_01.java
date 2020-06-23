/**
 * @program: DeliAlgorithmEx
 * @description: 斐波那契数列
 * @author: Shaobo.Qian
 * @create: 2020-06-05 15:18
 **/

package second;

import java.util.HashMap;
import java.util.Map;

public class jz_10_01 {
    public static void main(String[] args) {
        jz_10_01 solution = new jz_10_01();
        int res = solution.fib(5);
        System.out.println("res = " + res);
    }

    /**
     * dp (自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public int fib1(int n) {
        if (n <= 1)
            return n;
        //base case
        int i_0 = 0, i_1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = (i_0 + i_1) % 1000000007;
            i_0 = i_1;
            i_1 = curr;
        }
        return i_1;
    }

    /**
     * dp(自底向上+递归)
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        //1.terminator
        if (n <= 1)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int res = (fib(n - 1) + fib(n - 2)) % 1000000007;
        map.put(n, res);
        return res;
    }

    /**
     * 自解递归+记忆化+剪枝
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */

    int[] dp;

    public int fib0(int n) {
        this.dp = new int[n + 1];
        return recur(n);
    }

    private int recur(int n) {
        //1.terminator
        if (n <= 1)
            return n;
        if (dp[n] > 0)
            return dp[n];
        //2.current level
        int res = (recur(n - 1) + recur(n - 2)) % 1000000007;
        dp[n] = res;
        return res;
    }
/*
    int[] dp;

    public int fib0(int n) {
        this.dp = new int[n + 1];
        return recur(n);
    }

    private int recur(int n) {
        //1.terminator
        if (n <= 1)
            return n;
        if (dp[n] > 0)
            return dp[n];
        //2.current level
        return (recur(n - 1) + recur(n - 2)) % 1000000007;
    }
*/
}
