import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    static Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt(); 
        }

        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
            
        Solution A = new Solution();
        ArrayList<Integer> ans=A.levelOrder(root);
        for(Integer num:ans)
            System.out.print(num+" ");

        System.out.println();

        
    }
}

class Solution
{
    //Function to return the level order traversal of a tree.
	//https://course.acciojob.com/idle?question=4aa994c4-b502-4fe1-bf88-786694b0e9aa
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Node> q= new LinkedList<>();
		q.add(root);

		while(q.size()>0){
			Node curr = q.remove();
			res.add(curr.data);
			if(curr.left != null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
		}
		return res;
    }
}














