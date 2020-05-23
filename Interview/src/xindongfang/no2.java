/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-04-28 10:52
 **/

package xindongfang;

public class no2 {
    public static void main(String[] args) {

        no2 question = new no2();
        int lastCount = question.getLastCount(11);
        System.out.println("lastCount = " + lastCount);
    }

    public int getLastCount(int n) {
        int maxCount = maxSize(n);
        return n - ((maxCount >>> 1) - 1);
    }


    public int maxSize(int num) {
        int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
