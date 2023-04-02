import java.util.*;

class Solution {

    public int policeAndThief(int[][] suspect, int N) {
        // write code here
		int[] in = new int[N+1];
		int[] out = new int[N+1];
		for(int[] e: suspect){
			int u = e[0];
			int v = e[1];
			in[v]++;
			out[u]++;
		}
		
		for(int i = 1;i<=N;i++) if(in[i] == N-1 && out[i] == 0) return i;
		return -1;
    }
}

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int suspect[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            suspect[i][0] = u;
            suspect[i][1] = v;
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.policeAndThief(suspect, n));
    }
}