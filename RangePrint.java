
public class RangePrint {
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
        public static void inorder(Node root){
            if(root==null){
                return;

            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void print(Node root,int r1,int r2){
            if(root==null ){
                return ;
            }
            if(root.data>r1 && root.data<r2){
                print(root.left,r1,r2);
                System.out.print(root.data);
                print(root.right,r1,r2);
            }
            else if(root.data>r2){
                print(root.left,r1,r2);
            }
            else{
                print(root.right,r1,r2);
            }
        }
    
    
    }
    public static void main(String[] args) {
        int a[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<a.length;i++){
           root= BST.buildBST(root,a[i]);
        }
        BST.inorder(root);
        System.out.println();
        BST.print(root, 5, 12);
     
    }
}
