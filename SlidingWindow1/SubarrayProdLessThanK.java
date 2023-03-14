import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
		int i = 0;
		int j = 0;
		int productOfCurrWin = 1;
		int count = 0;
		while(i<nums.length){
			//introduction
			productOfCurrWin*=nums[i];

			//shrink until window becomes invalid
			while(productOfCurrWin >= k){
				productOfCurrWin /= nums[j];
				j++;
			}

			//window will be always valid
			count += (i-j+1);//window will contribute (window.length) number of subarrays
			i++;
		}
		return count;
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
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}