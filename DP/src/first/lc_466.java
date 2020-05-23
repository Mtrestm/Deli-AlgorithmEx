/**
 * @program: Deli-AlgorithmEx
 * @description: 统计重复个数
 * @author: Shaobo.Qian
 * @create: 2020-04-19 20:35
 **/

package first;

/**
 * todo:
 * @question: 1.[s2,n2]在 [s1,n1]中去匹配可能出现哪三种情况?
 * @author Shaobo.Qian
 * @date 2020/4/20
 * @link https://leetcode-cn.com/problems/count-the-repetitions/solution/bao-li-jie-fa-you-hua-jie-fa-java-dai-ma-by-liweiw/
 */
public class lc_466 {

    /**
     * 暴力法  
     * @author Shaobo.Qian
     * @date 2020/4/20 
     */
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // S1 = acbacbacbacb
        // 题目问 S2 = abab

        int len1 = s1.length();
        int len2 = s2.length();
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        //循环n1个 s1,统计s2出现的次数
        int idx2 = 0;
        int loopTimesOnS2 = 0;

        for (int i = 0; i < n1; i++) {
            for (int idx1 = 0; idx1 < len1; idx1++) {
                if (charArr1[idx1] == charArr2[idx2]) {
                    idx2++;
                }
                if (idx2 == len2) {
                    idx2 = 0;
                    loopTimesOnS2++;
                }
            }
        }

        return loopTimesOnS2 / n2;
    }

    public static void main(String[] args) {

        String s1 = "aceb";
        int n1 = 7;

        // aceb aceb aceb aceb aceb aceb aceb
        //    b   e  a  b   e  a  b   e  a  b ea

        // 因为顺序不同，会出现「交叉循环」的现象，只要 s1 足够长，一定可以把 s2 覆盖
        String s2 = "bea"; // 相当于给 s2 调整了一个顺序

        // 每一次一定可以找到一个

        int n2 = 1;

        int maxRepetitions = getMaxRepetitions(s1, n1, s2, n2);
        System.out.println("maxRepetitions = " + maxRepetitions);
    }
}
