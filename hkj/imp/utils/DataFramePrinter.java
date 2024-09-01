package hkj.imp.utils;
import java.util.*;

public class DataFramePrinter {
    public static void printExcelGrid(List<List<Integer>> data) {
        if (data == null || data.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }

        int numRows = data.size();
        int numCols = data.get(0).size();

        // Determine column widths
        int[] colWidths = new int[numCols];
        for (int j = 0; j < numCols; j++) {
            int maxWidth = 0;
            for (int i = 0; i < numRows; i++) {
                String cell = formatCell(data.get(i).get(j));

                if (cell.length() > maxWidth) {
                    maxWidth = cell.length();
                }
            }
            colWidths[j] = maxWidth;
        }

        // Print top border
        printBorder(numCols, colWidths);

        // Print data rows
        for (List<Integer> row : data) {
            printRow(row, colWidths);
            printBorder(numCols, colWidths);
        }
    }

    private static void printBorder(int numCols, int[] colWidths) {
        System.out.print("+");
        for (int j = 0; j < numCols; j++) {
            System.out.print("-".repeat(colWidths[j] + 2) + "+");
        }
        System.out.println();
    }

    private static void printRow(List<Integer> row, int[] colWidths) {
        System.out.print("|");
        for (int j = 0; j < row.size(); j++) {
            String cell;
            if(row.get(j)==(int)-1e9 ||row.get(j)==(int)1e9){
                cell="INVALID";
            }else{
                cell = formatCell(row.get(j));    
            }
            System.out.print(" " + String.format("%-" + colWidths[j] + "s", cell) + " |");
        }
        System.out.println();
    }

    private static String formatCell(Object obj) {
        if (obj == null) {
            return "";
        }
        // Convert object to string, handle formatting for specific types if needed
        return obj.toString();
    }
}

