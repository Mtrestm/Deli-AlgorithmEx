/**
 * @program: Deli-AlgorithmEx
 * @description: 滑动窗口/双指针
 * @author: Shaobo.Qian
 * @create: 2019-12-11 08:05
 **/

package first;

public class lc_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC"; //"BANC"
        String res = minWindow(s, t);
        System.out.println("res = " + res);
    }

    /**
     * 仿解
     * @author Shaobo.Qian
     * @date 2019/12/13
     * @link https://leetcode-cn.com/problems/minimum-window-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-3/
     */
    public static String minWindow(String s, String t) {
        //0.边界判断
        if (s == null || s.length() == 0) return "";
        //1.定义左右指针
        int left = 0, right = 0, total = t.length();
        //2.定义最小窗口的左边界,最小窗口的右边界,当前最小窗口的长度(winLeft,winRight只记录并参与结果计算,并不用来移动)
        int winLeft = 0,winRight = -1, winLen = Integer.MAX_VALUE;
        int[] buffer = new int[128];
        for (char c : t.toCharArray()) {
            buffer[c]++;
        }
        //3.移动右指针,直到包含 t
        while (right < s.length()) {//可以移动右指针的条件
            char rCh = s.charAt(right);
            //3.1 当前右指针指向的字母次数减一
            buffer[rCh]--;
            //3.2如果是目标字符串中的字符
            if (buffer[rCh] >= 0) {
                total--;
            }
            //4.移动左指针,直到刚刚不包含 t
            while (total == 0) {//可以移动左指针的条件
                // 当前窗口大小
                int currWinLen = right - left + 1;
                // 如果当前窗口更小，则更新相应变量
                if (currWinLen < winLen) {
                    winLeft = left;
                    winRight = right;
                    winLen = currWinLen;
                }
                //获取左指针
                char lCh = s.charAt(left);
                // 因为要把当前字母移除，所有相应次数要加 1
                buffer[lCh]++;
                if (buffer[lCh] > 0) total++;
                left++;//左指针右移
            }
            // 右指针右移扩大窗口
            right++;
        }
        return s.substring(winLeft, winRight + 1);
    }
}
