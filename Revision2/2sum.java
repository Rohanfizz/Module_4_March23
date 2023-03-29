import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(int item){
        val = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)return null;
        int mid=(start+end)/2;
        if(root==null)root=new Node(arr[mid]);
        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);
        return root;
    }
}

class Solution{

	public static class Pair{
		Node node;
		int state;
		Pair(Node node,int state){
			this.node = node;
			this.state = state;
		}
	}
	
	public static Node getNextLeftInorder(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				//inorder
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else if(top.state == 3){
				st.pop();
			}
		}
		return null;
	}

	public static Node getNextRightInorder(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//reverse postorder
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
			}else if(top.state == 2){
				//reverse inorder
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
				return top.node;
			}else if(top.state == 3){
				st.pop();
			}
		}
		return null;
	}
	
    public static boolean checkTarget(Node root, int k){
        //write code here
		Stack<Pair> leftStack = new Stack<>();
		Stack<Pair> rightStack = new Stack<>();

		leftStack.push(new Pair(root,1));
		rightStack.push(new Pair(root,1));

		Node left = getNextLeftInorder(leftStack);
		Node right = getNextRightInorder(rightStack);

		while(left.val < right.val){
			int sum = left.val+right.val;
			if(sum == k) return true;
			else if(sum > k){
				right = getNextRightInorder(rightStack);
			}else{
				left = getNextLeftInorder(leftStack);
			}
		}
		return false;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); 
        }
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        boolean ans = A.checkTarget(root,k);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}