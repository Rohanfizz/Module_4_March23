import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
        // write code here
		//lets say two unique numbers are a and b respectively
		int xorOfAll = 0;
		for(int x: nums) xorOfAll^=x;

		//xorOfAll is the xor of a^b
		//now i need to find any set bit, which will indicate that the ith bit is different in a and b
		//in this code we will try to find the rmsb
		//we are bringing the rmsb to zero so as to match and find its index
		int k = 0;
		while((xorOfAll & 1 )==0){
			k++;
			xorOfAll>>=1;
		}

		//now k is storing the index of the rmsb
		//divide people into two sets, one who are having kth bit set, and others which dont
		int kthBitSet = 0;
		int kthBitUnset = 0;
		for(int x: nums){
			if( (x & (1<<k)) > 0 ){
				kthBitSet ^= x;
			}else kthBitUnset ^= x;
		}

		int[] res = new int[2];
		res[0] = kthBitUnset;
		res[1] = kthBitSet;
		Arrays.sort(res);
		return res;
		
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}