### 解题思路
回溯模板：

```
class Solution {
    //1.全局变量，这样方便回溯方法少点参数传递
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //2.预处理待回溯数组（比如用到used数组时需要排序待回溯数组nums）和调用回溯方法
        backTracking(target,candidates,0);
        return res;
    }

    void backTracking(int n, int[] candidates, int start){
        //3.给个递归终止条件        
        if(n < 0)
            return;
        if(n == 0){
            res.add(new ArrayList<>(path));
            return;
        }
 
       //4.遍历同层所有元素
        for(int i = start; i < candidates.length; i++){
            //5.path添加这个被遍历的元素            
            path.addLast(candidates[i]);

            backTracking(n-candidates[i],candidates,i);

            //6.**回退**path到没添加该元素的状态
            path.removeLast();
        }

    }
}
```
### 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> res = new ArrayList<>();
    String path = "";
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        path += root.val;//例子[1,2,3,null,5]，根节点1先加入
        
        backTracking(root);//回溯
        return res;

    }
    
    void backTracking(TreeNode root){
        //回溯终止条件
        if(root.left == null && root.right == null)//如果当前是叶子节点了，该保存结果了
            res.add(path);


        //遍历同层所有元素
        //左右子树，本质上和for(int i = start; i < nums.lengh; i++)作用一样，把同层元素都给遍历了；如果是三叉树，那就要写三个if语句块遍历
        if(root.left != null){
            String temp = path;//保存此时的path便于回退
            
            path += "->" + root.left.val;//添加节点
            backTracking(root.left);
            path = temp;

        }
        if(root.right != null){
            String temp = path;//保存此时的path便于回退

            path += "->" + root.right.val;
            backTracking(root.right);
            path = temp;
        }


    }
}
```