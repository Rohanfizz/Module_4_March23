
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			  tree.preorderTraversal(root);
            
		
	}
}
  


class Solution {

	

	public static void preorderTraversal(Node root) {
		//Write your code here 
		Node curr = root;
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();

		while(curr!=null){
			if(curr.left == null){
				//preorder work
				System.out.print(curr.data+" ");
				//inorder work
				in.add(curr.data);

				curr = curr.right;
			}else{
				Node rmc = curr.left;//i want rightmost child from the left subtree
				while(rmc.right != null && rmc.right != curr) rmc = rmc.right;

				//this loop will break by only 2 possible conditions
				if(rmc.right == null){
					//we are visiting this node for the first time and there is no lnk present between rmc and curr]
					//pre order work
					System.out.print(curr.data+" ");
					rmc.right = curr;
					curr =curr.left;
				}else if(rmc.right == curr){
					//we are already having a link between rmc and curr, this link might have been made by us when we came on this node for the first time, this means we are visiting this node for the second time
					//inorder work
					in.add(curr.data);
					rmc.right = null;
					curr = curr.right;
				}
			}
		}
		// System.out.println(pre);
		// System.out.println(in);

        
	}
}














