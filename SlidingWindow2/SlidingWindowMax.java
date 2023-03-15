import java.util.*;

class Solution{
	static void addToDq(LinkedList<Integer> dq,int idx,int[] arr){
		while(dq.size()>0 && arr[dq.peekLast()] < arr[idx]) dq.removeLast();
		dq.addLast(idx);
	}
	
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		int[] res = new int[N-K+1];
		LinkedList<Integer> dq = new LinkedList<>();

		

		//add first k elements for the zeroeth window
		for(int i = 0;i<K;i++){
			addToDq(dq,i,arr);
		}

		res[0] = arr[dq.peek()];

		int sp = 1;
		int ep = K;
		int winNumber = 1;

		while(ep<N){

			//introduce new person
			addToDq(dq,ep,arr);

			// keep removing elements from the front of the dq until dq.peek()<sp(the element is not present int the window)
			while(dq.peek() < sp) dq.remove();

			//the actual champ is present in front of the dq
			res[winNumber]=arr[dq.peek()];

			sp++;
			ep++;
			winNumber++;
		}
		return res;
		
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
