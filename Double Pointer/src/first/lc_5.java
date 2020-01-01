/**
 * @program: Deli-AlgorithmEx
 * @description: 回文串
 * @author: Shaobo.Qian
 * @create: 2019-12-24 07:26
 **/

package first;

public class lc_5 {
    ////         babab
    //        //baba abab
    //        //bab aba bab
    //        //ba ab ba ab
    //        //b a b a b
    public static void main(String[] args) {
        String s = "cbbd";
        String ss = longestPalindrome(s);
        System.out.println("ss = " + ss);
    }

    /**
     * 暴力法,仿解
     * @author Shaobo.Qian
     * @date 2019/12/24
     * @link https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        String res = s.substring(0, 1);
        //列举所有长度大于2的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                if ((j - i + 1 > maxLen) && isPalindrome(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
    /**
     *
     * @author Shaobo.Qian
     * @date 2019/12/24
     */
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    /**
     * 暴力法原解(从大到小遍历所有的子串判断是否是回文串)
     * 未解出
     * @author Shaobo.Qian
     * @date 2019/12/24
     */
    public static String longestPalindrome1(String s) {
        int sLen = s.length();
        while (sLen > 0) {
            for (int i = 0; ; i++) {
                int j = i + sLen - 1;
                if (j <= sLen) {
                    String ss = isPalindrome1(s, i, j);
                    if (ss != null) return ss;
                } else {
                    break;
                }
            }
            sLen--;
        }
        return "";
    }

    private static String isPalindrome1(String s, int i, int j) {
        String substring = s.substring(i, j + 1);
        int start = 0;
        int end = substring.length() - 1;
        while (start < end) {
            if (substring.charAt(start++) != substring.charAt(end--)) return null;
        }
        return substring;
    }
}
