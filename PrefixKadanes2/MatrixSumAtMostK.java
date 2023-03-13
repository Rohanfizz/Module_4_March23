import java.util.*;

class Solution {

	public int maxPossibleSubarrayHavingSumAtMostK(int[] arr,int k){
		int pref = 0;
		TreeSet<Integer> ts= new TreeSet<>();
		ts.add(0);
		int result = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++){
			pref+=arr[i];
			int idealValue = pref - k;
			Integer idealValueInTs = ts.ceiling(idealValue);
			if(idealValueInTs!=null){//we were able to find a value in ts
				int sumOfSubarrayBetweenUs = pref - idealValueInTs;
				result = Math.max(result,sumOfSubarrayBetweenUs);
			}
			ts.add(pref);
		}
		return result;
	}
	
    public int maxSumSubmatrix(int[][] arr, int k) {
        //Write code here
		int result = Integer.MIN_VALUE;
		for(int left = 0;left<arr[0].length;left++){
			int[] rows = new int[arr.length];
			for(int right = left;right<arr[0].length;right++){

				for(int i = 0;i<arr.length;i++) rows[i]+=arr[i][right];
				int closentSumToKUsingThisLR = maxPossibleSubarrayHavingSumAtMostK(rows,k);
				result = Math.max(result,closentSumToKUsingThisLR);
			}
		}
		return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}