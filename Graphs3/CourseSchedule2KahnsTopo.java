import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] edges) {
    //Write your code here
		int[] indegree = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i =0;i<n;i++) graph.add(new ArrayList<>());

		for(int[] edge: edges){
			int ai = edge[0];
			int bi = edge[1];
			graph.get(bi).add(ai);
			indegree[ai]++;
		}

		ArrayList<Integer> topo = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0;i<n;i++){
			if(indegree[i] == 0) q.add(i);
		}

		while(q.size()>0){
			int curr = q.remove();
			topo.add(curr); //do the course
			//reduce the indegree of neighbours
			for(int nbr: graph.get(curr)){
				indegree[nbr]--;
				if(indegree[nbr] == 0) q.add(nbr);
			}
		}
		
		if(topo.size()<n) return new int[0];//not able to find topological order
		int[] res = new int[n];
		for(int i = 0;i<n;i++) res[i] = topo.get(i);
		return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}