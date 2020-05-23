/**
 * @program: Deli-AlgorithmEx
 * @description: II. 数组中数字出现的次数 II
 * @author: Shaobo.Qian
 * @create: 2020-05-05 17:05
 **/

package first;

public class jz_5602 {
    public static void main(String[] args) {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        jz_5602 solution = new jz_5602();
        int res = solution.singleNumber(nums);
        System.out.println("res = " + res);
    }

    /**
     * 位运算
     *
     * @link: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     * @question:
     * 1.求解除了一个数字以外，其余数字都出现的问题的通用思路(位运算)是怎样的?
     *
     *
     * @author Shaobo.Qian
     * @date 2020/5/6
     */
    public int singleNumber(int[] nums) {
        //1.遍历统计,可记录所有数字的各二进制位的1的出现次数
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1; //统计 num 从低位到高位出现的1
            }
        }
        int res = 0, m = 3;

        //2.利用 左移操作 和 或运算,可将counts数组中各二进位的值恢复到数字res 上
        for (int i = 31; i >= 0; i--) {
            res <<= 1;// 左移 1 位
            res |= counts[i] % m;// 从高位到低位恢复值到 res
        }
        return res;
    }
}
