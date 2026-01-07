class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        if(n==1) return 1;
        int l=0;
        int index2=-1;
        int h=-1;
        int ans=0;
        int val1=fruits[0];
        int val2=-1;

        for(int i=1;i<n;i++){
            if(fruits[i] == val1) continue;
            val2=fruits[i];
            h=i;
            index2=h;
            while(i<n){
                if(fruits[i] == val1 || fruits[i]==val2){
                    
                
                    if(fruits[i] == val1) {
                        i++;
                        h++;
                        continue;
                    
                    }
                    else {
                        index2=i;
                        int temp = val1;
                        val1=val2;
                        val2=temp;
                    }
                    i++;
                    h++;
                    continue;
                }
                break;
            }
            ans=Math.max(ans,h-l);
            l=index2;
            val1=fruits[l];
            if(h < n) val2=fruits[h];
            i--;
        }
        if(val2==-1) return n;
        return ans;
    }
}