public class DeleteNode {
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

        public static Node delete(Node root,int val){
            if(root==null){
                return null;
            }
            if(root.data<val){
               root.right=delete(root.right,val); 
            }
            else if(root.data>val){
                root.left=delete(root.left, val);
            }
            else{

                // case 1 --------leaf node
                if(root.left==null && root.right==null){
                    return null;
                }

                //case 2 -----Single child

                if(root.right==null){
                    return root.left;
                }
                else if(root.left==null){
                    return root.right;
                }

                //case 3 ---both child

                Node inorderSucc=findSuccessor(root.right);
                root.data=inorderSucc.data;
                root.right=delete(root.right, inorderSucc.data);
            }
            return root;
    }
    
    public static Node findSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    }
    public static void main(String[] args) {
        int a[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<a.length;i++){
           root= BST.buildBST(root,a[i]);
        }
        BST.inorder(root);

        BST.delete(root, 5);
        System.out.println();
        BST.inorder(root);
    }
}
