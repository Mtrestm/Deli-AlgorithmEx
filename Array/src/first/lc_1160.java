/**
 * @program: Deli-AlgorithmEx
 * @description:拼写单词
 * @author: Shaobo.Qian
 * @create: 2020-03-17 23:38
 **/

package first;

public class lc_1160 {

    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        int[] cArr = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            cArr[chars.charAt(i) - 'a']++;
        }
        nextWord:
        for (String word : words) {
            int wLen = word.length();
            int[] wArr = new int[26];
            for (int i = 0; i < wLen; i++) {
                wArr[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (wArr[i] > cArr[i]) {
                    continue nextWord;
                }
            }
            sum += wLen;
        }

        return sum;
    }

}
