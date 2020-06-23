/**
 * @program: DeliAlgorithmEx
 * @description: 最长回文子串
 * @author: Shaobo.Qian
 * @create: 2020-06-05 15:02
 **/

package seven;

public class lc_5 {

    /**
     * dp(自顶向下+记忆化)
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1)
            return s;
        //状态定义
        boolean[][] dp = new boolean[len][len]; //dp[l][r] :子串s[l,r]是否是回文串
        //base case
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);

        //随着状态变量变换进行状态转移
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

}
