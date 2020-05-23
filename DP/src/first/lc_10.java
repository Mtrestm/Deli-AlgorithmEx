/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-02 09:11
 **/

package first;

public class lc_10 {


    public boolean isMatch(String s,String p){
        if(s==null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //1.初始化base case
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        //举例:s=aab p=c*a*b* aab  第一遍循环就是进行初始化 判断 s 的前 0个是否能被 p 的前 j 个匹配，把最开头的c*检测出去 如果不进行初始化就开始下面两层循环就会出现一直不匹配的状态
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i + 1] = true;//charAt(i),索引为 i,即对应的 i+1个字符
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //2.如果是p中第 j 个元素是任意元素".", 或者是p[j]==s[i]元素匹配
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                 //3.处理最后一个字符是*的情况
                } else if (p.charAt(j) == '*') {
                   //3.1如果前一个元素不匹配 且不为任意元素
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况:即p中最后2个字符匹配 s 中最后多个字符的情况
                            or dp[i][j] = dp[i][j-1] //单个字符匹配的情况(即p中最后2个字符匹配 s 中最后一个字符的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况:即p中最后2个字符匹配 是多余的情况
                             */
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
