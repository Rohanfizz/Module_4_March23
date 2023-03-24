import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n){
        // Your code here
		Arrays.sort(arr,(a,b)->{
			return b.profit-a.profit;
		});

		int totalProfit = 0;
		int cnt = 0;
		
		boolean[] vis = new boolean[n+1];
		for(int i = 0;i<n;i++){
			int bestPossibleDay = arr[i].deadline;
			while(bestPossibleDay > 0 && vis[bestPossibleDay]) bestPossibleDay--;

			if(bestPossibleDay == 0) continue;
			
			totalProfit += arr[i].profit;
			cnt++;
			vis[bestPossibleDay] = true;
		}
		int[] res = new int[2];
		res[0] = cnt;
		res[1] = totalProfit;
		return res;
    }
}