/**
 * @program: Deli-AlgorithmEx
 * @description: 求1+2+…+n
 * @author: Shaobo.Qian
 * @create: 2020-06-02 05:59
 **/

package first;

public class jz_64 {
    public static void main(String[] args) {
        jz_64 solution = new jz_64();
        int res = solution.sumNums(5);
        System.out.println("res = " + res);
    }

    /**
     * 改进递归
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    int res;

    public int sumNums(int n) {
        //1.terminator
        boolean x = n > 1 && sumNums(n - 1) >= 0;
        //2.current level
        res += n;
        return res;
    }

    /**
     * 普通递归
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int sumNums0(int n) {
        //1.terminator
        if (n == 0)
            return 0;
        //2.current level
        res += n;
        sumNums0(n - 1);
        return res;
    }
}
