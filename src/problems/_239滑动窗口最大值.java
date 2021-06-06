package problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cz
 * @create 2021/6/7 0:08
 */
public class _239滑动窗口最大值 {
    private class MyQueue {
        Deque<Integer> deqeq = new LinkedList<>();

        void pop(int val) {
            if (!deqeq.isEmpty() && val == deqeq.peek()) {
                deqeq.poll();
            }
        }

        void add(int val) {
            while (!deqeq.isEmpty() && val > deqeq.getLast()) {
                deqeq.removeLast();
            }
            deqeq.add(val);
        }

        int peek() {
            return deqeq.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k;i<nums.length;i++){
            myQueue.pop(nums[i-k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}
