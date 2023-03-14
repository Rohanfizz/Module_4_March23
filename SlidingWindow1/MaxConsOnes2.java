import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here
		int i = 0;
		int j = 0;
		int ans = 0;
		int numZeroesInWindow = 0;
		while(i<n){
			//introduce new person to window
			if(arr[i] == 0) numZeroesInWindow++;

			//shrink until window becomes valid
			while(numZeroesInWindow > k){
				//who is the person leaving?
				if(arr[j] == 0) numZeroesInWindow--;
				
				j++;
			}
			//on this line of code, window will be valid always
			ans = Math.max(ans , i-j+1);
			i++;
		}
		return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}