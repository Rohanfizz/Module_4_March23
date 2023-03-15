import java.util.*;

class Solution {
	//TC: O(n);
	//SC: O(1);
	public int lsXuniqueAtleastK(String s,int x,int k){
		int sp = 0;
		int ep = 0;
		int ans = 0;

		int cnt_unique = 0;
		int cnt_atLeastK = 0;
		int[] freq = new  int[26];
		
		while(ep<s.length()){
			//introduced
			freq[s.charAt(ep)-'a']++;

			if(freq[s.charAt(ep)-'a'] == 1) cnt_unique++;
			if(freq[s.charAt(ep)-'a'] == k) cnt_atLeastK++;

			//this new character can make this an invalid window (cnt_unique>x)
			while(cnt_unique>x){
				freq[s.charAt(sp)-'a']--;

				if(freq[s.charAt(sp)-'a'] == 0) cnt_unique--;
				if(freq[s.charAt(sp)-'a'] == k-1) cnt_atLeastK--;
				sp++;
			}
			//on this line  of code, ill be having cnt_unique <= x
			if(cnt_unique == x && cnt_atLeastK == cnt_unique) ans = Math.max(ans,ep-sp+1);

			ep++;
		}
		return ans;
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		for(int i = 1;i<=26;i++) ans = Math.max(ans,lsXuniqueAtleastK(s,i,k));
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
