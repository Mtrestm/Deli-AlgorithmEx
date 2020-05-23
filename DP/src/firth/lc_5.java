/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-21 10:30
 **/

package firth;

public class lc_5 {
    //1,两个状态变量l,r==>dp 定义成二维
    //2.定义状态dp[l,r] :即子串 s[l,r] 是否是回文串
    //3. 进行一次状态转移 ,dp[l,r] = s.charAt(l) == s.charAt(r) &&( (r-l)<=2 || dp[l+1,r-1])
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s.length() <= 1)
            return s;

        boolean[][] dp = new boolean[len][len];
        //base case
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        //自定向下+记忆化
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && ((r - l) <= 2 || dp[l + 1][r - 1])) {
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
