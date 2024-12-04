class Solution {
    Map<Integer, Integer> map;
    public int minSwapsCouples(int[] row) {
        int N = row.length;
        map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(row[i], i);
        }
        int swaps = 0;
        for(int i = 0; i < N; i+=2) {
            int first = row[i];
            // if first % 2 == 0 first - 1
            // if even first + 1
            int second = first ^ 1;

            if(row[i + 1] != second) {
                swaps++;
                swap(row, i + 1, map.get(second));
            }
        }
        return swaps;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        map.put(arr[i], i);
        map.put(arr[j], j);
    }
}