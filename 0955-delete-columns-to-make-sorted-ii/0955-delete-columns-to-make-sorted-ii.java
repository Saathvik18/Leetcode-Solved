class Solution {
    public int minDeletionSize(String[] strs) {

        int len_mat = strs.length;
        int len_word = strs[0].length();
        int count = 0;
        
        int[] sorted = new int[len_mat-1];

        for(int j=0; j<len_word; j++){
            boolean delete = false;

            for(int i=0; i<len_mat-1; i++){
                if(sorted[i] == 0 && strs[i].charAt(j) > strs[i+1].charAt(j)){
                    delete = true;
                    break;
                }
            }

            if(delete){
                count++;
                continue;
            }

            for(int i=0; i<len_mat-1; i++){
                if(sorted[i] == 0 && strs[i].charAt(j) < strs[i+1].charAt(j)){
                    sorted[i] = 1;
                }
            }
        }
        return count;
    }
        
}
