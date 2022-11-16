public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s = 1;
        int e = n;
        while(s<=e){
            int m = s + (e-s)/2;
            if(0==guess(m)){
                return m;
            }
            else if(1>guess(m)){
                e = m-1;
            }
            else if(-1<guess(m)){
                s = m +1;
            }
        }
        return -1;
    }
}
