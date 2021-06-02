package problems;

/**
 * @author cz
 * @create 2021/6/1 19:33
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class _454四数相加2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                int tem = i + i1;
                if (map.containsKey(tem)){
                    map.put(tem,map.get(tem)+1);
                }else {
                    map.put(tem,1);
                }
            }
        }
        for (int i : nums3) {
            for (int i1 : nums4) {
                int tem = i + i1;
                if (map.containsKey(0-tem)){
                    sum += map.get(0-tem);
                }
            }
        }
        return sum;
    }
}
