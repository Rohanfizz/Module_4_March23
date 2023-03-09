
import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
	public int min(Node root){
		Node temp = root;
		while(temp.left != null) temp = temp.left;
		return temp.val;
	}
    public Node deleteNode(Node root, int val){
        // WRITE YOUR CODE HERE]
		if(root == null) return null;
		if(val < root.val){  // find the val to be deleted
			root.left = deleteNode(root.left,val);
			return root;
		}else if(val > root.val){
			root.right = deleteNode(root.right,val);
			return root;
		}else{// i have found the node, this node should be deleted
			if(root.left== null && root.right == null){//leaf node
				return null;
			}else if(root.left == null && root.right!=null){//i have only left child
				return root.right;
			}else if(root.left != null && root.right == null){//i have only right child
				return root.left;
			}else{//having both children
				//minimum val from my right subtree
				int minFromRight = min(root.right);
				root.val = minFromRight;
				root.right = deleteNode(root.right,minFromRight);
				return root;
			}
		}
		
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}