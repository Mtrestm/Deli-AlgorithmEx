/**
 * @program: Deli-AlgorithmEx
 * @description: 最长不含重复字符的子字符串
 * @author: Shaobo.Qian
 * @create: 2020-05-03 18:17
 **/

package first;

public class jz_48 {

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s =  "pwwkew";
        String s =  "au";
        jz_48 solution = new jz_48();
        int longest = solution.lengthOfLongestSubstring(s);
        System.out.println("longest = " + longest);
    }
    /**
     * 双指针+滑动窗口(自解正确)
     * @link : https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
     * //todo: 用动态规划怎么做?
     * @author Shaobo.Qian
     * @date 2020/5/4
     */
    public int lengthOfLongestSubstring(String s) {
        if (s ==null || "".equals(s)) return 0;
        //状态变量 i,字符串 s 的索引 ==>状态变量变化范围 0,s.len -1
        //dp 状态定义: dp[i]:字符串s 上从第一个字符到第 i+1字符中的一个最长的不包含重复字符的子字符串
        //定义变量 longestStr 来保存当前最长不包含重复字符的子串
//        String longestStr = s.substring(0, 1);
        int[] buffer = new int[128];
        //定义左右指针
        int l = 0, r = 0;
        int longest = 1;
        char rapid;
        //1.右指针右移,滑动到刚刚出现重复数字
        while (r < s.length()) {
            if (buffer[s.charAt(r)] > 0) {//统计当前滑动窗口区间的子串
                longest = Math.max(longest, r - l);
                rapid = s.charAt(r);
                while (l <= r) {//左指针右移
                    buffer[s.charAt(l++)]--;
                    if (buffer[rapid] == 0)
                        break;
                }
            } else {
                buffer[s.charAt(r++)]++;
            }
        }
        return Math.max(longest, r - l);
    }
}
