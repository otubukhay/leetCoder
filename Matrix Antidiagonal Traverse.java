 static List<List<Integer>> printAll(int[][] matrix) {
        List<List<Integer>> result = new ArrayList();
        if (matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int row = 0;
            int col = i;
            List<Integer> temp = new ArrayList();
            while (row < m && col >= 0) {
                temp.add(matrix[row][col]);
                col--;
                row++;
            }

            result.add(temp);
        }

        for (int i = 1; i < m; i++) {
            int row = i;
            int col = n - 1;
            List<Integer> temp = new ArrayList();
            while (row < m && col >= 0) {
                temp.add(matrix[row][col]);
                col--;
                row++;
            }

            result.add(temp);
        }

        return result;
    }