class Solution {
    public int[][] reconstructQueue(int[][] people) {

    	// sort in descending accord to the height, if height is same, ascending order of k
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        
        int n = people.length;
        List<int[]> res = new ArrayList();
        
        for(int i = 0; i < n; i++){
            res.add(people[i][1], people[i]); //greedy approach
        }
        
        return res.toArray(new int[n][2]);    
    }
}