package first;

/**
 * @program: DeliAlgorithmEx
 * @description: 二进制求和
 * @author: Shaobo.Qian
 * @create: 2020-06-23 10:31
 **/

public class lc_67 {

    public static void main(String[] args) {
//        String a = "11", b = "1";
        String a = "1010", b = "1011";
        lc_67 solution = new lc_67();
        String res = solution.addBinary(a, b);
        System.out.println("res = " + res);
    }
    /**
     * anki
     * https://leetcode-cn.com/problems/add-binary/solution/hua-jie-suan-fa-67-er-jin-zhi-qiu-he-by-guanpengch/
     * @author Shaobo.Qian
     * @date 2020/6/23
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int temp = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = temp;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(sum % 2);
            temp = sum / 2;
        }
        res.append(temp == 1 ? temp : "");
        return res.reverse().toString();
    }
    /**
     * @author Shaobo.Qian
     * @date 2020/6/23
     */
    public String addBinary1(String a, String b) {
        if ("".equals(a) && "".equals(b))
            return "0";

        StringBuilder tempA = new StringBuilder();
        a = tempA.append(a).reverse().toString();
        StringBuilder tempB = new StringBuilder();
        b = tempB.append(b).reverse().toString();
        int len = Math.min(a.length(), b.length());
        StringBuilder res = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            int currRes = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))) + temp;
            String curr = String.valueOf(currRes % 2);
            res.append(curr);
            temp = currRes / 2;
        }
        if (a.length() > b.length()) {
            for (int i = len; i < a.length(); i++) {
                int currRes = Integer.parseInt(String.valueOf(a.charAt(i)))  + temp;
                String curr = String.valueOf(currRes % 2);
                res.append(curr);
                temp = currRes / 2;
            }
        }
        if (a.length() < b.length()) {
            for (int i = len; i < b.length(); i++) {
                int currRes = Integer.parseInt(String.valueOf(b.charAt(i)))  + temp;
                String curr = String.valueOf(currRes % 2);
                res.append(curr);
                temp = currRes / 2;
            }
        }
        if (temp > 0) {
            res.append(temp);
        }
        return res.reverse().toString();
    }
}
