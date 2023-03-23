import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean ithBitIsSet(long n,long i){
		// if(n == -1 && i == 31) System.out.println((n & (1L<<i)) > 0);
		// Use Long If you need to check for ith Bit is set or not in -ve numbers as well
		return (n & (1L<<i)) > 0;
	}
    public static int singleNumber(int[] nums) {
    // Your code here
		int n = nums.length;
		
		int[] sumOfBits = new int[32];

		for(int i = 0;i<32;i++){
			for(int x: nums){
				if(ithBitIsSet(x,i)) sumOfBits[i]++;
			}
		}
		int ans = 0;
		int powOf2 = 1;

		for(int i = 31;i>=0;i--){
			System.out.print(sumOfBits[i]);
			
		}
		System.out.println();
		
		for(int i = 0;i<32;i++){
			if(sumOfBits[i]%3!= 0) ans += powOf2;
			powOf2<<=1;
		}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}