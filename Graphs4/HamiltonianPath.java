import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean hamiltonian(int src,int osrc,boolean[] path,ArrayList<Integer> psf,ArrayList<ArrayList<Integer>> graph){
		//add and mark
		psf.add(src);
		path[src] = true;

		//if we have visited all the nodes exactly once
		// graph.size()-1 because graph is of N+1 size and in the end psf will be having N nodes.
		//1 based indexing
		if(psf.size() == graph.size()-1){
			
			System.out.print(psf);
			//i have to check for a cycle
			
			// boolean cycleFound = false;
			for(int nbr: graph.get(src)){
				if(nbr == osrc) cycleFound = true;
			}
			if(cycleFound) System.out.print(" (Cycle)");
			System.out.println();
			
			//remove and unmark
			psf.remove(psf.size()-1);
			path[src] = false;
			return true;
		}

		//try neighbours
		for(int nbr: graph.get(src)){
			if(!path[nbr]){
				boolean pathFound = hamiltonian(nbr,osrc,path,psf,graph);
				if(pathFound == true) return true;
			}
		}

		//remove and unmark
		psf.remove(psf.size()-1);
		path[src] = false;
		return false;
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
		//creating a graph (1 based indexing)
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0;i<N+1;i++) graph.add(new ArrayList<Integer>());
		for(ArrayList<Integer> edge:Edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		//we want specific paths,thats why we need a path array not a visited array
		//while backtracking we mark the current node as false in path array
		boolean[] path  = new boolean[N+1];

		ArrayList<Integer> psf= new ArrayList<>(); //to keep the track of all the nodes in my path in order

		for(int src = 1;src<=N;src++){
			boolean pathFound = hamiltonian(src,src,path,psf,graph);
			if(pathFound) return true;
		}
		
	    return false;
    }
}
















    