/**
 * @program: Deli-AlgorithmEx
 * @description: 滑动窗口/双指针
 * @author: Shaobo.Qian
 * @create: 2019-12-14 11:09
 **/

package first;

public class lc_3 {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
//        String s = "au";
        System.out.println(" w = " + (int)s.charAt(0));

        int ans = lengthOfLongestSubstring(s);
        System.out.println("ans = " + ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        //0边界处理
        if (s == null ||s.length() ==0) return 0;
        //1.定义左右指针,无重复字符的最长子串
        int left = 0, right = 0, ans = 0;
        int len = s.length();
        int[] buffer = new int[128];
        //3.移动右指针,直到遇到重复元素
        while (right < len) {//右指针可以右移的条件
            char rCh = s.charAt(right);
            buffer[rCh]++;
            if (buffer[rCh] > 1) {//有重复
                // 3.1更新最长子串
                ans = Math.max(ans, right - left);
                while (left < right) {//左指针可以移动的条件
                    char lCh = s.charAt(left);
                    buffer[lCh]--;
                    left++;
                    if (lCh == rCh) break;
                }
            } else {//无重复
                ans = Math.max(ans, right - left + 1);
            }
            right++;
            // 3.2记录重复元素
        }
        //4.移动左指针,直到遇到之前记录的重复元素,重复第三步
        return ans;
    }

    /**
     *   
     * @author Shaobo.Qian
     * @date 2019/12/14
     * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     */
    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        int len = s.length();
        int[] buffer = new int[128];
        for (int left = 0, right = 0; right < len; right++) {
            char rCh = s.charAt(right);
            left = Math.max(buffer[rCh], left);// 当前字符如果重复,取出buffer 数组中记录了之前出现的位置,更新当前左指针的位置
            ans = Math.max(ans, right - left + 1);
            buffer[rCh] = right + 1;//更新当前元素位置(右指针指向的位置)(right+1:代表从当前元素是左往右的第几个元素)
        }
        return ans;
    }
}




