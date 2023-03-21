import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++){
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution {
		public class Pair{
			int node;
			int cost;
			Pair(int node,int cost){
				this.node = node;
				this.cost = cost;
			}
		}

		public class Edge{
			int nbr;
			int wt;
			Edge(int nbr,int wt){
				this.nbr = nbr;
				this.wt = wt;
			}
		}
       public int networkDelayTime(int[][] times, int N, int K) {
        //Write code here
		   ArrayList<Edge>[] graph  = new ArrayList[N+1];

		   for(int i = 0;i<=N;i++) graph[i] = new ArrayList<Edge>();

		   for(int[] edge: times){
			   int u = edge[0];
			   int v = edge[1];
			   int w = edge[2];
			   graph[u].add(new Edge(v,w));
		   }

		   //dijkstra 
		   int lastFound = 0;
		   boolean[] vis = new boolean[N+1];
		   PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			   return a.cost-b.cost;
		   });

		   pq.add(new Pair(K,0));

		   while(pq.size()>0){
				Pair curr = pq.remove();
			   //mark
			   if(vis[curr.node]) continue;
			   vis[curr.node] = true;

			   lastFound = Math.max(lastFound,curr.cost);
			   // lastFound = curr.cost;

			   for(Edge e: graph[curr.node]){
				   if(!vis[e.nbr]) pq.add(new Pair(e.nbr,curr.cost + e.wt));
			   }
			   
		   }
		   for(int i= 1;i<=N;i++) if(!vis[i]) return -1;
		   return lastFound;
		   
    }
}
















