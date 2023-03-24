import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int capacity, Item arr[], int n) {
		// Write your code here
		Arrays.sort(arr,(a,b)->{
			double pwa = 1.0*a.value/a.weight;
			double pwb = 1.0*b.value/b.weight;
			if(pwa > pwb){
				return -1;
			}else return 1;
		});

		double totalProfit = 0.0;

		for(int i = 0;i<n;i++){
			if(capacity > arr[i].weight){
				capacity-=arr[i].weight;
				totalProfit += arr[i].value;
			}else{
				double costOf1Unit = 1.0*arr[i].value/arr[i].weight;
				double myProfit = costOf1Unit * capacity;
				totalProfit += myProfit;
				capacity = 0;
				break;
			}
		}
		return totalProfit;
    }
}
