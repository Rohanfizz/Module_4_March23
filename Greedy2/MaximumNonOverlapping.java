import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		//CORE: SORT ON SP, SELECT THE INTERVAL HAVING A SMALLER ENDING POINT
		int cep = -1;
		int csp = -1;
		int cnt = 0;

		Collections.sort(A,(a,b)->{
			return a.get(0) - b.get(0);
		});

		for(int i = 0;i<A.size();i++){
			int istart = A.get(i).get(0);
			int iend = A.get(i).get(1);

			//check if the intervals merge?
			if(cep >= istart){
				//make a choice
				// either select the incoming interval
				//or do nothing and move forward with the current interval
				if(iend<cep){
					csp = istart;
					cep = iend;
				}
			}else{
				//we are not getting merged
				//forget about the previous interval
				csp = istart;
				cep = iend;
				//increment the number of intervals im having
				cnt++;
			}
		}
		return cnt;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
