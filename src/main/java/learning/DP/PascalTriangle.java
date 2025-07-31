package learning.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= numRows <= 30
 */
public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0)
            return result;

        result.add(List.of(1)); //first_row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> previousRow = result.get(i-1);
            for (int j = 1; j < previousRow.size(); j++) {
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1)); //first_row
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> previousRow = result.get(i-1);
            for (int j = 1; j < previousRow.size(); j++) {
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            row.add(1);
            result.add(row);
        }

        return result.get(rowIndex);
    }

    public List<List<Integer>> generateUsingRecursion(int numRows) {
        return null;
    }
}
