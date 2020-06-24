/**
 * @program: DeliAlgorithmEx
 * @description: 把数字翻译成字符串
 * @author: Shaobo.Qian
 * @create: 2020-06-09 10:34
 **/

package third;

public class jz_46 {
    public static void main(String[] args) {
        jz_46 solution = new jz_46();
        int num = 12258;
        int res = solution.translateNum(num);
        System.out.println("res = " + res);
    }

    /**
     * dp(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/9
     */
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1]; //dp[i] X0X1...Xi的字符串可以翻译出的不同的结果数
        dp[0] = 1;
        dp[1] = 1;
        //根据状态变量的变换进行状态转换
        for (int i = 2; i <= len; i++) {
            //状态转移
            String currStr = numStr.substring(i - 2, i);
            if (currStr.compareTo("10") >= 0 && currStr.compareTo("25") <= 0)
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[len];
    }
}
