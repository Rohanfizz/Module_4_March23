import java.util.*;

class Solution {

	public class Pair{
		int node;
		int color;
		Pair(int node,int color){
			this.node = node;
			this.color = color;
		}
	}
	
    public int possibleBipartition(int n, int[][] edges) {
        // Write your code here

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i= 1;i<=n+1;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(int[] e: edges){
			int u = e[0];
			int v = e[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		int[] visited = new int[n+1];//1->red, -1->blue,0->colorless
		Queue<Pair> q = new LinkedList<>();

		for(int i =1;i<=n;i++){
			if(visited[i] != 0) continue;
			q.add(new Pair(i,-1));
	
			while(q.size()>0){
				Pair curr = q.remove();
				if(visited[curr.node] != 0) continue;
				
				visited[curr.node] = curr.color;//color the node
				int oppColor = curr.color == -1 ? 1 : -1 ;
	
				for(int nbr: graph.get(curr.node)){
					//adj nbr is colorless
					if(visited[nbr] == 0){
						q.add(new Pair(nbr,oppColor));
					}else if(visited[nbr] == curr.color) return 0;//adjecent vertices are having same color
					else continue;//adj vertices having different colors
				}
			}
		}
		
		
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}