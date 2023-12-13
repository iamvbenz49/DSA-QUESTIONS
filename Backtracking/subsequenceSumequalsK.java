import java.util.ArrayList;

public class subSequenceequalsK {
     public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        ArrayList<ArrayList<Integer>> res = getAllSubsequenceEqualsK(arr,8,new ArrayList<>(),0,0);
        System.out.println(res);
    }
    public static ArrayList<ArrayList<Integer>> getAllSubsequenceEqualsK(int[] arr,int k,ArrayList<Integer> subList, int index,int sum){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        if(sum==k){
            mainList.add(subList);
            return mainList;
        }
        if(index==arr.length){
            return mainList;
        }
        subList.add(arr[index]);
        ArrayList<ArrayList<Integer>> list1 = getAllSubsequenceEqualsK(arr, k,new ArrayList<>(subList), index+1,sum+arr[index]);
        if(!list1.isEmpty())
            mainList.addAll(list1);
        subList.remove(subList.size()-1);
        ArrayList<ArrayList<Integer>> list2 = getAllSubsequenceEqualsK(arr, k,new ArrayList<>(subList), index+1,sum);
        if(!list2.isEmpty())
            mainList.addAll(list2);
        return mainList;
    }
}
