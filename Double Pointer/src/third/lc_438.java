/**
 * @program: Deli-AlgorithmEx
 * @description: 滑动窗口+双指针
 * @author: Shaobo.Qian
 * @create: 2020-01-03 08:52
 **/

package third;

import java.util.ArrayList;
import java.util.List;

public class lc_438 {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc"; //[0, 6]
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("anagrams = " + anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        //1.定义变量: 1.1目标字符串 p中字符的个数
        int total = p.length();
        //2.定义目标数组
        int[] buffer = new int[128];
        for (int i = 0; i < p.length(); i++) {
            buffer[p.charAt(i)]++;
        }

        //3.初始化左右双指针
        for (int left = 0, right = 0; right < s.length();) {//右指针移动,到刚刚包含p
            char rCh = s.charAt(right);
            buffer[rCh]--;
            if (buffer[rCh] >= 0) {
                total--;
            }
            while (total == 0) {
                if (right - left + 1 == p.length()) {//满足是异位词
                    result.add(left);
                }
                char lCh = s.charAt(left);
                buffer[lCh]++;
                if (buffer[lCh] > 0) {
                    total++;
                }
                left++;//移动左指针直至刚刚不包含 p
            }
            right++;
        }
        return result;
    }

}
