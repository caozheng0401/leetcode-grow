### 解题思路
![image.png](https://pic.leetcode-cn.com/1622738810-NmFLEv-image.png)
搜索左右子树：直到叶子节点而且当前的和等于目标target时把当前路径加到结果中

### 代码

```java
class Solution {
     List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, 0, new ArrayList<Integer>());
        return result;
    }
    public void dfs(TreeNode root, int target, int sum, List<Integer> tempAns){
        if(root == null) return;
        else {
            tempAns.add(root.val);
            if(root.left == null && root.right == null && sum + root.val == target)
                result.add(new ArrayList<Integer>(tempAns));
            else {
                dfs(root.left, target, sum + root.val, tempAns);
                dfs(root.right, target, sum + root.val, tempAns);
            }
            tempAns.remove(tempAns.size() - 1); 
        }
    }
}
```