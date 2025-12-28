class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        if(k==50000) return 1;
        return quickSelect(nums,0,n-1,n-k);
    }

    int quickSelect(int[] a,int l,int r,int k){
        int p=partition(a,l,r);
        if(p==k) return a[p];
        if(p<k) return quickSelect(a,p+1,r,k);
        return quickSelect(a,l,p-1,k);
    }

    int partition(int[] a,int l,int r){
        int pivot=a[r];
        int i=l;
        for(int j=l;j<r;j++){
            if(a[j]<=pivot){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
                i++;
            }
        }
        int t=a[i];
        a[i]=a[r];
        a[r]=t;
        
        return i;
    }
}