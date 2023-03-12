import java.util.*;

class Solution {

		public int rangeSum(int[] pref,int sp,int ep){
			if(sp == 0) return pref[ep];
			return pref[ep] - pref[sp-1];
		}
	
        public int[] sumQuery(int[] arr, int[][] queries) {
            // Your code here.
			int n = arr.length;
			int q = queries.length;
			int[] res = new int[q];

			//created prefSum Array
			for(int i = 1;i<n;i++){
				arr[i] += arr[i-1];
			}

			//answer every query
			for(int i = 0;i<q;i++){
				int sp = queries[i][0];
				int ep = queries[i][1];
				res[i] = rangeSum(arr,sp,ep);
			}
			return res;
        }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}