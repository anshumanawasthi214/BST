import java.util.ArrayList;

public class MirrorBST {
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
        public static Node mirror(Node root){
            if(root==null){
                return null;
            }
             Node lm=mirror(root.left);
             Node rm=mirror(root.right);
            root.left=rm;
            root.right=lm;
            return root;
           
        }
        public static void preorder(Node root){
            if(root==null){
                return ;
            }
            System.out.print(root.data+" ");

            preorder(root.left);
            preorder(root.right);
        }
        

       
       }
    public static void main(String[] args) {
        int a[]={8,5,6,3,10,11};
        Node root=null;
        for(int i=0;i<a.length;i++){
           root= BST.buildBST(root,a[i]);
        }
        BST.preorder(root);
        System.out.println();
        BST.mirror(root);
        BST.preorder(root);
    }
}
