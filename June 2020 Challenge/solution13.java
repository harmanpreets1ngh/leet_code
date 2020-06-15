class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> res = new ArrayList();
         if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        List<List<Integer>> cache = new ArrayList();
        for(int num: nums) cache.add(new ArrayList(List.of(num)));
        
        for(int i = 0; i < nums.length; i++){
            List<Integer> newSet = new ArrayList();
            
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && newSet.size() < cache.get(j).size()){
                    newSet = cache.get(j);
                }
            }    
            cache.get(i).addAll(newSet);      
        }
        
        for(int i = 0; i < cache.size(); i++){
            if(res.size() < cache.get(i).size()){
                res = cache.get(i);
            }
        }  
        return res;
    }
}