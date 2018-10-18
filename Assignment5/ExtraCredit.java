package INFO5100Assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraCredit {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int row = 0, col = 0, dir = 0;
        int[] dir1 = new int[]{0, 1, 0, -1};
        int[] dir2 = new int[]{1, 0, -1, 0};

        for (int i = 0; i < m * n; i++){
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int r = row + dir1[dir];
            int c = col + dir2[dir];
            if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]){
                row = r;
                col = c;
            } else{
                dir = (dir + 1) % 4;
                row += dir1[dir];
                col += dir2[dir];

            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
    }
}
