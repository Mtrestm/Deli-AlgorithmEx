/**
 * @program: Deli-AlgorithmEx
 * @description: 山脉数组中查找目标值
 * @author: Shaobo.Qian
 * @create: 2020-04-29 06:31
 **/

package first;

interface MountainArray {
    public int get(int index);

    public int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }
}

/**
 * 1.用二分查找求解该题分为哪三步? 2.二分查找时 取中位数mid的时候，怎么取才不会发生死循环?
 * @author Shaobo.Qian
 * @date 2020/4/29
 */
public class lc_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int size = mountainArr.length();
        //1.找到山顶元素
        int mountainTop = findMountaintop(mountainArr, 0, size - 1);
        //2.在前有序数组中找到 target所在的索引
        int res = findFromLeftArr(mountainArr, 0, mountainTop, target);
        if (res!=-1)
            return res;

        //3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
        return findFromRightArr(mountainArr, mountainTop, size - 1, target);

    }

    private int findFromRightArr(MountainArray mountainArr, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }
            if (mountainArr.get(l) == target)
                return l;
        }
        return -1;
    }

    private int findFromLeftArr(MountainArray mountainArr, int l, int r, int target) {
        // 在前有序且升序数组中找 target 所在的索引
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if (mountainArr.get(l) == target)
            return l;
        return -1;
    }

    private int findMountaintop(MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 取左中位数，因为进入循环，数组一定至少有 2 个元素
            // 因此，左中位数一定有右边元素，数组下标不会发生越界
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 根据题意，山顶元素一定存在，因此退出 while 循环的时候，不用再单独作判断
        return l;
    }

}
