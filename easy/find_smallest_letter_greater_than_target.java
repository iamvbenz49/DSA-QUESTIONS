public class xx {
    public static void main(String[] args) {
        char[] ch = {'x','x','y','y'};
        char c = 'z';
        System.out.println(nextGreatestLetter(ch,c));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        if((int)target>=(int)letters[letters.length-1]){
            return target;
        }
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            System.out.println((int)letters[mid]+ ""+(int)target);
            if((int)letters[mid]>(int)target){
                end = mid -1;
            }
            else if((int)letters[mid]<(int)target){
                start = mid + 1;
            }
            else if((int)letters[mid] == (int)target){
                start = mid+1;
            }
        }
        return letters[start];
    }
}
