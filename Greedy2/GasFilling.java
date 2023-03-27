import java.util.*;

class Solution {
    
    public int filling(int pick[],int spend[],int n) {
        //Write your code here
		int totalPick = 0;
		int totalSpend = 0;
		for(int i = 0;i<n;i++){
			totalPick+=pick[i];
			totalSpend+=spend[i];
		}
		if(totalPick < totalSpend) return -1;
		int tank = 0;
		int sp = -1;

		for(int i = 0;i<n;i++){
			tank+= pick[i];//refuel
			tank-=spend[i];//going to the next gas station
			if(tank<0){
				tank = 0;
				sp = -1;
			}else{
				if(sp == -1) sp = i;
			}
		}
		return sp;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
