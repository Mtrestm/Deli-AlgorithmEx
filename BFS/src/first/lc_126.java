package first;

import java.util.*;

/**
 * @program: DeliAlgorithmEx
 * @description: 单词接龙2
 * @author: Shaobo.Qian
 * @create: 2020-06-09 10:50
 **/

public class lc_126 {
    public static void main(String[] args) {
        String[] words = {"rex", "ted", "tex", "tad", "tax"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);

        lc_126 solution = new lc_126();
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }


    /**
     * @question
     * 1.如何获取当前节点的所有后继节点来填充邻接表(对应本题:当前字符串改变一个字符后可以转换的未被访问过的字符串)?
     * 2.为什么 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里?
     * 3.如何dfs回溯 来获取所有的可成功转换路径?
     * 4.为什么用 Deque 这种数据结构来保存每一个结果集(联系考虑下回溯的场景)?
     *
     * bfs +dfs(回溯)
     * @author Shaobo.Qian
     * @date 2020/6/9
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //处理边界
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0 || !wordList.contains(endWord))
            return res;

        //0.先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        //1.记录每个节点的所有邻居节点(key：字符串，value：广度优先遍历过程中 key 的后继结点列表)
        Map<String, Set<String>> successors = new HashMap<>();
        boolean foundEnd = bfs(beginWord, endWord, wordSet, successors);
        if (!foundEnd)
            return res;
        // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表(记录每个节点到起点的最短路径)
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> successors, Deque<String> path, List<List<String>> res) {
        //1.terminator
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!successors.containsKey(beginWord))
            return;
        //获取当前节点的所有后继节点
        Set<String> successorsWords = successors.get(beginWord);
        for (String nextWord : successorsWords) {
            path.addLast(nextWord);
            dfs(nextWord, endWord, successors, path, res);
            path.removeLast();//回溯,恢复状态
        }

    }

    private boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //记录被访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean foundEnd = false;
        int wordLen = beginWord.length();
        // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originChar = charArray[j];
                    //尝试将当前字符转换为其它所有可能的字符,得到新的字符串
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (charArray[j] == k) //字符一样,不需要尝试转换
                            continue;
                        charArray[j] = k;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (!visited.contains(nextWord)) {
                                if (nextWord.equals(endWord)) {
                                    foundEnd = true;
                                }
                                nextLevelVisited.add(nextWord);
                                queue.offer(nextWord);
                                // 维护 successors 的定义
                                successors.computeIfAbsent(currWord, a -> new HashSet<>());
                                successors.get(currWord).add(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            if (foundEnd)
                break;
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return foundEnd;
    }
}
