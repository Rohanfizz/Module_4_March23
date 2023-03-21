import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {
	void dfs(ArrayList<ArrayList<Integer>> graph,int curr,boolean[] vis){
		vis[curr] = true;
		
		for(int j = 0;j<graph.get(curr).size();j++){
			if(graph.get(curr).get(j) == 1){
				//this means that j is the neighbout of curr node
				if(!vis[j]) dfs(graph,j,vis);
			}
		}
	}
    int components(ArrayList<ArrayList<Integer>> graph, int N) { 
       //Your code here
		int cnt = 0;
		boolean[] vis= new boolean[N];
		for(int i= 0;i<N;i++){
			if(vis[i]) continue;
			cnt++;
			dfs(graph,i,vis);
		}
		return cnt;
    }
};
















