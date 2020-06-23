package first;

/**
 * @program: DeliAlgorithmEx
 * @description: 等式方程的可满足性
 * @author: Shaobo.Qian
 * @create: 2020-06-09 15:28
 **/

public class lc_990 {
    /**
     * 并查集
     * @question:
     * 1.使用并查集来判断等式方程的可满足性的整体思路分为哪两步?
     * 2.并查集查找根节点的路径压缩方式怎么写?
     * 3.并查集如何关联两个节点
     * 4.并查集如何判断两个节点的连通性?
     * @author Shaobo.Qian
     * @date 2020/6/9
     * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/solution/shi-yong-bing-cha-ji-chu-li-bu-xiang-jiao-ji-he-we/
     */
    public boolean equationsPossible(String[] equations) {
        //1.第一次遍历将所有==的节点关联
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '=') {
                int node1 = charArray[0] - 'a';
                int node2 = charArray[3] - 'a';
                unionFind.union(node1, node2);
            }
        }
        //2.第二次遍历验证所有!=的节点是否有关联
        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '!') {
                int node1 = charArray[0] - 'a';
                int node2 = charArray[3] - 'a';
                if (unionFind.isConnected(node1,node2))
                    return false;
            }
        }
        // 如果检查了所有不等式，都没有发现矛盾，返回 true
        return true;
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 查找根节点(路径压缩)
         */
        public int find(int x) {
            while (x != parent[x]) { //路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         * 合并节点
         * x,y 两个节点向上搜索,然后将它们的根节点连接
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;//将两个节点合并,(rootX->rootY)
        }
        /**
         * 2个节点是否连通
         */
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

    }
}
