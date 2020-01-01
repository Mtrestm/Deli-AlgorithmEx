/**
 * @program: Deli-AlgorithmEx
 * @description:滑动窗口问题
 * @author: Shaobo.Qian
 * @create: 2019-12-15 05:13
 **/

package second;

public class lc_76 {
    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC"; //输出"BANC"
        String winStr = minWindow(s, t);
        System.out.println("winStr = " + winStr);
    }

    public static String minWindow(String s, String t) {
        //0.边界处理
        if (s == null || s.length() == 0) return "";
        //1.定义左右指针
        int left = 0, right = 0, sLen = s.length(), total = t.length();
        //2.定义窗口左右指针,记录最小子串长度
        int winLeft = 0, winRight = 0, winLen = Integer.MAX_VALUE;
        //3.定义目标数组,窗口数组
        char[] targetChars = t.toCharArray();
        int[] buffer = new int[128];
        for (char ch : targetChars) {
            buffer[ch]++;
        }
        //4.满足条件,移动右指针
        while (right < sLen) {
            char rCh = s.charAt(right);
            if (buffer[rCh] > 0) {
                total--;
            }
            buffer[rCh]--;
            while (total == 0) {
                //5.满足条件,更新窗口左右指针
                int currWinLen = right - left + 1;
                if (currWinLen < winLen) {
                    winLeft = left;
                    winRight = right;
                    winLen = currWinLen;
                }
                //6.满足条件,移动左指针
                char lCh = s.charAt(left);
                buffer[lCh]++;
                if (buffer[lCh] > 0) total++;
                left++;
            }
            right++;
        }
        return s.substring(winLeft, winRight + 1);
    }

}
