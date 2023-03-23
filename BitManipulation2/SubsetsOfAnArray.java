import java.util.*;
class Main{
	public static boolean jthBitIsSet(int n,int j){
		int mask = 1<<j;
		if((n&mask) > 0) return true;
		return false;
	}
    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
        //Write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int power = (int)Math.pow(2,n);
		for(int i = 0;i<power;i++){
			ArrayList<Integer> curr = new ArrayList<>();
			int j = 0;
			while(j<n){
				if(jthBitIsSet(i,j)) curr.add(arr[j]);
				j++;
			}
			res.add(curr);
		}
		return res;
		
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int []A=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }
            ArrayList <ArrayList<Integer>> res = subsets(A,n);
            Collections.sort(res, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
            for (int i = 0; i < res.size (); i++)
            {
                for (int j = 0; j < res.get(i).size (); j++)
                {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();

            }
        }
    }
}