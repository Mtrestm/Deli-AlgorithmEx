/**
 * @program: Deli-AlgorithmEx
 * @description: 最长回文串
 * @author: Shaobo.Qian
 * @create: 2020-03-19 17:31
 **/

package first;

public class lc_409 {
    public static void main(String[] args) {
        System.out.println("'Z'-'a' = " + ('Z' - 'a'));

        String s =
                "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        int res = longestPalindrome(s);
        System.out.println("res = " + res);
    }

    public static int longestPalindrome(String s) {
        int longest = 0;
        int len = s.length();
        int[] buffer = new int[('z'-'A')+1];
        for (int i = 0; i < len; i++) {
            buffer[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] % 2 == 0)
                longest += buffer[i];
            else
                longest += (buffer[i] - 1);
        }

        return  longest != len ? longest + 1 : longest;
    }
}
