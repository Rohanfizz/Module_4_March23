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
		public class Edge{
			int nbr;
			int wt;
			Edge(int n,int w){
				this.nbr = n;
				this.wt = w;
			}
		}
	public class Pair{
		int node;
		int cost;
		Pair(int node,int cost){
			this.node = node;
			this.cost = cost;
		}
	}
       public int networkDelayTime(int[][] times, int N, int K) {
        //Write code here
		   ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		   for(int i = 0;i<=N;i++){
			   graph.add(new ArrayList<Edge>());
		   }
		   for(int[] e: times){
			   int src = e[0];
			   int nbr = e[1];
			   int wt = e[2];
			   graph.get(src).add(new Edge(nbr,wt));
		   }

		   PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			   return a.cost-b.cost;
		   });

		   boolean[] vis = new boolean[N+1];
		   pq.add(new Pair(K,0));
			int maxTime = 0;
		   while(pq.size()>0){
			   Pair curr = pq.remove();
			   if(vis[curr.node]) continue;
			   vis[curr.node] = true;
			   maxTime = Math.max(maxTime,curr.cost);

			   for(Edge e: graph.get(curr.node)){
				   if(!vis[e.nbr]) pq.add(new Pair(e.nbr,curr.cost+e.wt));
			   }
		   }
		   for(int i = 1;i<=N;i++) if(!vis[i]) return -1;
		   return maxTime;
    }
}










