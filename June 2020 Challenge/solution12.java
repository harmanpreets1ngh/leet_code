class RandomizedSet {
    
    HashMap<Integer, Integer> map;
    List<Integer> entries;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
        map = new HashMap<>();
        entries = new ArrayList<>();
        rand = new Random();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(map.containsKey(val)){
            return false;
        }
        entries.add(val);
        map.put(val,entries.size()-1);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val)){
            return false;
        }
        
        int size = entries.size();
        int index = map.get(val);
        int lastVal = entries.get(size - 1);
        
        entries.set(index, lastVal);
        map.put(lastVal, index);
        entries.remove(size - 1);
        map.remove(val);
        
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {

        return entries.get(rand.nextInt(entries.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */