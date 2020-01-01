/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-01 14:23
 **/

package third;

public class lc_76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC"; //"BANC"

    }

    /**
     * 滑动窗口
     *
     * @author Shaobo.Qian
     * @date 2020/1/1
     */
    public String minWindow(String s, String t) {
        if(s == null ||s.length() == 0) return "";
        //1.定义目标数组,要滑动的双指针
        int left = 0, right = 0, winL = 0, winR = -1, total = t.length(), winLen = Integer.MAX_VALUE;
        //2.定义窗口数组,窗口的左右边界(buffer里记什么?记录对应字符的个数)
        char[] targetChars = t.toCharArray();
        int[] buffer = new int[128];
        for (char ch : targetChars) {
            buffer[ch]++;
        }
        //3.满足条件,移动右指针
        while (right < s.length()) {
            char rCh = s.charAt(right);
            buffer[rCh]--;
            if (buffer[rCh] >= 0) {
                total--;
            }
            while (total == 0) {
                int currWinLen = right - left + 1;
                if (currWinLen < winLen) {
                    winLen = currWinLen;
                    winL = left;
                    winR = right;
                }
                //4.满足条件,移动左指针
                char lCh = s.charAt(left);
                // 因为要把当前字母移除，所有相应次数要加 1(这些字符在右指针移动的时候都被减执行了 buffer[rCh]--)
                buffer[lCh]++;
                if (buffer[lCh] > 0) {
                    total++;
                }
                //左指针右移
                left++;
            }
            // 右指针右移扩大窗口
            right++;
        }
        return s.substring(winL, winR+1);
    }
}
