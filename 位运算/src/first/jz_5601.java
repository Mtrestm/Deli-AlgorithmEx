/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-05-05 16:55
 **/

package first;

public  class jz_5601 {

    /**
     * //已入anki!!!
     * @question:
     * 1.如果是一个数组中除一个数字只出现一次外，其他数字都出现2次。那么如何找出这个只出现一次的数字？
     * 2.这个数组中有两个数字只出现一次，剩下的数字都是出现两次的。如何找到这两个只出现一次的数字?
     * 3.如何求出一个数只保留最低位的那个1(作为掩码)?
     * @author Shaobo.Qian
     * @date 2020/4/28
     */
    public int[] singleNumbers(int[] nums) {

        //1.xorNumber为对整个数组求异或，用于求出分组条件(对所有数字异或,一样的数字抵消,出现一次的两个数字异或运算后必定不为0)
        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
        }
        //2.得到一个二进制位最右边一位为1的数字mask,也就是'要求两个不同的数'出现不等的地方，异或运算，相同为0,不同为1
        //mask举例: 0000 0100
        int mask = xorNumber & (-xorNumber);


        int[] res = new int[2];
        //3.1通过掩码将数组终所有的元素分为两组
        for (int num : nums) {
            //3.2第一组中的所有元素异或,得到结果1
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                //3.3第二组中的所有元素异或,得到结果1
                res[1] ^= num;
            }
        }
        return res;
    }
}
