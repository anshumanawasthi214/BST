public class Bst_Search {
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

            public static boolean search(Node root,int val){
                if(root==null){
                    return false;
                }
                if(root.data==val){
                    return true;
                }
               if(val>root.data){
                return search(root.right,val);
               }
               else{
               return search(root.left,val);
               }
               
        }
    }
        public static void main(String[] args) {
            int a[]={5,1,4,3,2,7};
            Node root=null;
            for(int i=0;i<a.length;i++){
               root= BST.buildBST(root,a[i]);
            }
            System.err.println(BST.search(root,5));
}
}
