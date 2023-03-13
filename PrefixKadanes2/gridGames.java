import java.util.*;

class Solution {

    public long solve(int grid[][]) {
        // Your code here
		int n = grid[0].length;
		// suffix sum array on the 0th row
		for(int i = n-2;i>=0;i--){
			grid[0][i] += grid[0][i+1];
		}
		//prefix sum array on the 1th row
		for(int i = 1;i<n;i++){
			grid[1][i] += grid[1][i-1];
		}
		//start exploring all possible paths
		int overallAns = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++){
			//i -> if robot1 switches row on the ith col
			//options for robot 2
			int firstOption = i+1 == n ? 0 : grid[0][i+1];
			int secondOption = i-1 < 0 ? 0 : grid[1][i-1];
			int robot2sChoice = Math.max(firstOption,secondOption);
			overallAns = Math.min(overallAns,robot2sChoice);
		}
		return overallAns;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}