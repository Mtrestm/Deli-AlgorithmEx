/**
 * @program: Deli-AlgorithmEx
 * @description: 最小覆盖子串
 * @author: Shaobo.Qian
 * @create: 2020-05-23 15:06
 **/

package fourth;

public class lc_76 {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0)
            return "";
        //total 为字符串 t 的长度
        int left = 0, right = 0, total = t.length();
        int winLeft = 0, winRight = -1, winLen = Integer.MAX_VALUE;
        int[] buffer = new int[128];
        for (char c : t.toCharArray()) {
            buffer[c]++;
        }
        while (right < s.length()) {//右指针满足条件右移
            char rCh = s.charAt(right);
//            char rCh = s.charAt(right++); //注意不能这样写,下面还用到 right 变量,此时不能 right++
            //如果是 t 中的目标字符
            if (buffer[rCh] > 0) {
                total--;
            }
            buffer[rCh]--;
            while (total == 0) {//左指针满足条件右移
                //满足条件,更新窗口左右指针
                int currWinLen = right - left + 1;
                if (currWinLen < winLen) {
                    winLeft = left;
                    winRight = right;
                    winLen = currWinLen;
                }
                char lCh = s.charAt(left++);
                buffer[lCh]++;
                if (buffer[lCh] > 0) {
                    total++;
                }
            }
            //最后才能执行right++
            right++;
        }
        return s.substring(winLeft, winRight + 1);
    }
}
