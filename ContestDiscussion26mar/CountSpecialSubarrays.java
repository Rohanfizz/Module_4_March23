
import java.util.*;
 
class Solution
{
    //https://course.acciojob.com/idle?question=e134e218-2ac2-48b1-84f4-be50093c5fe7
   public static long countSubarrays(int[] nums, long k) {
	// Your code here
		int sp = 0;
	   int ep = 0;
	   long csum = 0;
	   long ans = 0;
	   while(ep<nums.length){
		   csum += nums[ep];

		   while(csum*(ep-sp+1) >= k){
			   csum-=nums[sp];
			   sp++;
		   }

		   ans += ep-sp+1;
		   ep++;
	   }
	   return ans;  
	}
}
 
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        k = sc.nextInt();
        System.out.println(Solution.countSubarrays(arr1,k));
    }
}