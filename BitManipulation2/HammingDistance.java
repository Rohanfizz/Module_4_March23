import java.util.*;

class Accio{
	 static int countNumberOfSetBits(int n) {
        // write code here
		int cnt = 0;
		while(n > 0){
			cnt++;
			n = (n&(n-1));
		}
		return cnt;
    }
    static int HammingDistance(int a,int b){
        //write code here
		int xorab= a^b;
		return countNumberOfSetBits(xorab);
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.HammingDistance(a,b);
        System.out.println(ans);
    }
}
