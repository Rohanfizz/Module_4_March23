import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int a[][], Pair query[]) {
        // Your code here
        List<Integer> res = new ArrayList<>();
		int n = a.length;
		int m = a[0].length;
		int[][] pref = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				int A  =  i== 0 || j == 0?0:pref[i-1][j-1];
				int B = j==0?0:pref[i][j-1];
				int C = i==0?0:pref[i-1][j];
				pref[i][j] = a[i][j] + B + C - A;
			}
		}
		for(Pair p: query){
			int D = p.row1 == 0 || p.col1==0?0:pref[p.row1-1][p.col1-1];
			int B = p.col1==0?0:pref[p.row2][p.col1-1];
			int C = p.row1==0?0:pref[p.row1-1][p.col2];
			int A = pref[p.row2][p.col2];
			int ans = A - B - C + D;
			res.add(ans);
		}
		return res;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}