import edu.princeton.cs.algs4.In;

public class Day07 {




    public static long part1I(In in) {
        long total = 0;  // Variable to accumulate the sum of valid test values

        while (in.hasNextLine()) {
            String lineIn = in.readLine().trim();
            String[] parts = lineIn.split(":");
            long testValue = Long.parseLong(parts[0].trim());
            String[] numbers = parts[1].trim().split(" ");

            String[] operators = {"+", "*"};
            long validTestValue = 0;


            if (isValidEquation(testValue, numbers, operators)) {
                validTestValue = testValue;  // If valid, add to total
            }

            total += validTestValue;
        }

        return total;
    }


    private static boolean isValidEquation(long testValue, String[] numbers, String[] operators) {

        int operatorCount = numbers.length - 1;
        String[] operatorCombinations = generateOperatorCombinations(operatorCount, operators);

        for (String operatorCombination : operatorCombinations) {
            long result = evaluate(numbers, operatorCombination);
            if (result == testValue) {
                return true;
            }
        }

        return false;
    }

    private static String[] generateOperatorCombinations(int count, String[] operators) {
        int combinations = (int) Math.pow(operators.length, count);
        String[] operatorCombinations = new String[combinations];

        for (int i = 0; i < combinations; i++) {
            StringBuilder sb = new StringBuilder();
            int temp = i;
            for (int j = 0; j < count; j++) {
                sb.append(operators[temp % operators.length]);
                temp /= operators.length;
            }
            operatorCombinations[i] = sb.toString();
        }

        return operatorCombinations;
    }

    private static long evaluate(String[] numbers, String operatorCombination) {
        long result = Long.parseLong(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            char operator = operatorCombination.charAt(i - 1);
            long num = Long.parseLong(numbers[i]);
            if (operator == '+') {
                result += num;
            } else if (operator == '*') {
                result *= num;
            }
        }

        return result;
    }


    public static long part1R(In in) {
        while (in.hasNextLine()) {
            String lineIn = in.readLine();
            // TODO: the magic happens here...recursively
        }
        return 0;
    }
}

