
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
//your code
		int[] pref = new  int[1005];

		for(int[] trip: trips){
			int numPeople = trip[0];
			int sp = trip[1];
			int ep= trip[2];

			pref[sp] += numPeople;
			pref[ep] -= numPeople;
		}
		
		for(int i = 1;i<1005;i++){
			pref[i] += pref[i-1];
		}

		// check if trips are possible
		for(int i = 0;i<1005;i++){
			if(pref[i] > capacity) return false;
		}
		return true;
			
	}
}
