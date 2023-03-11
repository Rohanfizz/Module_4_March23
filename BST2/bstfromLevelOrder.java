import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {

	class Helper{
		Node parent;
		int left;
		int right;
		Helper(Node p,int l,int r){
			this.parent = p;
			this.left = l;
			this.right = r;
		}
	}
	
    Node bstFromLevel(int arr[], int n) {
        // write code here
		Queue<Helper> q = new LinkedList<>();
		
		Node root = new  Node(arr[0]);
		int idx = 1;

		q.add(new Helper(root,Integer.MIN_VALUE,root.data-1));
		q.add(new Helper(root,root.data+1,Integer.MAX_VALUE));

		while(q.size()>0){

			Helper front = q.remove();
			
			Node parent = front.parent;
			int left = front.left;
			int right = front.right;

			if(idx == n) continue;
			if(arr[idx] < left || arr[idx] > right) continue;
			//if im standing on line 85, this means i belong to the range
			//now i have to check if i am left or right child of the parent

			Node me = new Node(arr[idx]);
			idx++;
			
			if(me.data < parent.data){
				//i am left child
				parent.left = me;
			}else{
				//i am right child
				parent.right = me;
			}
			//for the left child
			q.add(new Helper(me,left,me.data-1));
			// for the right child
			q.add(new Helper(me,me.data+1,right));
			
		}
		return root;
		
    }
}



