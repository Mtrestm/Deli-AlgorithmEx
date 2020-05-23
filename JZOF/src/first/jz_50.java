/**
 * @program: Deli-AlgorithmEx
 * @description: 第一个只出现一次的字符
 * @author: Shaobo.Qian
 * @create: 2020-05-03 18:19
 **/

package first;

public class jz_50 {
    public static void main(String[] args) {
        String s = "cc";
        jz_50 solution = new jz_50();
        char c = solution.firstUniqChar(s);
        System.out.println("c = " + c);
    }
    public char firstUniqChar(String s) {
        if ("".equals(s)) return ' ';

        int[] buffer = new int[128];
        //1.第一次遍历,统计所有字符出现的次数
        for (char c : s.toCharArray()) {
            buffer[c - 'a']++;
        }


        //2.找到其中索引最小的元素
        int minIdx = Integer.MAX_VALUE;

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == 1) {
                int idx = s.indexOf(i + 'a');
                minIdx = Math.min(minIdx, idx);
            }

        }
        return minIdx == Integer.MAX_VALUE ? ' ' : s.charAt(minIdx);
    }

}
