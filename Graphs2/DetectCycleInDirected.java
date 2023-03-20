import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public boolean dfs(ArrayList<Integer>[] graph,boolean[] vis,boolean[] path,int curr){
		vis[curr] = true;
		path[curr] = true;

		for(int nbr:graph[curr]){
			if(!vis[nbr]){
				boolean cycleFound = dfs(graph,vis,path,nbr);
				if(cycleFound) return true;
			}else if(vis[nbr] && !path[nbr]) continue;
			else if(vis[nbr] && path[nbr]) return true;//snake cuts itself
		}
		path[curr] = false;
		return false;
	}
public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
    // Your code here
	boolean[] vis = new boolean[V];
	boolean[] path = new boolean[V];

	for(int i = 0;i<V;i++){
		if(vis[i]) continue;
		boolean cycleFound = dfs(graph,vis,path,i);
		if(cycleFound) return true;
	}
	return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}