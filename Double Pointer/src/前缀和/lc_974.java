/**
 * @program: Deli-AlgorithmEx
 * @description: 和可被 K 整除的子数组
 * @author: Shaobo.Qian
 * @create: 2020-05-27 06:49
 **/

package 前缀和;

import java.util.HashMap;
import java.util.Map;

public class lc_974 {
    public static void main(String[] args) {
        System.out.println(-2 % 5); //-2
        System.out.println((-2 % 5 + 5) % 5); //3
        // -2 , 5 ==>sum(1,1) = P[1] - P[0] ==>P[1],P[0]同余,余数都为3 ,所以 sum(1,1)复合条件((P[1] - P[0])%K==0 即5%5==0)
    }

    /**
     * @question
     * 1.什么是前缀和?什么是同余定理?
     * 2.如何使用前缀和+同余定理推导出本题的解题公式?
     * 3.由上面推导出的公式,解题需要借助哪种数据结构记录什么
     * 4.如何考虑前缀和本身被 K整除的情况?
     * @author Shaobo.Qian
     * @date 2020/5/27
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        //千万别忘记初始化,这样考虑前缀和本身被 K整除的情况也能统计到
        record.put(0, 1);
        int sum = 0, res = 0;
        for (int cur : A) {
            sum += cur;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modules = (sum % K + K) % K;
            int same = record.getOrDefault(modules, 0);
            res += same;//为什么+same;因为存在same 个前缀和余数相同和当前位置组成 same 个可以被 K 整除的区间
            record.put(modules, same + 1);
        }
        return res;
    }
}