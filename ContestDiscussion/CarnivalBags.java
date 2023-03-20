import java.util.*;

class Solution {
    public int BagLength(int[] bag, int k) {
        //Write your code here
		//longest subarray sum divisible by k
		//https://course.acciojob.com/idle?question=36a208f4-b1fd-4032-a130-b0c8791eb7a0
		HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(0,-1);
		int pref = 0;
		int ans = 0;
		for(int i = 0;i<bag.length;i++){
			pref +=bag[i];
			int pmk = ((pref%k)+k)%k;
			if(hm.containsKey(pmk)){
				ans = Math.max(ans,i-hm.get(pmk));
			}else{
				hm.put(pmk,i);
			}
		}
		return ans;
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bag = new int[n];
        for(int i = 0; i < n; i++)
            bag[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.BagLength(bag, k));
    }
}