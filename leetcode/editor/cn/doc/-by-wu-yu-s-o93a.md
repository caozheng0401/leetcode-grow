

```java
class Solution {
    List<List<Integer>> ret;
    Deque<Integer> path;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ret = new LinkedList<>();
        path = new LinkedList<>();
        dfs(0, Integer.MIN_VALUE, nums);
        return ret;
    }

    void dfs(int level, int last, int[] nums) {
        if (level == nums.length) {
            if (path.size() >= 2)
                ret.add(new ArrayList<>(path));
            return;
        }
        if (nums[level] != last) {  // 考虑重复的情况 7 7 对应解 10(剔除)  01
            dfs(level + 1, last, nums);
        }
        if (nums[level] >= last) {
            path.addLast(nums[level]);
            dfs(level + 1, nums[level], nums);
            path.removeLast();
        }
    }
}
```