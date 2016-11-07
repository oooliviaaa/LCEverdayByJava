package FirstAttempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaolin on 11/6/16.
 */
public class PacificAtlanticWaterFlow {


    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length; int n = matrix[0].length;
        int[][] states = new int[m][n];
        Arrays.fill(states, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (states[i][j] != -1) continue;
                checkFlow(matrix, states, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (states[i][j] == 3) res.add(new int[]{i, j});
            }
        }

        return res;
    }

    private void checkFlow(int[][] matrix, int[][] states, int i, int j) {
        int l = 0, r = 0, u = 0, d = 0;

        //if (j == matrix[0].size() || i == matrix.size()) return 1;
        //if (j == -1 || i == -1) return 2;

        if (states[i][j] != -1) return;



        if (j <= 0)l = 2;
        else if (matrix[i][j - 1] <= matrix[i][j]) {
            checkFlow(matrix, states, i, j - 1);
            l = states[i][j - 1];
        }



        if (j + 1 >= matrix[0].length)r = 1;
        else if (matrix[i][j + 1] <= matrix[i][j]) {
            checkFlow(matrix, states, i, j + 1);
            r = states[i][j + 1];
        }



        if (i <= 0)u = 2;
        else if (matrix[i - 1][j] <= matrix[i][j]) {
            checkFlow(matrix, states, i - 1, j);
            u = states[i - 1][j];
        }

        if (i + 1 >= matrix.length)d = 1;
        else if (matrix[i + 1][j] <= matrix[i][j]) {
            checkFlow(matrix, states, i + 1, j);
            d = states[i + 1][j];
        }

        states[i][j] = l | r | u | d;
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pa = new PacificAtlanticWaterFlow();
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> res = pa.pacificAtlantic(matrix);
        for (int[] r : res) {
            for (int i = 0; i < r.length; i++) {
                System.out.print(r[i] + " ");
            }
            System.out.println();
        }
    }
}
