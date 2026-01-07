class Solution {
    long mod=1000000007;

    public int find_total(TreeNode root){
        if(root==null) return 0;
        return root.val+find_total(root.left)+find_total(root.right);
    }

    public int maxProduct(TreeNode root){
        int total=find_total(root);
        manipulate(root);
        return (int)(traverse(root,total)%mod);
    }

    public int manipulate(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        root.val=root.val + manipulate(root.left)+manipulate(root.right);
        return root.val;
    }

    public long traverse(TreeNode root,int total){
        if(root==null) return 0;

        long temp=(long)root.val*(total-root.val);
        long ans1=Math.max(temp,traverse(root.left,total));
        long ans2=Math.max(temp,traverse(root.right,total));

        return Math.max(ans1,ans2);
    }
}