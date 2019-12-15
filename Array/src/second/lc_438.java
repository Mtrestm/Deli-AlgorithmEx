/**
 * @program: Deli-AlgorithmEx
 * @description:滑动窗口问题
 * @author: Shaobo.Qian
 * @create: 2019-12-15 06:13
 **/

package second;

import java.util.ArrayList;
import java.util.List;

public class lc_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = findAnagrams(s, p);
        res.forEach(System.out::println);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        //0.处理边界
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        //1.定义左右指针
        int left = 0, right = 0, len = s.length(), total = p.length();
        //2.转换成数组
        //目标数组
        int[] target = new int[128];
        for (char ch : p.toCharArray()) {
            target[ch]++;
        }
        //窗口数组
        int[] window = new int[128];
        //2.满足条件,移动右指针(移动右指针,直到刚刚包含 t)
        while (right < len) {
            char rCh = s.charAt(right);
            //3.出现了目标字符串中的字符
            if (target[rCh] > 0) {
                window[rCh]++;
                if (window[rCh] <= target[rCh]) {//3.1处理窗口数组中出现超过目标字符串中的相应字符数目的情况
                    total--;
                }
            }
            //3.满足条件,记录结果,移动左指针(移动左指针,直到刚刚不包含 t)
            while (total == 0) {
                if (right - left + 1 == p.length()) res.add(left);
                char lCh = s.charAt(left);
                if (target[lCh] > 0) {
                    window[lCh]--;
                    if (window[lCh] < target[lCh]) {//移动左指针,直到刚刚不包含 t
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
