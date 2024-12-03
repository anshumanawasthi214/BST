import java.util.ArrayList;

public class Root_to_leaf {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            
        }
    }

    static class BST{
        public static Node buildBST(Node root,int val){
            if(root==null){
             root=new Node(val);
                return root;
            }
            if(root.data<val){
                root.right=buildBST(root.right, val);
            }
            else{
                root.left=buildBST(root.left, val);
            }
            
            return root;
        }
        
       public static void rootToLeaf(Node root,ArrayList<Integer> arr){
        if(root==null){
            return ;
        }
        arr.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(arr);
        }
        rootToLeaf(root.left,arr);
        arr.removeLast();
        rootToLeaf(root.right,arr);

    }
        

       
       }
    
    
    
    
    public static void main(String[] args) {
        int a[]={8,5,3,6,10,11,14};
        Node root=null;
        for(int i=0;i<a.length;i++){
           root= BST.buildBST(root,a[i]);
        }
        System.out.println();
        ArrayList<Integer> arr=new ArrayList<>();

        BST.rootToLeaf(root,arr);

      
     
    }
}
