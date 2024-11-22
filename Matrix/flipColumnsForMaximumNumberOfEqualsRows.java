class flipColumnsForMaximumNumberOfEqualsRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int ROWS = matrix.length, COLS = matrix[0].length;
        int res = 0;
        for(int i = 0; i < ROWS; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < COLS; j++) {
                if(matrix[i][j] == matrix[i][0]) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s,0) + 1);
            res = Math.max(res, map.get(s));
        }
        return res;
    }

}