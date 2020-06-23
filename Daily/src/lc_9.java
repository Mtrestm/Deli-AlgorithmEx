/**
 * @program: DeliAlgorithmEx
 * @description: 回文数
 * @author: Shaobo.Qian
 * @create: 2020-06-11 17:07
 **/

public class lc_9 {
    public static void main(String[] args) {
        lc_9 solution = new lc_9();
//        boolean res = solution.isPalindrome(121);
        boolean res = solution.isPalindrome(1001);
        System.out.println("res = " + res);
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/6/11
     */
    public boolean isPalindrome(int x) {
        int originX = x;
        if (x == 0)
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int res = 0;
        int n = 0;
        while (x >= 10 || x % 10 != 0){
            res = res * 10 + x % 10;//之前已处理的结果*10+当前的数字(余数)
            x /= 10;
        }
//        System.out.println("res = " + res);
        return res == originX;
    }
}
