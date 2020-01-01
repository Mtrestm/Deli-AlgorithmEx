/**
 * @program: Deli-AlgorithmEx
 * @description:滑动窗口 +同向双指针
 * @author: Shaobo.Qian
 * @create: 2019-12-29 07:34
 **/

package third;

public class lc_3 {
    /**
     * 滑动窗口+窗口容器记录右指针对应元素在字符串中的最新的位置(为什么记这个值,是用来更新左指针的,从而完成左右指针的移动来维护窗口的大小变化)
     *
     * @author Shaobo.Qian
     * @date 2019/12/29
     */
    public int lengthOfLongestSubstring(String s) {
        //当前无重复最长子串
        int ans = 0;
        int len = s.length();
        //定义窗口容器(记录字符串中每个元素在字符串中的伴随右指针滑动出现的最新的位置)
        int[] buffer = new int[128];
        //定义左右指针
        for (int left = 0, right = 0; right < len; right++) {
            char rCh = s.charAt(right);
            //1.更新左指针(在窗口容器中找当前右指针指向的这个字符之前在字符串中出现的位置)
            left = Math.max(left, buffer[rCh]);
            //2.更新最长子串
            ans = Math.max(ans, right - left + 1);
            //3.更新记录右指针对应元素在字符串中的最新的位置
            buffer[rCh] = right + 1;
        }

        return ans;
    }
}
