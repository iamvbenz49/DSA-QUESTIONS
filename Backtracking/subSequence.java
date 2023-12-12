import java.util.ArrayList;
// TC - O(2^N)
// SC - O(2^N) 

public class subSequence{
    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        ArrayList<ArrayList<Integer>> res = getAllSubsequence(arr,new ArrayList<>(),0);
        System.out.println(res);
    }
    public static ArrayList<ArrayList<Integer>> getAllSubsequence(int[] arr,ArrayList<Integer> subList, int index){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        if(index==arr.length){
            mainList.add(new ArrayList<>(subList));
            return mainList;
        }
        subList.add(arr[index]);
        mainList.addAll(getAllSubsequence(arr, new ArrayList<>(subList), index+1));
        subList.remove(subList.size()-1);
        mainList.addAll(getAllSubsequence(arr, new ArrayList<>(subList), index+1));
        return mainList;
    }
}
