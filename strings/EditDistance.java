class EditDistance {
    
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        
        return dist(word1, word2, 0, 0);
    }
    
    int[][] dp;
    
    int dist(String word1, String word2, int idx1, int idx2){
        
        if(idx1 == word1.length() && idx2 == word2.length())
            return 0;
        
        if(word1.length() == idx1)
            return word2.length() - idx2;
        
        if(word2.length() == idx2)
            return word1.length() - idx1;
        
        if(dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        
        int res = 0;
        
        if(word1.charAt(idx1) == word2.charAt(idx2)){
            res = dist(word1, word2, idx1 + 1, idx2 + 1);
        }else{
            int ins = dist(word1, word2, idx1, idx2 + 1);
            int del = dist(word1, word2, idx1+1, idx2);
            int rep = dist(word1, word2, idx1+1, idx2+1);
            
            res = 1 + Math.min(ins, Math.min(del, rep));
        }
        
        dp[idx1][idx2] = res;
        
        return res;
    }
    
}
