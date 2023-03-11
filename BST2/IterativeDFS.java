public static void iterativeDFS(TreeNode root){
    Stack<Pair> st = new Stack<>();
    
    st.push(new Pair(root,1));

    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();
    
    while(st.size() > 0){
        Pair top = st.peek();
        if(top.state == 1){
            //pre
            pre.add(top.node.val);
            top.state++;
            if(top.node.left != null) st.push(new Pair(top.node.left,1));
        }else if(top.state == 2){
            //in
            in.add(top.node.val);
            top.state++;
            if(top.node.right != null) st.push(new Pair(top.node.right,1));
        }else{
            //post
            post.add(top.node.val);
            st.pop();
        }
    }
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
}