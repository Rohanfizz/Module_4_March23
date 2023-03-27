import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
	public class Node{
		char c;
		int freq;
		Node left = null;
		Node right =null;
		Node(char c,int freq){
			this.c = c;
			this.freq = freq;
		}
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Code here
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
			return a.freq<b.freq?-1:1;
		});
		//add all the characters as nodes in priorityqueue
		for(int i = 0;i<N;i++){
			char c = S.charAt(i);
			int freq = f[i];
			pq.add(new Node(c,freq));
		}

		while(pq.size()>1){
			//remove the 2 min freq nodes
			Node smaller = pq.remove();
			Node larger = pq.remove();

			Node nn  = new Node('*',smaller.freq+larger.freq);
			nn.left = smaller;
			nn.right = larger;
			pq.add(nn);
		}
		//we are pretty sure that the only node remaining in the pq is the root of the huffman tree
		Node root = pq.remove();

		ArrayList<String> res = new ArrayList<>();
		dfs(root,res,"");
		return res;
    }

	public void dfs(Node root,ArrayList<String> res,String psf){
		if(root.left == null && root.right == null){
			res.add(psf);
			return;
		}
		dfs(root.left,res,psf+"0");
		dfs(root.right,res,psf+"1");
	}
    
}