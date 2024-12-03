public class validateBST {
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

      public static boolean isValid(Node root,Node max,Node min){
             if(root==null){
                    return true;
                }
                
                if(min!=null && root.data<=min.data){
                    return false;
                }
                if(max!=null && root.data>=max.data){
                    return false;
                }
    
                return isValid(root.left, root, min) && isValid(root.right, max, root);
          
        }
           
    }
    public static void main(String[] args) {
        int a[]={1,1,1};
        Node root=null;
        for(int i=0;i<a.length;i++){
           root= BST.buildBST(root,a[i]);
        }
        System.out.println();
        System.out.println(BST.isValid(root,null,null));
    }
}
