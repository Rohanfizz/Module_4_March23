import java.util.*;

class Solution {
    public int MaxSum(int[] a, int n) {
        // Write your code here
		int maxSumSubarray = Integer.MIN_VALUE;
		int minSumSubarray = Integer.MAX_VALUE;
		int total = 0;

		int csummax = 0;
		int csummin = 0;

		for(int i = 0;i<n;i++){
			//add a[i] to total
			total += a[i];

			//tasks for calculating maxSumSubarray
			if(csummax < 0) csummax = a[i];
			else csummax+=a[i];
			maxSumSubarray = Math.max(maxSumSubarray,csummax);

			//tasks for calculating minSumSubarray
			if(csummin>0) csummin = a[i];
			else csummin += a[i];
			minSumSubarray = Math.min(minSumSubarray,csummin);
		}

		//if all elements are +ve
		if(total == maxSumSubarray) return maxSumSubarray;

		//if all elements are -ve
		if(total == minSumSubarray) return maxSumSubarray;

		//normal condition vs wrap around
		int normalCase = maxSumSubarray;
		int wrapAround = total - minSumSubarray;
		return Math.max(normalCase,wrapAround);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}