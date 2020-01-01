/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-01 13:33
 **/

package fourth;

public class lc_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxLen = lengthOfLongestSubstring(s);
        System.out.println("maxLen = " + maxLen);


    }

    /**
     * 滑动窗口+双指针
     * @author Shaobo.Qian
     * @date 2020/1/1
     */
    public static int lengthOfLongestSubstring(String s) {//abcabcbb
        char[] c = s.toCharArray();
        //当前读取到的无重复的最长窗口的长度
        int maxLen = 0;
        //1.维护一个滑动窗口(考虑 buffer 里面记什么?这里记对应字符出现的位置)
        int[] buffer = new int[128];
        //2.维护构成一个滑动窗口的双指针,使左右指针滑动
        for (int left = 0, right = 0; right < s.length(); right++) {
            char rCh = s.charAt(right);
            //3.更新左指针
            left = Math.max(left, buffer[rCh]); //第二次出现 buffer['a'],left 代表的指针索引被更新为1,即 left 指向了重复字符'a'的下一个字符'b'
            //4.更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
            //5.记录当前右指针指向的字符在字符串中出现的位置(作为下一次左指针指向的位置)
            buffer[rCh] = right + 1;//第一次出现'a':buffer['a'] = 1
        }
        return maxLen;
    }

    /**
     * 滑动窗口+双指针
     *
     * @author Shaobo.Qian
     * @date 2020/1/1
     */
    public static int lengthOfLongestSubstring1(String s) {
        char[] c = s.toCharArray();
        //当前读取到的无重复的最长窗口的长度
        int maxLen = 0;
        //1.维护一个滑动窗口(考虑 buffer 里面记什么?这里记对应字符出现的位置)
        int[] buffer = new int[128];
        //2.维护构成一个滑动窗口的双指针
        for (int left = 0, right = 0; right < s.length(); right++) {
            char rCh = c[right];
            //3.当前的右指针指向的字符已经在读取到的字符串中出现了,更新最长无重复最长窗口的长度,同时更新左指针指向的位置
            if (buffer[rCh] > 0) {
                maxLen = Math.max(maxLen, right - left + 1);
                left = right + 1;
                buffer[rCh] = left;
            } else {
                buffer[rCh] = right;
            }
        }
        return maxLen;
    }

}
