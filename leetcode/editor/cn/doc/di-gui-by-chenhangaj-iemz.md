```java
//返回二叉树的所有路径
    //前序遍历试下
    List<String> pathList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String res = "";
        binaryTreePathsHelper(root,res);
        return pathList;
    }
    public void binaryTreePathsHelper(TreeNode root, String res) {
        if(root == null){return;}
        if(root.left == null && root.right == null){
            res += root.val;
            pathList.add(res);
        }
        res += root.val + "->";
        binaryTreePathsHelper(root.left, res);
        binaryTreePathsHelper(root.right,res);
    }
```

