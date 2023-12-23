//TC - O(4^(M*N)^2) SC - O(M*N)

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        dfs(m,"",res,0,0);
        return res;
    }
    public static void dfs(int[][] maze,String s,ArrayList<String> res,int r,int c){
        if(r<0||c<0||r>=maze.length||c>=maze[0].length||maze[r][c]==0){
            return;
        }
        if(r==maze.length-1&&c==maze.length-1){
            res.add(new String(s));
            return;
        }
        maze[r][c] = 0;
        dfs(maze,new String(s+'U'),res,r-1,c);
        dfs(maze,new String(s+'D'),res,r+1,c);
        dfs(maze,new String(s+'L'),res,r,c-1);
        dfs(maze,new String(s+'R'),res,r,c+1);
        maze[r][c] = 1;
    }
}
