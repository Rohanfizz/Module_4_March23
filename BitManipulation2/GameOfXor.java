import java.util.*;

class Solution {

  static int xorSubarrayXors(int arr[], int n) {
    //Write code here
    int res = 0;
    for (int i = 0; i < n; i++) {
      int contribution = (i + 1) * (n - i); //the number of subarrays this number comes in
      if ((contribution & 1) == 1) { // checking if a number is odd, you can write n%2 == 1 here as well
        res ^= arr[i];
      }
    }
    return res;
  }
}

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }
    int ans = Solution.xorSubarrayXors(arr, n);
    System.out.print(ans);
    input.close();
  }
}
