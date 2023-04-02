import java.util.*;

class Solution {
    public int maxSatisfied(int[] children, int[] ayush, int k) {
        //Write code here
        int os = 0;
		int oe = k-1;
		int maxi = 0;
		int currWin = 0; //stores the number of unsatisfied children
		for(int i = 0;i<k;i++)if(ayush[i] == 1) currWin+=children[i];
		maxi = currWin;
		int sp = 0;
		int ep = k;

		while(ep<children.length){
			//introduction to the new window
			if(ayush[ep] == 1) currWin+=children[ep];
			if(ayush[sp] == 1) currWin-=children[sp];
			
			//updating the answer
			if(currWin > maxi){
				os = sp+1;
				oe = ep;
				maxi = currWin;
			}

			//moving the window
			ep++;
			sp++;
		}
		int totalSatisfiedChildren = 0;
		for(int i = 0;i<children.length;i++){
			if(ayush[i] == 0) totalSatisfiedChildren+=children[i];
			else if(i>=os && i<=oe)totalSatisfiedChildren+=children[i];
		}
		return totalSatisfiedChildren;
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