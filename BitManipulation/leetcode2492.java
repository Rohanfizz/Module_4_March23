class Solution {
    public class Pair{
        int nbr;
        int wt;
        Pair(int nbr,int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public int dfs(int node,boolean[] vis,ArrayList<ArrayList<Pair>> graph){
        vis[node] = true;
        int minWtFound = Integer.MAX_VALUE;
        for(Pair e: graph.get(node)){
            int nbr = e.nbr;
            int wt = e.wt;
            minWtFound = Math.min(minWtFound,wt);
            if(!vis[nbr]) minWtFound = Math.min(minWtFound,dfs(nbr,vis,graph));
        }
        return minWtFound;
    }

    public int minScore(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0;i<=n;i++) graph.add(new ArrayList<Pair>());

        for(int[] e: edges){
            graph.get(e[0]).add(new Pair(e[ 1],e[2]));
            graph.get(e[1]).add(new Pair(e[0],e[2]));
        }
        boolean[] vis = new boolean[n+1];
        int mini = dfs(1,vis,graph);
        return mini;
    }
}