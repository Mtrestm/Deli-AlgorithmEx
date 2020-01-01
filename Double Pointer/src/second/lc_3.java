/**
 * @program: Deli-AlgorithmEx
 * @description: 滑动窗口/双指针
 * @author: Shaobo.Qian
 * @create: 2019-12-15 03:29
 **/

package second;

public class lc_3 {


    public int lengthOfLongestSubstring(String s) {//abcade
        //当前无重复最长子串
        int ans = 0;
        int len = s.length();
        //定义窗口容器
        int[] buffer = new int[128];
        //定义左右指针
        for (int left = 0, right = 0; right < len; right++) {//满足条件,移动右指针
            //获取当前指针指向的字符
            char rCh = s.charAt(right);
            //更新左指针
            left = Math.max(left, buffer[rCh]);//0->1
            //更新当前无重复最长子串
            ans = Math.max(ans, right - left + 1); //3-1+1 ,right - left + 1:保证不重复时也能正常计算当前无重复最长子串
            //记录当前右指针指向元素在字符串中的位置
            buffer[rCh] = right + 1;
        }
        return ans;
    }
}