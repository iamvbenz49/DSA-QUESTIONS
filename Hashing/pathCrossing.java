class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int x = 0, y = 0;
        for(int i=0;i<path.length();i++){
            char move = path.charAt(i);
            if(move=='N'){
                y++;
            }else if(move=='E'){
                x++;
            }else if(move=='W'){
                x--;
            }else{
                y--;
            }
            String s = Integer.toString(x) + "," + Integer.toString(y);
            System.out.println(s);
            if(!set.add(s))
                return true; 
        }
        return false;
    }
}
