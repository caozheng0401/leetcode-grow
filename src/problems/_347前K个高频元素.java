package problems;

import java.util.*;

/**
 * @author cz
 * @create 2021/6/7 0:55
 */
public class _347前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> temp = new HashMap<>();
        for (int num : nums) {
            temp.put(num,temp.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = temp.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> entries1 = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : entries) {
            entries1.add(integerIntegerEntry);
            if (entries1.size() > k){
                entries1.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >=0; i--) {
            result[i] = entries1.poll().getKey();
        }
        return result;
    }
}
