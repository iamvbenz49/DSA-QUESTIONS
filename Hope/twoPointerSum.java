package Hope;

public class twoPointerSum {
    public static void main(String[] args) {
        int[] arr = {10, 15, 5, 25, 10, 5, 5, 10, 10};
        int sum = 0, left = 0, right = 0, count = 0;
        while(right < arr.length) {
            if(sum < 30) {
                sum += arr[right++];
            } else {
                sum -= arr[left++];
            }
            if(sum == 30) {
                count++;
            }
        }
        System.out.println(count);
    }
}
