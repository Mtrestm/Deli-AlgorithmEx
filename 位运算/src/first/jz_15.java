/**
 * @program: Deli-AlgorithmEx
 * @description: 二进制中1的个数
 * @author: Shaobo.Qian
 * @create: 2020-03-11 17:23
 **/

package first;

public class jz_15 {

    /**
     * 位运算:利用n&(n-1)消除最右边的1
     * @author Shaobo.Qian
     * @date 2020/3/11
     *
     */
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    /**
     * 逐位判断
     * @author Shaobo.Qian
     * @date 2020/3/11
     */
    public int hammingWeight1(int n) {

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }



}
