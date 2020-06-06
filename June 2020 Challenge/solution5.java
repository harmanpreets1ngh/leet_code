class Solution {

    private int total;
    private int[] weights;
    
    public Solution(int[] w) {
        total = 0;
        weights = new int[w.length];
        
        // storing range of numbers for all indices, according to their weight
        for(int i = 0; i<weights.length; i++){
            total += w[i];
            weights[i] = total;
        }
        
    }
    
    public int pickIndex() {
        int index = (int)(total * Math.random() + 1);
        return searchElement(index); // binary search
    }
    
    private int searchElement(int index){
        int left = 0;
        int right = weights.length-1;
        
        while(left < right){
            int mid = (left + right)/2;
            if(weights[mid] < index){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */