/**
 * @program: Deli-AlgorithmEx
 * @description: 将数组分成和相等的三个部分
 * @author: Shaobo.Qian
 * @create: 2020-03-11 06:46
 **/

package first;

public class lc_1013 {

    /**
     * 双指针
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     */
    public boolean canThreePartsEqualSum(int[] A) {
        //### 解题思路
        //1. 数组从头往尾找,得到左边小数组满足和为average的最小范围索引l
        //2. 数组从尾往头找,得到右边小数组满足和为average的最小范围索引r
        //3. 如果仍然满足l + 1 < r的条件,剩下中间部分和肯定也为average
        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) return false;
        int average = sum / 3;
        int l = 0, r = len - 1;
        int lSum = 0;
        int rSum = 0;
        //数组从头往尾找,最小和为average :得到索引 l
        while (l + 1 < r) {
            lSum += A[l];
            if (lSum == average)
                break;
            else
                l++;
        }
        //数组从尾往头找,最小和为average  得到索引 r
        while (l + 1 < r) {
            rSum += A[r];
            if (rSum == average)
                //左右都确定了中间部分一定满足
                return true;
            else
                r--;
        }
        return false;
    }
}
