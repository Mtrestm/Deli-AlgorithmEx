/**
 * @program: Deli-AlgorithmEx
 * @description: 快乐数
 * @author: Shaobo.Qian
 * @create: 2020-04-30 04:02
 **/

package undefined;

import java.util.HashSet;
import java.util.Set;

public class lc202 {

    public static void main(String[] args) {

//        int result = getResult(19);
        lc202 solution = new lc202();
        boolean happy = solution.isHappy(19);
        System.out.println("happy = " + happy);
    }


    /**
     * 递归
     * @author Shaobo.Qian
     * @date 2020/4/30
     */
    public boolean isHappy(int n) {
        Set<Integer> happySet = new HashSet<>();

        return judge(n,happySet) == 1;
    }

    private int judge(int n, Set<Integer> happySet) {
        int happy = 0;
        while (n >= 10) {
            int x = n % 10;
            n = n / 10;
            happy += x * x;
        }
        happy += n * n;
        if (!happySet.add(happy)) {
            return happy;
        }
        return happy == 1 ? 1 : judge(happy, happySet);
    }


    /**
     * 自解 (未解出)
     * @author Shaobo.Qian
     * @date 2020/4/30
     */
    public static boolean isHappy1(int n) {
        if (n == 1)
            return true;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            //1.求一个数的结果
            int res = getResult(n);
            if (res == 1)
                break;
            if (set.contains(res))
                return false;

        }
        return true;
    }

    private static int getResult(int n) {
        //n = 1098
        // 1

        int res = 0;
        while (n >= 10) {
            int a = n % 10;
            n = n / 10;
            res += a * a;
        }
        return (res + n * n);
    }
}
