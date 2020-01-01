/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-01 11:04
 **/

package second;

public class lc_5 {

    /**
     * dp(自顶向下+记忆化)
     * @author Shaobo.Qian
     * @date 2020/1/1
     */
    public String longestPalindrome(String s) {
        //dp 状态定义:
        // 1.s[l,r] 表示 s 的一个子串
        // 2.dp[l][r]表示 s[l,r]区间的子串是否是一个回文串
        //dp 方程:
        //dp[l][r] = (s[l] == s[r]) && (dp[l+1][r-1] || r-l <=2)
        int sLen = s.length();
        if(s.length() <=1) return s;
        String longestPalindromeStr = s.substring(0, 1);
        int longestPalindrome = 1;

        boolean[][] dp = new boolean[sLen][sLen];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && ((r - l) <= 2 || dp[l + 1][r - 1])) {
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
