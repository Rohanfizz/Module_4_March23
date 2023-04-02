import java.util.*;

class Solution {

	public int query(int[] arr,int sp,int ep){
		if(sp == 0) return arr[ep];
		return arr[ep]-arr[sp-1];
	}
    public int maxSatisfied(int[] children, int[] ayush, int k) {
        //Write code here
		int ans = 0;
		int n = children.length;
		int[] pref = new int[n];
		
        for(int i= 0;i<children.length;i++){
			if(ayush[i] == 0) ans+=children[i];
			if(ayush[i] == 1) pref[i] = children[i];
		}
		for(int i = 1;i<n;i++) pref[i]+=pref[i-1];
		int maxi = 0;
		for(int i = 0;i<n;i++){
			if(ayush[i] == 1){
				int q = query(pref,i,Math.min(i+k-1,n-1));
				maxi = Math.max(maxi,q);
			}
		}
		return maxi+ans;
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int children[]=new int[n];
        int ayush[]=new int[n];
        for(int i=0;i<n;i++)children[i]=sc.nextInt();
        for(int i=0;i<n;i++)ayush[i]=sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.maxSatisfied(children,ayush,k);
        System.out.println(ans);
        sc.close();
    }
}