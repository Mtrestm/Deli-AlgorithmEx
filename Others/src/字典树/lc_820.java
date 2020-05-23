/**
 * @program: Deli-AlgorithmEx
 * @description: 单词的压缩编码
 * @author: Shaobo.Qian
 * @create: 2020-03-28 22:01
 **/

package 字典树;

import java.util.Arrays;

/**
 *
 * @question:1.单词树中TireNode节点的数据结构如何定义? 2.单词树 Tire 的数据结构如何定义 3.单词树一般是以前缀匹配的方式插入(该题中要求后缀匹配,需要怎么处理?)
 * @author Shaobo.Qian
 * @date 2020/3/28
 */
public class lc_820 {

    class Tire{
        TireNode root;

        public Tire() {
            root = new TireNode();
        }

        public int insert(String word) {
            TireNode cur = root;
            boolean isNew = false;
            //倒着插入单词
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    isNew = true;
                    cur.children[c] = new TireNode();
                }
                cur = cur.children[c];
            }
            return isNew ? word.length() + 1 : 0;
        }
    }
    class TireNode{
        char val;
        TireNode[] children = new TireNode[26];
        public TireNode() {
        }
    }
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Tire tire = new Tire();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word : words) {
            len += tire.insert(word);
        }

        return len;
    }

}
