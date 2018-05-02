package Microsoft;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

//numberOfPairs that equals the given sum
public class NumberOfPairsThatEqualsSum {

	/*
	 * Complete the numberOfPairs that equals the given sum function below.
	 */
	static int numberOfPairs(int[] a, long k) {
		int count = 0;
		Arrays.sort(a); // Sort array elements
		System.out.println(Arrays.toString(a));
		int l = 0;
		int r = a.length-1;
		HashMap<Integer, Integer> countMap = new HashMap();
		while(r > 0 && l<a.length)
		{
			if(a[r] + a[l] == k && r!=l)
			{

				if(countMap.containsKey(a[r]) || countMap.containsKey(a[l])) {
					if(((countMap.containsKey(a[r]))&&(countMap.get(a[r]) ==a[l])) || ((countMap.containsKey(a[l]))&&(countMap.get(a[l]) ==a[r])) ) {
						l++;
						r--;
						continue;
					}
				}
				count++;

				System.out.println(a[r]+" "+a[l]);
				countMap.put(a[l], a[r]);
				l++;
				r--;
			}
			else if(a[r] + a[l] > k)
				r--;
			else // arr[r] - arr[l] < sum
				l++;
		} 
		return count;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		        int aCount = scanner.nextInt();
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
		
		        int[] a = new int[aCount];
		
		        for (int aItr = 0; aItr < aCount; aItr++) {
		            int aItem = scanner.nextInt();
		            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
		            a[aItr] = aItem;
		        }
		
		        long k = scanner.nextLong();
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		//int a[] = {6,12,3,9,3,5,1};
		//long k = 12;

		int res = numberOfPairs(a, k);

		System.out.println(res);
		        bufferedWriter.write(String.valueOf(res));
		        bufferedWriter.newLine();
		
		        bufferedWriter.close();
		
		        scanner.close();
	}
}
