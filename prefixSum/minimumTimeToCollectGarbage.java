class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int prev = 0;
        int G = 0;
        int M = 0;
        int P = 0;
        int count = 0;
        for(int i=0;i<garbage.length;i++){
            for(int j=0;j<garbage[i].length();j++){
                char c = garbage[i].charAt(j);
                if(c=='G')G = i;
                else if(c=='P')P = i;
                else if(c=='M')M = i;
                count++;
            }
        }
        System.out.println(G+" "+M+" "+P+" "+count);
        for(int i=0;i<travel.length;i++){
            prev+=travel[i];
            if(G!=0 && G-1==i)count+=prev;
            if(M!=0 && M-1==i)count+=prev;
            if(P!=0 && P-1==i)count+=prev;
        }
        System.out.print(G+" "+M+" "+P+" "+count);
        return count;
    }
}
