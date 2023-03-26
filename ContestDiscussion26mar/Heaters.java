import java.util.*;

class Solution {

	public int[] binarySearch(int[] arr,int val){
		int ceil =10000000;
		int floor = -10000000;
		int l = 0;
		int r = arr.length-1;
		int[] res = new int[2];
		while(l<=r){
			int mid = (l+r)/2;
			if(arr[mid] == val){
				res[0] = val;
				res[1] = val;
				return res;
			}else if(arr[mid] < val){
				floor = arr[mid];
				l = mid+1;
			}else{
				ceil = arr[mid];
				r = mid-1;
			}
		}
		res[0] = floor;
		res[1] = ceil;
		return res;
	}
	//https://course.acciojob.com/idle?question=6503ca97-4499-45ed-a76d-af7837890720
    public int findRadius(int[] houses, int[] heaters) {
        //Write code here
		int radius = 0;
		for(int house : houses){
			int[] ceilFloor = binarySearch(heaters,house);
			int ceil = ceilFloor[1];
			int floor = ceilFloor[0];

			int nearestDistance = Math.min(house-floor,ceil-house);
			radius = Math.max(radius,nearestDistance);
		}
		return radius;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.findRadius(arr, arr2);
        System.out.println(res);
        sc.close();
    }
}