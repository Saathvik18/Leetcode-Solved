class Solution {

    class Pair{
        int a;
        int b;
        Pair(int x,int y){
            a=x;
            b=y;
        }
    }

    public int[] topKFrequent(int[] nums,int k){
        if(k==0) return new int[0];
        int n=nums.length;
        if(n==1) return nums;

        Arrays.sort(nums);

        int[] ans=new int[k];

        PriorityQueue<Pair> pq2=new PriorityQueue<>((p1,p2)->{
            if(p1.b<p2.b) return 1;
            if(p1.b>p2.b) return -1;
            return 0;
        });

        int temp=nums[0];
        int c=1;

        for(int i=1;i<n;i++){
            if(nums[i]==temp){
                c++;
            }else{
                pq2.add(new Pair(temp,c));
                temp=nums[i];
                c=1;
            }
        }
        pq2.add(new Pair(temp,c));

        for(int i=0;i<k;i++){
            ans[i]=pq2.poll().a;
        }
        return ans;
    }
}