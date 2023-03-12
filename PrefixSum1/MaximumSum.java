import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
		int n = A.length;
	    int[] pref = new int[n];

		for(int i = 0;i<ops.length;i++){
			int sp = ops[i][0];
			int ep = ops[i][1];
			pref[sp]++;
			if(ep<n-1) pref[ep+1]--;
		}
		Arrays.sort(A);
		for(int i = 1;i<pref.length;i++){
			pref[i]+=pref[i-1];
		}
		Arrays.sort(pref);
		int sum = 0;
		int md = 1000000007;
		for(int i = 0;i<n;i++){
			sum =(sum+ (A[i]*pref[i])%md)%md;
		}
		return sum%md;
		
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



