class Solution {
    public int change(int amount, int[] coins) { 
        int[] cache = new int[amount+1];
        cache[0] = 1;
        
        for(int c: coins){
            for(int j = c; j <= amount; j++){
                cache[j] += cache[j-c];
            }
        }
        return cache[amount];
    }
}