import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
	public static class Pair{
		int node;
		int wt;
		Pair(int node, int wt){
			this.node = node;
			this.wt = wt;
		}
	}
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int S){
     // Write your code here
       boolean[] vis = new boolean[V];
	int[] cost = new int[V];
	  Arrays.fill(cost,-1);
	  PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
		  return a.wt-b.wt;
	  });
	  pq.add(new Pair(S,0));

	  while(pq.size()>0){
		  Pair curr = pq.remove();
		  int node = curr.node;
		  int wt = curr.wt;
		  if(vis[node]) continue;
		  vis[node] = true;
		  cost[node] = wt;

		  for(ArrayList<Integer> e: graph.get(node)){
			int nbr = e.get(0);
			  int nwt = e.get(1);
			  if(!vis[nbr]) pq.add(new Pair(nbr,wt+nwt));
		  }
	  }
	  return cost;
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}
