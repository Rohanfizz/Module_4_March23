import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){
        //Write code here
		long maxi = Long.MIN_VALUE;
		long train = 0;

		int cs = 0;
		int ce = 0;

		int as = 0;
		int ae = 0;
		
		for(int i =0;i<n;i++){
			//if the prev train is in loss, start new, else join
			if(train < 0){
				cs = i;
				ce = i;
				train = a[i];
			}
			else{
				ce =i;
				 train+= a[i]; //join the previous train
			}

			if(maxi < train){
				maxi = train;
				as = cs;
				ae = ce;
			}
		}
		System.out.println(as+" "+ae);
		return maxi;
    }
}














