// TC - O(N) +  O(N log N) + O(N) + O(N log N) = 2 * (O(N) + O(N log N)) = o(N log N)
// SC - O(N) + O(log N) + O(log N) = O(N) + 2*(O(log N)) = O(N)

class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // SC = O(N)
        int[][] meetings = new int[N][3];
        // TC - O(N)
        for(int i=0;i<N;i++){
            meetings[i][0] = S[i];
            meetings[i][1] = F[i];
            meetings[i][2] = i+1;
        }
        // TC - O(N log N) SC - O(log N)
        Arrays.sort(meetings, Comparator.comparingInt(a->a[1]));
        ArrayList<Integer> list = new ArrayList<>();
        int end = -1;
        // TC - O(N)
        for(int[] meeting:meetings){
            if(end<meeting[0]){
                list.add(meeting[2]);
                end = meeting[1];
            }
        }
        // TC - O(N log N) SC - O(log N)
        Collections.sort(list);
        return list;
    }
}
