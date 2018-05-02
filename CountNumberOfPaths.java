package Microsoft;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//Number of paths in graph 0,1

public class CountNumberOfPaths {

	
	static int numberOfPaths(int a[][]){
	    int rows = a.length;
	    int cols = a[0].length;
	    int[][] dp = new int[rows][cols];

	    dp[0][0] = a[0][0];

	    for(int i=1;i<rows;i++)
	        if(dp[i-1][0]==1 && a[i][0]==1)
	            dp[i][0] = 1;

	    for(int i=1;i<cols;i++)
	        if(dp[0][i-1]==1 && a[0][i]==1)
	            dp[0][i] = 1;

	    for(int i=1;i<rows;i++)
	        for(int j=1;j<cols;j++)
	            if(a[i][j]==1)
	                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;

	    return dp[rows-1][cols-1];
	}
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aRows = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int aColumns = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int[][] a = new int[aRows][aColumns];

        for (int aRowItr = 0; aRowItr < aRows; aRowItr++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int aColumnItr = 0; aColumnItr < aColumns; aColumnItr++) {
                int aItem = Integer.parseInt(aRowItems[aColumnItr]);
                a[aRowItr][aColumnItr] = aItem;
            }
        }

        int res = numberOfPaths(a);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
