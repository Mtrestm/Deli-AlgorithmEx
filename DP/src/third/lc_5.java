/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-15 08:18
 **/

package third;

public class lc_5 {

    /**
     * dp(自顶向下+记忆化)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //状态定义s[l,r]
        //状态转义方程dp[l,r] = (s[l] == s[r] && (l-r<=2 || s[l+1][r-1]))

        int len = s.length();
        if (len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);

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
