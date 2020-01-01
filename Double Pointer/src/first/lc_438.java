/**
 * @program: Deli-AlgorithmEx
 * @description: 滑动窗口/双指针
 * @author: Shaobo.Qian
 * @create: 2019-12-10 09:17
 **/

package first;

import java.util.ArrayList;
import java.util.List;

public class lc_438 {


    public static void main(String[] args) {

        String s = "cbaebabacd", p = "abc";
        List<Integer> res = findAnagrams(s, p);
        res.forEach(System.out::println);
    }

    /**
     * 仿解
     *
     * @author Shaobo.Qian
     * @date 2019/12/11
     * @link https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
     */
    public static List<Integer> findAnagrams(String s, String p) {

        //0.边界判断
        List<Integer> res = new ArrayList<>(); //收集结果
        if (s == null || s.length() == 0) return res;
        //1.定义左右指针
        int left = 0, right = 0, total = p.length();
        int[] target = new int[26];//目标数组
        int[] window = new int[26];//窗口数组

        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        while (right < s.length()) {//可以移动右指针的条件
            //2.移动右指针,直到包含 t
            char rCh = s.charAt(right);
            //2.1如果出现目标字符串中的字符
            if (target[rCh - 'a'] > 0) {
                window[rCh - 'a']++;
                //2.2防止目标字符在窗口数组中出现次数多于在目标字符串中出现的次数
                if (window[rCh - 'a'] <= target[rCh - 'a']) {
                    total--;
                }
            }
            //3.移动左指针,直到刚刚不包含 t
            while (total == 0) {//可以移动左指针的条件
                if ((right - left + 1) == p.length()) {//满足,是异位词
                    res.add(left);
                }
                char lCh = s.charAt(left);
                if (target[lCh - 'a'] > 0) {
                    window[lCh - 'a']--;
                    if (window[lCh - 'a'] < target[lCh - 'a']) {
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
