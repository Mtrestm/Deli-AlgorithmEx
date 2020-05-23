/**
 * @program: Deli-AlgorithmEx
 * @description: 卡牌分组
 * @author: Shaobo.Qian
 * @create: 2020-03-27 20:55
 **/

package first;

import java.util.*;

public class lc_914 {
    public static void main(String[] args) {
        int res = gy(8, 6);
        System.out.println("res = " + res);

    }
    /**
     * @author Shaobo.Qian
     * @date 2020/3/27
     */
    public boolean hasGroupsSizeX(int[] deck) {//m,n的有公约数 6,8
        if (deck.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        //最大公约数(数量最少的重复数的个数能整除其它的)
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        Collection<Integer> values = map.values();
        int divisor = Integer.MAX_VALUE;
        for (int value : values) {
            divisor = Math.min(divisor, value);
        }
        if (divisor < 2) return false;
        for (Integer value : values) {
            divisor = gy(divisor, value);
            if (divisor <2) return false;
        }

        return true;
    }

    public static int gy(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
