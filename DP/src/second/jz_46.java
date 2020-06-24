/**
 * @program: Deli-AlgorithmEx
 * @description: 把数字翻译成字符串
 * @author: Shaobo.Qian
 * @create: 2020-06-03 18:09
 **/

package second;

public class jz_46 {
    public static void main(String[] args) {
        jz_46 solution = new jz_46();
        int res = solution.translateNum(12258);
        System.out.println("res = " + res);
    }
    /**
     * @author Shaobo.Qian
     * @date 2020/6/3
     */
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        if (len<=1)
            return len;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String currStr = numStr.substring(i - 2, i);
            //转移
            dp[i] = currStr.compareTo("10") >= 0 && currStr.compareTo("25") <= 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
        }

        return dp[len];
    }
}
