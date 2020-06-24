/**
 * @program: Deli-AlgorithmEx
 * @description: 把数组排成最小的数
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:35
 **/

package first;

import java.util.ArrayList;
import java.util.List;

/**
 * @link: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
 * //todo: 补充快排解法
 * @author Shaobo.Qian
 * @date 2020/5/3
 */
public class jz_45 {
    public static void main(String[] args) {
        System.out.println("1/10 = " + 1 / 10);
        jz_45 solution = new jz_45();
        int[] nums = {3,30,34,5,9};
        String s = solution.minNumber(nums);
        System.out.println("s = " + s);

    }

    /**
     * anki
     * 排序
     * @link: https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
     * @question
     * 0.本题实际上是一个什么问题?
     * 1.排序的规则是什么?
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        //按照规则排序
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String s : strList) {
            res.append(s);
        }

        return res.toString();

    }
    /**
     * 原解:(理解错题意)
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public String minNumber1(int[] nums) {
        if (nums.length == 0) return "";
        //1.将所有数字重新放入数组中,统计每个数字出现的个数
        int[] buffer = new int[10];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num >= 10) {
                int idx = num % 10;
                buffer[idx]++;
                num /= 10;
            }
            buffer[num]++;
        }

        //0333459==>3033459
        //2.将nums数组中出现的所有数字按顺序组成字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < buffer.length; i++) {
            int count = buffer[i];
            while (count > 0) {
                res.append(i);
                count--;
            }
        }

        //3.处理返回结果(处理首位是0的情况)
        return getTargetStr(res);
    }

    private String getTargetStr(StringBuilder res) {
        char[] buffer = res.toString().toCharArray();
        if (buffer[0]!= '0')
            return res.toString();
        for (int i = 1; i < buffer.length; i++) {
            if (buffer[i] != '0') {

                buffer[0] = buffer[i];
                buffer[i] = '0';
                break;
            }
        }
        return new String(buffer);
    }

}
