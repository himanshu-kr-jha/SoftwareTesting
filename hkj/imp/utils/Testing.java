package hkj.imp.utils;
import java.util.*;
import java.util.function.Function;
public class Testing{
    public static List<List<Integer>> boundaryValueAnalysis(int lower, int higher, int numberofvariable) {
        int boundaryvalue[] = {lower, lower + 1, (lower + higher) / 2, higher - 1, higher};
        Set<List<Integer>> testcasesset = new LinkedHashSet<>();
        for (int i = 0; i < numberofvariable; i++) {
            for (int j = 0; j < boundaryvalue.length; j++) {
                List<Integer> testcase = new ArrayList<>(numberofvariable);
                for (int k = 0; k < numberofvariable; k++) {
                    testcase.add((k == i) ? boundaryvalue[j] : (lower + higher) / 2);
                }
                testcasesset.add(testcase);
            }
        }

        // Add the midpoint case at the end
        List<Integer> midtestcase = new ArrayList<>(numberofvariable);
        for (int i = 0; i < numberofvariable; i++) {
            midtestcase.add((lower + higher) / 2);
        }
        testcasesset.add(midtestcase);
        List<List<Integer>> testcases = new ArrayList<>(testcasesset);
        return testcases;
    }   
    public static List<List<Integer>> robustTesting(int lower, int higher, int numberofvariable) {
        int boundaryvalue[] = {lower-1,lower, lower + 1, (lower + higher) / 2, higher - 1, higher,higher+1};
        Set<List<Integer>> testcasesset = new LinkedHashSet<>();

        for (int i = 0; i < numberofvariable; i++) {
            for (int j = 0; j < boundaryvalue.length; j++) {
                List<Integer> testcase = new ArrayList<>(numberofvariable);
                for (int k = 0; k < numberofvariable; k++) {
                    testcase.add((k == i) ? boundaryvalue[j] : (lower + higher) / 2);
                }
                testcasesset.add(testcase);
            }
        }

        // Add the midpoint case at the end
        List<Integer> midtestcase = new ArrayList<>(numberofvariable);
        for (int i = 0; i < numberofvariable; i++) {
            midtestcase.add((lower + higher) / 2);
        }
        testcasesset.add(midtestcase);
        List<List<Integer>> testcases = new ArrayList<>(testcasesset);
        return testcases;
    }

    public static List<List<Integer>> worstCaseTest(int lower, int higher, int numberOfVariables) {
        int[] boundaryValues = {lower, lower + 1, (lower + higher) / 2, higher - 1, higher};
        List<List<Integer>> testCasesSet = new ArrayList<>();

        int numValues = boundaryValues.length;
        int numCombinations = (int) Math.pow(numValues, numberOfVariables);

        // Generate all combinations iteratively
        for (int i = 0; i < numCombinations; i++) {
            List<Integer> combination = new ArrayList<>();
            int temp = i;
            
            for (int j = 0; j < numberOfVariables; j++) {
                combination.add(boundaryValues[temp % numValues]);
                temp /= numValues;
            }
            
            testCasesSet.add(combination);
        }

        return testCasesSet;
    }

    public static List<List<Integer>> robustWorstCaseTesting(int lower, int higher, int numberOfVariables) {
        int[] boundaryValues = {lower-1,lower, lower + 1, (lower + higher) / 2, higher - 1, higher,higher+1};
        List<List<Integer>> testCasesSet = new ArrayList<>();

        int numValues = boundaryValues.length;
        int numCombinations = (int) Math.pow(numValues, numberOfVariables);

        // Generate all combinations iteratively
        for (int i = 0; i < numCombinations; i++) {
            List<Integer> combination = new ArrayList<>();
            int temp = i;
            
            for (int j = 0; j < numberOfVariables; j++) {
                combination.add(boundaryValues[temp % numValues]);
                temp /= numValues;
            }
            
            testCasesSet.add(combination);
        }

        return testCasesSet;
    }

    // usage: List<List<Integer>> results = testing(testCases, tc -> maxofthree(tc));
    public static List<List<Integer>> testing(List<List<Integer>> testCases, Function<List<Integer>, Integer> function) {
        List<List<Integer>> results = new ArrayList<>();
        for (List<Integer> testCase : testCases) {
            // Apply the function to the test case and store the result
            List<Integer> result = Collections.singletonList(function.apply(testCase));
            // System.out.println(result);
            testCase.add(result.get(0));
            results.add(testCase);
        }
        return results;
    }
}
