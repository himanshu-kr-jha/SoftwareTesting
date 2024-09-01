import hkj.imp.utils.*;
import java.util.*;
public class exp1 {
    static int lower=1;
    static int higher=100;
    static int numberOfVariables=3;
    // Method to find the maximum of three integers
    public static int maxofthree(List<Integer> testcase) {
        if (testcase.size() != 3) {
            throw new IllegalArgumentException("The list must contain exactly three elements.");
        }
        int first = testcase.get(0);
        int second = testcase.get(1);
        int third = testcase.get(2);
        if(first<lower || second<lower|| third<lower){
            return (int)-1e9;
        }
        if(first>higher || second>higher|| third>higher){
            return (int)1e9;
        }
        return Math.max(first, Math.max(second, third));
    }

    public static void main(String[] args) {

        // Example setup for the list - you need to implement or import `Testing.boundaryValueAnalysis`
        // List<List<Integer>> testCases = Testing.boundaryValueAnalysis(1, 100, 3);
        // List<List<Integer>> testCases = Testing.robustWorstCaseTesting(lower, higher, numberOfVariables);
        // List<List<Integer>> testCases = Testing.worstCaseTest(lower, higher, numberOfVariables);
        List<List<Integer>> testCases = Testing.robustTesting(lower, higher, numberOfVariables);


        // // Example setup for DataFramePrinter - you need to implement or import `DataFramePrinter.printExcelGrid`
        // DataFramePrinter.printExcelGrid(testCases);

        // Testing and storing results
        List<List<Integer>> results = Testing.testing(testCases, tc -> maxofthree(tc));

        // Printing results
        DataFramePrinter.printExcelGrid(results);
        System.out.println("Number of test cases: " + testCases.size());
    }
}
