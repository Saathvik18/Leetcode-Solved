class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        int ans=0;
        int row=0;
        for(int i=n-1;i>=0;i--){
            if(row < m && grid[row][i] < 0){
                ans=ans+ (m - row);
                continue;
            }
            else{
                while (row < m && grid[row][i] >= 0 ){
                    if(row == m-1) break;
                    row++;
                    
                }
                if(row == m-1 && grid[row][i] >= 0) return ans;
                ans=ans+ (m-row);
            }

        }
        return ans;
    }
}