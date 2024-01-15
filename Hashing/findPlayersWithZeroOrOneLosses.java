class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] match:matches){
            if(!map.containsKey(match[0])){
                map.put(match[0],0);
            }
            if(!map.containsKey(match[1])){
                map.put(match[1],0);
            }
            map.put(match[1],map.get(match[1])+1);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value<=1)
                res.get(value).add(key);
        }
        return res;
    }
}
