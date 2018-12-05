package Dec;

import java.util.HashSet;
import java.util.Set;

public class MagicSquare {

  static int[][] A = {{1, 2}, {3, 4}};

  static int[][] B = {{5, 1, 3}, {5, 1, 3}, {4, 0, 2}};

  public static void main(String args[]) {
    MagicSquare ms = new MagicSquare();
    System.out.println(ms.magicSquare(A));
    System.out.println(ms.magicSquare(B));
  }

  private boolean magicSquare(int[][] matrix) {
    int len = matrix.length;
    int target = 0;
    for (int i = 0; i < len; i++) {
      target += matrix[i][i];
    }
    return visit(matrix, 0, target, 0, new HashSet<Integer>());
  }

  private boolean visit(int[][] matrix, int sum, int target, int currentRow,
      Set<Integer> visitedColumns) {
    int len = matrix.length;
    if (currentRow >= len) {
      return sum == target;
    }
    for (int i = 0; i < len; i++) {
      int value = matrix[currentRow][i];
      if (visitedColumns.contains(i)) {
        continue;
      }
      visitedColumns.add(i);
      if (!visit(matrix, sum + value, target, currentRow + 1, visitedColumns)) {
        return false;
      }
      visitedColumns.remove(i);
    }
    return true;
  }

}
