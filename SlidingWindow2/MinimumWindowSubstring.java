import java.io.*;
import java.util.*;

class Solution {

	public boolean isValid(int[] freqw,int[] freqt){
		for(int i =0;i<123;i++){
			if(freqw[i] < freqt[i]) return false;
		}
		return true;
	}
	
    public String minWindow(String s, String t) {
		// write code here
		int[] freqw = new int[123];
		int[] freqt = new int[123];
		for(int  i = 0;i<t.length();i++) freqt[t.charAt(i)]++;//creating the freq array for string t

		int sp = 0;
		int ep = 0;
		int minlen = Integer.MAX_VALUE;

		int asp = 0;
		int aep = -1;

		while(ep<s.length()){
			//introducing new member to window
			freqw[s.charAt(ep)]++;

			while(isValid(freqw,freqt)){
				if(minlen>ep-sp+1){
					minlen = ep-sp+1;
					asp= sp;
					aep=ep;
				}
				
				//forgetting about the char which is leaving the window
				freqw[s.charAt(sp)]--;
				sp++;
			}
			//window is definately invalid
			ep++;
		}
		return s.substring(asp,aep+1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}