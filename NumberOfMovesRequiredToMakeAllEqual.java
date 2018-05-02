package Microsoft;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//Number of moves required to make all values equal
public class NumberOfMovesRequiredToMakeAllEqual {
	/*
	 * Complete the countMoves function below.
	 */
	static long countMoves(int[] numbers) {
		/*
		 * Write your code here.
		 */

		long moves = 0; 
		int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            min = Math.min(min, numbers[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            moves += numbers[i] - min;
        }
        return moves;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int numbersCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int[] numbers = new int[numbersCount];

		for (int numbersItr = 0; numbersItr < numbersCount; numbersItr++) {
			int numbersItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
			numbers[numbersItr] = numbersItem;
		}

		//int[] numbers = {5,6,8,8,5};
		long res = countMoves(numbers);
		System.out.println(res);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}