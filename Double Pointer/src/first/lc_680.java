/**
 * @program: Deli-AlgorithmEx
 * @description: 回文串
 * @author: Shaobo.Qian
 * @create: 2019-12-23 08:42
 **/

package first;

public class lc_680 {
    public static void main(String[] args) {
//        String s = "abca";
//        String s = "abca";
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        boolean b = validPalindrome(s);
        System.out.println("b = " + b);
    }

    /**
     * 仿解:双指针
     * @author Shaobo.Qian
     * @date 2019/12/24
     * @link https://leetcode-cn.com/problems/valid-palindrome-ii/solution/shuang-zhi-zhen-by-sy_say/
     */
    public static boolean validPalindrome(String s) {//一个非空字符串 s，最多删除一个字符
        //1.双指针同时遍历,判断是否相等
        char[] c = s.toCharArray();
        boolean hasDelFlag = true;
        for (int start = 0, end = c.length - 1; start < end; start++, end--) {
            if (c[start] != c[end]) {
                //2.分两种情况,只要满足任意一种即可(跳过左边或者跳过右边)
                return isPalindrome(c, start, end - 1) || isPalindrome(c, start + 1, end);
            }
        }
        return true;
    }

    private static boolean isPalindrome(char[] c, int start, int end) {
        while (start < end) {
            if (c[start++] != c[end--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 原解,未解出
     *
     * @author Shaobo.Qian
     * @date 2019/12/24
     */
    public static boolean validPalindrome1(String s) {//一个非空字符串 s，最多删除一个字符
        //1.双指针同时遍历,判断是否相等
        char[] c = s.toCharArray();
        boolean hasDelFlag = true;
        for (int start = 0, end = c.length - 1; start <= end; ) {
            if (c[start] == c[end]) {
                start++;
                end--;
                continue;
            } else if (hasDelFlag && c[start + 1] == c[end]) {
//                start += 2;
                start++;
//                end--;
                hasDelFlag = false;
                continue;
            } else if (hasDelFlag && c[start] == c[end - 1]) {
//                start++;
                end--;
                hasDelFlag = false;
                continue;
            }
            return false;
        }
        //2.不相等的情况,删除左边(左边++,再判断) || 删除右边(右边++,再判断)
        return true;
    }
}
