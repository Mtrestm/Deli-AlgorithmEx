/**
 * @program: Deli-AlgorithmEx
 * @description: 每个元音包含偶数次的最长子字符串
 * @author: Shaobo.Qian
 * @create: 2020-05-20 10:40
 **/

package 前缀和;

import java.util.Arrays;

public class lc_1371 {
    public static void main(String[] args) {
        int status = 0;
        System.out.println(status ^ (1 << 2));
        System.out.println(status ^ (1 << 1));
        System.out.println(4 ^ 2);
    }

    /**
     * //已入anki
     * @link: https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/mei-ge-yuan-yin-bao-han-ou-shu-ci-de-zui-chang-z-2/
     * @question
     * 1.其实每个子串对应着一个区间，那么有什么方法可以在不重复遍历子串的前提下，快速求出这个区间里元音字母出现的次数呢？==>什么算法?
     * 2.利用第一个提问的算法,在O(1) 的时间得到第k 个元音字母出现的次数的公式?
     * 3.通过什么数据结构来辅助优化该算法?
     * 4.维护元音字母出现的次数无法在本题中找到恒等式,应该改为维护元音字母的什么?
     * 5.如何将5 个元音字母出现次数的奇偶性压缩?(无需用a:cnta这样的键值对保存),压缩后的记录代表的含义?
     * @author Shaobo.Qian
     * @date 2020/5/20
     */
    public int findTheLongestSubstring(String s) {

        int len = s.length();
        //1.假如到第 i 个位置，u o i e a 出现的奇偶性分别为 1 1 0 0 1  <===定义 pos 来记录所有可能的元音字母为奇数的情况,每个索引idx对应1种为奇数的情况(用一个长度为32 的数组来存储对应状态出现的最早位置即可!!!)
        int[] pos = new int[1 << 5];//1<<5对应二进制数11111,(u o i e a五个元音字母对应的个数全为奇数)
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;//初始化的时候还没开始统计,当然是偶数(5位元音字母 u o i e a 对应的二进制为 0 0 0 0 0)
        //2.读取字符串
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);//i+1:为对应的状态(比如11001)现在出现的位置,pos[status]为对应状态最早;相当于-1后当前区间(i + 1 - pos[status])元音字母和肯定为偶数
            } else {//小于0才会走这里,即 pos[0] = 0不会被更新
                //pos[status]为对应状态出现的最早位置,第 i+1位(因为要返回字符串的长度,所以记为i+1)
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
