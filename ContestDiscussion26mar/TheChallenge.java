import java.io.*;
import java.util.*;

class Solution {
    //https://course.acciojob.com/idle?question=01b9bc4b-4bbc-42ef-bb88-b449e8d9bd1f
  int theChallenge(int arr[], int n, int sum){
        // Your code here
		  HashMap<Integer,Integer> hm = new HashMap<>();
		  hm.put(0,-1);
		  int psum = 0;
		  for(int i = 0;i<n;i++){
			  psum += arr[i];
			  if(hm.containsKey(psum-sum)) return 1;
			  else hm.put(psum,i);
		  }
		  return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        int sum;
        sum = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.theChallenge(arr1, n, sum);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}